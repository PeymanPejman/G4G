// Minheap to LinkedList
import java.util.*;

public class Solution {

    static class BSTNode {
        BSTNode left;
        BSTNode right;
        Integer data;
        BSTNode(Integer data) {this.data = data;}
    }

    public static void main(String[] args) {
        BSTNode root = new BSTNode(1);
        BSTNode two = new BSTNode(2);
        BSTNode three = new BSTNode(3);

        root.left = two; root.right = three;

        BSTNode head = convertToLL(root);
        printLL(head);
    }

    private static BSTNode convertToLL(BSTNode n) {
        if(n == null) {
            return n;
        }

        BSTNode head;
        BSTNode prev;
        PriorityQueue<BSTNode> q = new PriorityQueue<>(new Comparator<BSTNode>() {
            public int compare(BSTNode n1, BSTNode n2) {
                return Integer.compare(n1.data, n2.data);
            }
        }); 

        head = n;
        prev = head;
        if(n.left != null) q.add(n.left);
        if(n.right != null) q.add(n.right);

        while(!q.isEmpty()) {
            BSTNode parent = q.poll();
            prev.right = parent;
            if(parent.left != null) q.add(parent.left);
            if(parent.right != null) q.add(parent.right);
            prev = parent;
        }

        return head;
    }

    private static void printLL(BSTNode n) {
        while(n != null) {
            System.out.println(n.data);
            n = n.right; 
        }
    }
}