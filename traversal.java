import java.util.*;

public class Traversal {

    // Breadth-First Search (Queue)
    public static void bfs(Graph graph, String start) {
        if (!graph.getAdjacencyList().containsKey(start)) {
            System.out.println("Start location not found!");
            return;
        }

        Set<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();

        visited.add(start);
        queue.add(start);

        System.out.println("\nBFS Traversal starting from " + start + ":");
        while (!queue.isEmpty()) {
            String current = queue.poll();
            System.out.print(current + " ");

            for (String neighbor : graph.getAdjacencyList().get(current)) {
                if (!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    queue.add(neighbor);
                }
            }
        }
        System.out.println();
    }

    // Depth-First Search (Stack)
    public static void dfs(Graph graph, String start) {
        if (!graph.getAdjacencyList().containsKey(start)) {
            System.out.println("Start location not found!");
            return;
        }

        Set<String> visited = new HashSet<>();
        Stack<String> stack = new Stack<>();

        stack.push(start);
        System.out.println("\nDFS Traversal starting from " + start + ":");

        while (!stack.isEmpty()) {
            String current = stack.pop();
            if (!visited.contains(current)) {
                visited.add(current);
                System.out.print(current + " ");

                for (String neighbor : graph.getAdjacencyList().get(current)) {
                    stack.push(neighbor);
                }
            }
        }
        System.out.println();
    }
}
