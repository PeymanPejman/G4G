//https://www.geeksforgeeks.org/sorted-linked-list-to-balanced-bst/

import java.util.*;

public class Solution {
    public static LNode head;

    static class BSTNode {
        BSTNode left;
        BSTNode right;
        Integer data;
        BSTNode(Integer data) {this.data = data;}
    }

    static class LNode {
        LNode next;
        Integer data;
        LNode(Integer data) {this.data = data;}
    }

    public static void main(String[] args) {
        head = new LNode(1);
        head.next = new LNode(2);
        head.next.next = new LNode(3);
        head.next.next.next = new LNode(4);
        head.next.next.next.next = new LNode(5);
        head.next.next.next.next.next = new LNode(6);
        head.next.next.next.next.next.next = new LNode(7);

        BSTNode root = linkedlistToBST(head);
        printPreorder(root);
    }

    private static BSTNode linkedlistToBST(LNode head) {
        int n = lenLinkedlist(head);
        BSTNode root = constructBST(n);
        return root;
    }

    private static BSTNode constructBST(int n) {
        if(n <= 0) {
            return null;
        }

        BSTNode left = constructBST(n/2);
        
        BSTNode root = new BSTNode(head.data);
        root.left = left;
        head = head.next;
        
        BSTNode right = constructBST(n - n/2 - 1);
        root.right = right;

        return root; 
    }

    private static int lenLinkedlist(LNode n) {
        int count = 0;
        while(n != null) {
            count++;
            n = n.next;
        }
        return count;
    }
    private static void printPreorder(BSTNode node) {
        if (node == null) {
            return;
        }
        System.out.println(node.data + " ");
        printPreorder(node.left);
        printPreorder(node.right);
    }
}