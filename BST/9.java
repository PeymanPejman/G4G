//https://www.geeksforgeeks.org/construct-bst-given-level-order-traversal/

import java.util.*;

public class Solution {
    static class BSTNode {
        BSTNode left;
        BSTNode right;
        Integer data;
        BSTNode(Integer data) {this.data = data;}
    }

    static class NDetails {
        BSTNode node;
        int min;
        int max;
        NDetails(int min, int max, BSTNode node) {
            this.min = min; this.max = max; this.node = node;
        }
    }

    public static void main(String[] args) {
        int[] arr = {7, 4, 12, 3, 6, 8, 1, 5, 10};
        BSTNode root = constructBST(arr);
        printInorder(root);

    }
    private static BSTNode constructBST(int[] arr) {
        if(arr.length == 0) return null;
        int ptr = 0;
        BSTNode root = new BSTNode(arr[ptr++]);
        Deque<NDetails> q = new LinkedList<>();
        q.add(new NDetails(Integer.MIN_VALUE, Integer.MAX_VALUE, root));

        while(!q.isEmpty() && ptr < arr.length) {
            NDetails parent = q.poll();
            if(arr[ptr] > parent.min && arr[ptr] < parent.node.data) {
                BSTNode left = new BSTNode(arr[ptr]);
                parent.node.left = left;
                ptr++;
                q.add(new NDetails(parent.min, parent.node.data, left));
            }

            if(ptr < arr.length && arr[ptr] < parent.max && arr[ptr] > parent.node.data) {
                BSTNode right = new BSTNode(arr[ptr]);
                parent.node.right = right;
                ptr++;
                q.add(new NDetails(parent.node.data, parent.max, right));
            }
        }
        return root;
    }

    private static void printInorder(BSTNode n) {
        if(n == null) {
            return;
        }

        printInorder(n.left);
        System.out.println(n.data + " , ");
        printInorder(n.right);
    }
}