//https://www.geeksforgeeks.org/write-a-function-to-get-the-intersection-point-of-two-linked-lists/

import java.util.*;

public class Solution {
    class Node {
        Node next;
        T data;

        Node(T d) { data = d; next = null;}
    }

    public static void main(String[] args) {
    }

    private static Node getIntersection(Node n1, Node n2) {
        Set<Node> visited = new HashSet<>();

        while(n1 == null && n2 == null) {
            if(n1 != null && !visited.add(n1)) {
                return n1;
            }

            if(n2 != null && !visited.add(n2)) {
                return n2;
            }

            if(n1 != null)
                n1 = n1.next;
            if(n2 != null)
                n2 = n2.next;
        }

        return null;
    }
    
}