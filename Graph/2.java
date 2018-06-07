//https://www.geeksforgeeks.org/depth-first-search-or-dfs-for-a-graph/ 

import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Map<Integer, Set<Integer>> graph = new HashMap<>();
        graph.put(1, new HashSet<Integer>(Arrays.asList(2)));
        graph.put(0, new HashSet<Integer>(Arrays.asList(1, 2)));
        graph.put(2, new HashSet<Integer>(Arrays.asList(0, 3)));
        graph.put(3, new HashSet<Integer>(Arrays.asList(3)));

        System.out.println(DFS(graph, 2));
    }

    private static List<Integer> DFS(Map<Integer, Set<Integer>> graph, int s) {
        Set<Integer> visited = new HashSet<>();
        List<Integer> result = new ArrayList<>();
        DFSHelper(graph, s, visited, result);

        return result; 
    }

    private static void DFSHelper(Map<Integer, Set<Integer>> graph, int s, Set<Integer> visited, List<Integer> result) {
        if(!visited.add(s))
            return;

        result.add(s);

        for(Integer neighbor : graph.get(s)) {
            DFSHelper(graph, neighbor, visited, result);
        }
    }
}