//https://www.geeksforgeeks.org/in-place-convert-bst-into-a-min-heap/

import java.util.*;

public class Solution {
    static BSTNode head;
    static BSTNode prev;

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

        /*List<Integer> minHeap = convertToMinHeap(root);
        System.out.println(minHeap);*/
    }

    private static void convertToMinHeap(BSTNode n) {
        head = null; 
        prev = null;
        convertToLL(n);
        BSTNode root = null;
        convertLLtoMinHeap(head, root);
    }

    private static void convertLLtoMinHeap(BSTNode n, BSTNode root) {
        if(head == null)
            return;
    
        root = head;
        head = head.right;

        root.right = null;

        Deque<BSTNode> q = new LinkedList<>();

        q.add(root);

        while(head != null) {
            BSTNode parent = q.poll();
            
            BSTNode leftChild = head;
            leftChild.right = null;
            q.add(leftChild);

            parent.left = leftChild;

            if(head != null) {
                BSTNode rightChild = head;
                head = head.right;
                rightChild.right = null;
                q.add(rightChild);

                parent.right = rightChild;
            }

        }
    }

    private static void convertToLL(BSTNode n) {
        if(n == null)
            return;
        BSTNode right = convertToLL(n.left);
        if(prev == null) {
            head = n;
        } else {
            prev.right = n;
            n.left = prev;
        }
        prev = n;
        BSTNode left = convertToLL(n.left);
    }

    /* Using extra memory
    private static List<Integer> convertToMinHeap(BSTNode n) {
        List<Integer> minHeap = new ArrayList<>();

        inorderWalk(minHeap, n);

        return minHeap;
    }

    private static void inorderWalk(List<Integer> minHeap, BSTNode n) {
        if(n == null) {
            return;
        }

        inorderWalk(minHeap, n.left);
        minHeap.add(n.data);
        inorderWalk(minHeap, n.right);
    }*/
}