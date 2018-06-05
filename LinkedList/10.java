//https://www.geeksforgeeks.org/reverse-doubly-linked-list-set-2/

import java.util.*;

public class Solution {
    class Node {
        Node next;
        Node prev;
        T data;

        Node(T d) { data = d; next = null;}
    }

    public static void main(String[] args) {
    }

    private static Node reverseList(Node head) {
        if(head == null || head.next == null)
            return head;

        Node iter = head;
        Node nextNode = iter.next;
        while(nextNode != null) {
            Node temp = iter.prev;
            iter.prev = iter.next;
            iter.next = temp;
            iter = nextNode;
            nextNode = nextNode.next;
        }
    }
}