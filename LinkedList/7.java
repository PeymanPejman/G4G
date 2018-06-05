//https://www.geeksforgeeks.org/detect-loop-in-a-linked-list/
import java.util.*;

public class Solution {
    class Node {
        Node next;
        T data;

        Node(T d) { data = d; next = null;}
    }

    public static void main(String[] args) {
    }

    private static boolean hasLoop(Node n) {
        SeT<Node> visited = new HashSet<>();

        while(n != null) {
            if(!visited.add(n))
                return true;
            n = n.next;
        }
    }
}