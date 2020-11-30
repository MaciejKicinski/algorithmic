
public class BinaryTree {
    Node root;

    private Node addRecursive(Node current, int value) {
        if (current == null) {
            return new Node(value);
        }
        if (value < current.value) {
            current.left = addRecursive(current.left, value);
        } else if (value > current.value) {
            current.right = addRecursive(current.right, value);
        } else {
            // value already exists
            return current;
        }
        return current;
    }

    public void add(int value) {
        root = addRecursive(root, value);
    }

    int maxDepth(Node root) {
        if (root == null)
            return 0;
        // Get the depth of the left and right subtree
        // using recursion.
        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);
        // Choose the larger one and add the root to it.
        if (leftDepth > rightDepth)
            return (leftDepth + 1);
        else
            return (rightDepth + 1);
    }

    int maxDepthValue(Node root) {
        if (root == null)
            return 0;
        // Get the depth of the left and right subtree
        // using recursion.
        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);
        // Choose the larger one and add the root to it.
        if (leftDepth > rightDepth)
            return (root.left.value);
        else
            return (root.right.value);
    }

    public Node search(Node root, int key) {
        // Base Cases: root is null or key is present at root
        if (root == null || root.value == key)
            return root;

        // Key is greater than root's key
        if (root.value < key)
            return search(root.right, key);

        // Key is smaller than root's key
        return search(root.left, key);
    }

    private Node deleteNode(Node root, Integer data) {

        if (root == null) return root;

        if (data < root.value) {
            root.setLeft(deleteNode(root.left, data));
        } else if (data > root.value) {
            root.setRight(deleteNode(root.right, data));
        } else {
            // node with no leaf nodes
            if (root.left == null && root.right == null) {
                return null;
            } else if (root.left == null) {
                // node with one node (no left node)
                return root.right;
            } else if (root.right == null) {
                // node with one node (no right node)
                return root.left;
            } else {
                // nodes with two nodes
                // search for min number in right sub tree
                Integer minValue = minValue(root.right);
                root.setValue(minValue);
                root.setRight(deleteNode(root.right, minValue));
            }
        }
        return root;
    }

    private Integer minValue(Node node) {
        if (node.left != null) {
            return minValue(node.left);
        }
        return node.value;
    }

    public void delete(Node root, Integer data) {
        deleteNode(this.root, data);
    }
}