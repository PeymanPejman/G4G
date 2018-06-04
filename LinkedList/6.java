//https://www.geeksforgeeks.org/function-to-check-if-a-singly-linked-list-is-palindrome/
import java.util.*;

public class Solution {
    class Node {
        Node next;
        T data;

        Node(T d) { data = d; next = null;}
    }

    public static void main(String[] args) {
    }
    
    private static boolean isListPalindromic(Node n) {
        if (n == null || n.next == null)
            return true;

        Node reversedHalfHead = reverseHalf(n);
        Node iter2 = reversedHalfHead.next;
        Node iter1 = n.next;
        while(iter1 != null && iter2 != null && iter1.data ==  iter2.data) {
            iter1 = iter1.next;
            iter2 = iter2.next;
        }

        return iter2 == null && iter1 == null;
    }

    private static Node reverseHalf(Node n) {
        Node iterSlow = n;
        Node iterFast = n;
        
        while(iterFast != null && iterFast.next != null) {
            iterSlow = iterSlow.next;
            iterFast = iterFast.next.next;
        }

        iterSlow.next = null;

        Node prev = null;
        Node iter = iterfast;
        Node next = iterfast.next;

        while(next != null) {
            iter.next = prev;
            prev = iter;
            iter = next.next;
        }

        Node newHead = null;
        newHead.next = iter;

        return newHead;
    }

}