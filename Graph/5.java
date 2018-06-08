//https://www.geeksforgeeks.org/clone-an-undirected-graph/

import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Map<Integer, Set<Integer>> graph = new HashMap<>();
        graph.put(1, new HashSet<Integer>(Arrays.asList(3)));
        graph.put(0, new HashSet<Integer>(Arrays.asList(1, 2)));
        graph.put(4, new HashSet<Integer>(Arrays.asList(1)));
        graph.put(3, new HashSet<Integer>(Arrays.asList()));
        graph.put(6, new HashSet<Integer>(Arrays.asList(4, 0)));
        graph.put(5, new HashSet<Integer>(Arrays.asList(6,2)));
        graph.put(2, new HashSet<Integer>(Arrays.asList()));

        Map<Integer, Set<Integer>> copy = cloneGraph(graph);
        printGraph(graph);
        System.out.println();
        printGraph(copy);
    }

    private static Map<Integer, Set<Integer>> cloneGraph(Map<Integer, Set<Integer>> graph) {
        Map<Integer, Set<Integer>> copy = new HashMap<>();

        for(Map.Entry<Integer, Set<Integer>> entry : graph.entrySet()) {
            BFSandCopy(graph, copy, entry.getKey());
        }

        return copy;
    }

    private static void BFSandCopy(Map<Integer, Set<Integer>> graph, Map<Integer, Set<Integer>> copy, int s) {
        Deque<Integer> q = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        q.add(s);

        while(!q.isEmpty()) {
            int curr = q.poll();
            if(!copy.containsKey(curr))
                copy.put(curr, new HashSet<Integer>());

            for(int neighbor : graph.get(curr)) {
                if(visited.add(neighbor)) {
                    q.add(neighbor);
                    copy.get(curr).add(neighbor);
                }
            }
        }
    }

    private static void printGraph(Map<Integer, Set<Integer>> graph) {
        for(Map.Entry<Integer, Set<Integer>> entry : graph.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
    }
}