//https://www.geeksforgeeks.org/breadth-first-search-or-bfs-for-a-graph/

import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Map<Integer, Set<Integer>> graph = new HashMap<>();
        graph.put(1, new HashSet<Integer>(Arrays.asList(2)));
        graph.put(0, new HashSet<Integer>(Arrays.asList(1, 2)));
        graph.put(2, new HashSet<Integer>(Arrays.asList(0, 3)));
        graph.put(3, new HashSet<Integer>(Arrays.asList(3)));

        System.out.println(BFS(graph, 2));
    }

    private static List<Integer> BFS(Map<Integer, Set<Integer>> graph, int s) {
        List<Integer> result = new ArrayList<>();
        if(!graph.containsKey(s)) return result;

        Deque<Integer> q = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();

        q.add(s);

        while(!q.isEmpty()) {
            Integer vertex = q.poll();

            if(!visited.add(vertex))
                continue;
            result.add(vertex);
            for(Integer neighbor : graph.get(vertex)) {
                q.add(neighbor);
            }
        }

        return result;
     }

}