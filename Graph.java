import java.util.*;

public class Graph {
    private Map<String, List<String>> adjacencyList;

    public Graph() {
        adjacencyList = new HashMap<>();
    }

    // 1️⃣ Add location
    public void addLocation(String location) {
        adjacencyList.putIfAbsent(location, new ArrayList<>());
    }

    // 2️⃣ Remove location
    public void removeLocation(String location) {
        adjacencyList.remove(location);
        for (List<String> list : adjacencyList.values()) {
            list.remove(location);
        }
    }

    // 3️⃣ Add road (edge)
    public void addRoad(String from, String to) {
        if (adjacencyList.containsKey(from) && adjacencyList.containsKey(to)) {
            adjacencyList.get(from).add(to);
            adjacencyList.get(to).add(from);
        } else {
            System.out.println("One or both locations do not exist!");
        }
    }

    // 4️⃣ Remove road
    public void removeRoad(String from, String to) {
        if (adjacencyList.containsKey(from) && adjacencyList.containsKey(to)) {
            adjacencyList.get(from).remove(to);
            adjacencyList.get(to).remove(from);
        }
    }

    // 5️⃣ Display all connections
    public void displayConnections() {
        System.out.println("\n--- City Connections ---");
        for (String location : adjacencyList.keySet()) {
            System.out.println(location + " -> " + adjacencyList.get(location));
        }
    }

    public Set<String> getLocations() {
        return adjacencyList.keySet();
    }

    public Map<String, List<String>> getAdjacencyList() {
        return adjacencyList;
    }
}
