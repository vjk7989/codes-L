import java.util.*;

public class Main {

    private static void dfsRecursive(Map<Integer, List<Integer>> graph, int vertex, Set<Integer> visited) {
        System.out.print(vertex + " ");
        visited.add(vertex);

        List<Integer> neighbors = graph.get(vertex);
        if (neighbors != null) {
            for (int neighbor : neighbors) {
                if (!visited.contains(neighbor)) {
                    dfsRecursive(graph, neighbor, visited);
                }
            }
        }
    }

    public static void dfs(Map<Integer, List<Integer>> graph, int startVertex) {
        Set<Integer> visited = new HashSet<>();
        dfsRecursive(graph, startVertex, visited);
    }

    public static void main(String[] args) {
        //change input as u like
        Map<Integer, List<Integer>> graph = new HashMap<>();
        graph.put(0, Arrays.asList(1, 2));
        graph.put(1, Arrays.asList(3));
        graph.put(2, Arrays.asList(4, 5));
        graph.put(3, Collections.emptyList());
        graph.put(4, Collections.emptyList());
        graph.put(5, Collections.emptyList());

        System.out.println(" (DFS):");
        dfs(graph, 0);
    }
}
