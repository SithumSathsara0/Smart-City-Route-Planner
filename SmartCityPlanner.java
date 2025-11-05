import java.util.*;

public class SmartCityPlanner {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Graph graph = new Graph();
        LocationTree tree = new LocationTree();

        int choice;
        do {
            System.out.println("\n--- Smart City Route Planner ---");
            System.out.println("1. Add a new location");
            System.out.println("2. Remove a location");
            System.out.println("3. Add a road between locations");
            System.out.println("4. Remove a road");
            System.out.println("5. Display all connections");
            System.out.println("6. Display all locations (tree)");
            System.out.println("7. BFS Traversal");
            System.out.println("8. DFS Traversal");
            System.out.println("9. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter location name: ");
                    String loc = sc.nextLine();
                    graph.addLocation(loc);
                    tree.insert(loc);
                    break;

                case 2:
                    System.out.print("Enter location name to remove: ");
                    loc = sc.nextLine();
                    graph.removeLocation(loc);
                    break;

                case 3:
                    System.out.print("Enter first location: ");
                    String from = sc.nextLine();
                    System.out.print("Enter second location: ");
                    String to = sc.nextLine();
                    graph.addRoad(from, to);
                    break;

                case 4:
                    System.out.print("Enter first location: ");
                    from = sc.nextLine();
                    System.out.print("Enter second location: ");
                    to = sc.nextLine();
                    graph.removeRoad(from, to);
                    break;

                case 5:
                    graph.displayConnections();
                    break;

                case 6:
                    tree.displayInOrder();
                    break;

                case 7:
                    System.out.print("Enter start location: ");
                    String startBFS = sc.nextLine();
                    Traversal.bfs(graph, startBFS);
                    break;

                case 8:
                    System.out.print("Enter start location: ");
                    String startDFS = sc.nextLine();
                    Traversal.dfs(graph, startDFS);
                    break;

                case 9:
                    System.out.println("Exiting system... Goodbye!");
                    break;

                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        } while (choice != 9);

        sc.close();
    }
}
