//https://www.geeksforgeeks.org/reverse-a-linked-list/

import java.util.*;

public class Solution {
    class Node {
        Node next;
        T data;

        Node(T d) { data = d; next = null;}
    }

    public static void main(String[] args) {
    }

    private static Node reverseList(Node head) {
        // head <- prev  iter -> nextNode -> null
        if(head == null)
            return head;

        Node prev = null;
        Node iter = head;
        Node nextNode = iter.next;
        
        while(nextNode != null) {
            iter.next = prev;
            prev = iter;
            iter = nextNode;
            nextNode = nextNode.next;
        }

        Node newHead = null;
        newHead.next = iter;
        
        return newHead;
    }
}