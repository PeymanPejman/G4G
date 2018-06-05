//https://www.geeksforgeeks.org/find-length-of-loop-in-linked-list/

import java.util.*;

public class Solution {
    class Node {
        Node next;
        T data;

        Node(T d) { data = d; next = null;}
    }

    public static void main(String[] args) {
    }

    private static int getLoopcount(Node n) {
        Node iterSlow = n;
        Node iterFast = n;

        while(iterFast != null && iterFast.next != null) {
            if(iterSlow == iterFast || iterSlow == iterFast.next)
                break;

            iterFast = iterFast.next.next;
            iterSlow = iterSlow.next;
        }

        //there is no loop 
        if(iterFast != iterSlow || iterfast.next != iterSlow)
            return 0;

        int count = 1;
        iterFast = iterSlow;
        while(iterFast.next != iterSlow) {
            count++;
        }

        return count;
    }
}