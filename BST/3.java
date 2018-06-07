//https://www.geeksforgeeks.org/sorted-array-to-balanced-bst/

import java.util.*;

public class Solution {
    static class BSTNode {
        BSTNode left;
        BSTNode right;
        Integer data;
        BSTNode(Integer data) {this.data = data;}
    }

    public static void main(String[] args) {
        int [] arr = {1, 2, 3, 4, 5, 6, 7, 8};
        BSTNode root = arrayToBST(arr);
        printPreorder(root);
    }

    private static BSTNode arrayToBST(int[] arr) {
        BSTNode root = getRoot(arr, 0, arr.length-1);
        return root;
    }

    private static BSTNode getRoot(int[] arr, int start, int end) {
        if(start > end) {
            return null;
        }

        int mid = (end - start)/2 + start;

        BSTNode root = new BSTNode(arr[mid]);
        root.left = getRoot(arr, start, mid - 1);
        root.right = getRoot(arr, mid+1, end);

        return root;
    }

    private static void printPreorder(BSTNode node) {
        if (node == null) {
            return;
        }
        System.out.print(node.data + " ");
        printPreorder(node.left);
        printPreorder(node.right);
    }
}