class LocationNode {
    String name;
    LocationNode left, right;

    LocationNode(String name) {
        this.name = name;
    }
}

public class LocationTree {
    private LocationNode root;

    // 1️⃣ Insert a new location
    public void insert(String name) {
        root = insertRec(root, name);
    }

    private LocationNode insertRec(LocationNode root, String name) {
        if (root == null) {
            return new LocationNode(name);
        }
        if (name.compareTo(root.name) < 0)
            root.left = insertRec(root.left, name);
        else if (name.compareTo(root.name) > 0)
            root.right = insertRec(root.right, name);
        return root;
    }

    // 2️⃣ Display locations in order
    public void displayInOrder() {
        System.out.println("\n--- All Locations (Alphabetical Order) ---");
        inorderRec(root);
        System.out.println();
    }

    private void inorderRec(LocationNode root) {
        if (root != null) {
            inorderRec(root.left);
            System.out.print(root.name + " ");
            inorderRec(root.right);
        }
    }
}
