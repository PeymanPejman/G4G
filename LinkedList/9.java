//https://www.geeksforgeeks.org/merge-sort-for-linked-list/
import java.util.*;

public class Solution {
    class Node {
        Node next;
        T data;

        Node(T d) { data = d; next = null;}
    }

    public static void main(String[] args) {
    }

    private static Node mergeSort(Node head) {
        if(head == null || head.next == null) {
            return head;
        }

        Node mid = getMiddle(head);
        Node midNext = mid.next;
        mid.next = null;

        Node leftHead = mergeSort(head);
        Node rightHead = mergeSort(midNext);

        Node sortedListHead = merge(leftHead, rightHead);
        return sortedListHead;
    }

    private static Node merge(Node n1, Node n2) {
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
            iter = iter.next;
        }
        if(n1 == null) {
            iter.next = n2;
        } else {
            iter.next = n1;
        }

        return head;
    }

    private static Node getMiNode(Node head) {
        if(head == null)
            return null;
        Node iterSlow = head, iterFast = head;

        while(iterFast != null && iterFast.next != null) {
            iterSlow = iterSlow.next;
            iterFast = iterFast.next.next;
        }

        return iterSlow;
    }
}