//https://www.geeksforgeeks.org/merge-two-sorted-linked-lists/

import java.util.*;

public class Solution {
    class Node {
        Node next;
        T data;

        Node(T d) { data = d; next = null;}
    }

    public static void main(String[] args) {
    }

    private static Node sortedMerge(Node n1, Node n2) {
        if(n1 == null) {
            return n2;
        }

        if(n2 == null) {
            return n1;
        }

        //n1 will be the begining of the list starting with the smaller value
        if(n1.data > n2.data) {
            Node temp = n2; 
            n2 = n1;
            n1 = temp;
        }

        Node head = n1;
        Node iter = n1;
        n1 = n1.next;

        while(n1 != null && n2 != null) {
            if(n1.data <= n2.data) {
                iter.next = n1;
                n1 = n1.next;
            } else {
                iter.next = n2;
                n2 = n2.next;
            }
        }

        if(n1 == null) {
            iter.next = n2;
        } else {
            iter.next = n1;
        }
    }
}

