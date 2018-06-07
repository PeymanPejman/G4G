//https://www.geeksforgeeks.org/segregate-even-and-odd-elements-in-a-linked-list/
import java.util.*;

public class Solution {
    class Node {
        Node next;
        T data;

        Node(T d) { data = d; next = null;}
    }

    private static Node segregateevenandOdd(Node head) {
        Node oddHead = null, evenHead = null, oddIter = null, evenIter = null;
        Node iter = head;

        while(iter != null) {
            if(iter.data % 2  == 0) {
                //if node is the first even, set evenHead
                if(evenHead.next == null) {
                    evenHead.next = iter;
                }
                //add the latest even node to even chain
                evenIter.next = iter;
                evenIter = evenIter.next;
            } else  {
                //if node is the first odd, se oddHead
                if(oddHead.next == null) {
                    oddHead.next = iter;
                }linkedlistToBST

                //add the latest odd node to odd chain
                oddIter.next = iter;
                oddIter = oddIter.next;
            }

            iter = iter.next;
        }

        if (evenHead == null || oddHead == null) {
            return head;
        }

        evenIter.next = oddHead.next;
        oddIter.next = null;
        
        return evenHead;
    }
}