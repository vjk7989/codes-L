import java.util.*;

class Graph {
    private Map<Integer, List<Integer>> adjacencyList;

    public Graph() {
        this.adjacencyList = new HashMap<>();
    }

    public void addEdge(int vertex, int neighbor) {
        this.adjacencyList.computeIfAbsent(vertex, k -> new ArrayList<>()).add(neighbor);
        this.adjacencyList.computeIfAbsent(neighbor, k -> new ArrayList<>()).add(vertex);
    }

    public void bfs(int startVertex) {
        Set<Integer> visited = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();
        
        
        queue.add(startVertex);
        
        
        bfsRecursive(queue, visited);
    }

    private void bfsRecursive(Queue<Integer> queue, Set<Integer> visited) {
        if (queue.isEmpty()) {
            return;
        }

        int currentVertex = queue.poll();
        if (!visited.contains(currentVertex)) {
            System.out.print(currentVertex + " ");
            visited.add(currentVertex);

        
            List<Integer> neighbors = adjacencyList.getOrDefault(currentVertex, Collections.emptyList());
            queue.addAll(neighbors);
        }

        
        bfsRecursive(queue, visited);
    }
}

public class Main {
    public static void main(String[] args) {
        Graph graph = new Graph();

        // Example input 
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 3);
        graph.addEdge(1, 4);
        graph.addEdge(2, 5);

        System.out.println("(BFS) :");
        graph.bfs(0);
    }
}
