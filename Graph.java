import java.util.*;

class Graph {
    private Map<String, List<String>> adjList = new HashMap<>();

    // Add a new location (vertex)
    public void addLocation(String location) {
        adjList.putIfAbsent(location, new ArrayList<>());
    }

    // Remove a location and all connected roads
    public void removeLocation(String location) {
        adjList.remove(location);
        for (List<String> neighbors : adjList.values()) {
            neighbors.remove(location);
        }
    }

    // Add a road (edge) between two locations
    public void addRoad(String src, String dest) {
        if (!adjList.containsKey(src) || !adjList.containsKey(dest)) {
            System.out.println("Both locations must exist before adding a road!");
            return;
        }
        adjList.get(src).add(dest);
        adjList.get(dest).add(src);
    }

    // Remove an existing road
    public void removeRoad(String src, String dest) {
        if (adjList.containsKey(src))
            adjList.get(src).remove(dest);
        if (adjList.containsKey(dest))
            adjList.get(dest).remove(src);
    }

    // Display all connections (edges)
    public void displayConnections() {
        for (String location : adjList.keySet()) {
            System.out.println(location + " -> " + adjList.get(location));
        }
    }

    // Breadth-First Search traversal using Queue
    public void bfs(String start) {
        if (!adjList.containsKey(start)) {
            System.out.println("Location not found!");
            return;
        }

        Set<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        visited.add(start);
        queue.add(start);

        System.out.print("BFS Traversal: ");
        while (!queue.isEmpty()) {
            String current = queue.poll();
            System.out.print(current + " ");
            for (String neighbor : adjList.get(current)) {
                if (!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    queue.add(neighbor);
                }
            }
        }
        System.out.println();
    }
}
