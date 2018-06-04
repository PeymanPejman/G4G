//https://www.geeksforgeeks.org/make-middle-node-head-linked-list/

import java.util.*;

public class Solution {
    class Node {
        Node next;
        T data;

        Node(T d) { data = d; next = null;}
    }

    private static void makeMidlleHead(Node n) {
        // Get middle, set new head to middle, delete middle

        Node middleMinusOne = getMiddleMinusOne(n);
        Node oldHead = n.next;
        n.next = middleMinusOne.next; 
        middleMinusOne.next = middleMinusOne.next.next;
        n.next.next = oldHead;
    }

    private static Node getMiddleMinusOne(Node n) {
        Node iterslow = n;
        Node iterFast = n;
        
        while(iterfast != null && iterfast.next != null) {
            iterslow = iterslow.next;
            iterfast = iterfast.next.next;
        }

        return iterslow;
    }
}