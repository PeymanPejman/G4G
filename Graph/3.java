//https://www.geeksforgeeks.org/find-a-mother-vertex-in-a-graph/

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

        System.out.println(findMotherVertex(graph));
    }

    private static Integer findMotherVertex(Map<Integer, Set<Integer>> graph) {
        Set<Integer> visited = new HashSet<>();
        Integer lastVertex =  null;

        for(Map.Entry<Integer, Set<Integer>> entry : graph.entrySet()) {
            if(visited.contains(entry.getKey()))
                continue;
            DFS(entry.getKey(), graph, visited);
            lastVertex = entry.getKey();
        }

        visited = new HashSet<Integer>();
        DFS(lastVertex, graph, visited);

        return visited.size() == graph.size() ? lastVertex : null;
    }

    private static void DFS(int v, Map<Integer, Set<Integer>> graph, Set<Integer> visited) {
        if(!visited.add(v))
            return;

        for(Integer neighbor : graph.get(v)) {
            DFS(neighbor, graph, visited);
        }
    }
}