//https://www.geeksforgeeks.org/bst-tree-sum-smaller-keys/

import java.util.*;

public class Solution {
    static int sum;

    static class BSTNode {
        BSTNode left;
        BSTNode right;
        Integer data;
        BSTNode(Integer data) {this.data = data;}
    }

    public static void main(String[] args) {
        BSTNode root = new BSTNode(11);
        BSTNode two = new BSTNode(2);
        BSTNode one = new BSTNode(1);
        BSTNode seven = new BSTNode(7);
        BSTNode twentynine = new BSTNode(29);
        BSTNode fifteen = new BSTNode(15);
        BSTNode forty = new BSTNode(40);
        BSTNode thirtyfive = new BSTNode(35);

        root.left = two; root.right = twentynine;
        two.left = one; two.right = seven;
        twentynine.left = fifteen; twentynine.right = forty;
        forty.left = thirtyfive;

        smallerSumTree(root);
        printInorder(root);
    }

    private static void smallerSumTree(BSTNode n) {
        sum = 0;
        inorderAssignment(n);
    }

    private static void inorderAssignment(BSTNode n) {
        if(n == null)
            return;

        inorderAssignment(n.left);

        sum += n.data;
        n.data = sum - n.data;

        inorderAssignment(n.right);
    }

    private static void printInorder(BSTNode n) {
        if(n == null)
            return;

        printInorder(n.left);
        System.out.print(n.data + " , ");
        printInorder(n.right);
    }
}