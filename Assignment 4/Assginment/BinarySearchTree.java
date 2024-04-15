package Assginment;

class Node {
    int key; // the key contained in the node
    Node left, right;// pointers to the left and right child nodes
    
    // Constructor to create a new node with a given key
    public Node(int item) {
        key = item;
        left = right = null;
    }
}

public class BinarySearchTree {
    Node root; // root of the BST
 
    // Constructor initializes the root to null
    BinarySearchTree() {
        root = null;
    }

    // A utility method to insert a new key in the BST
    void insert(int key) {
        root = insertRec(root, key);
    }

    // A recursive function to insert a new key in BST
    Node insertRec(Node root, int key) {
        // If the tree is empty, return a new node
        if (root == null) {
            root = new Node(key);
            return root;
        }

        // Otherwise, recur down the tree
        if (key < root.key)
            root.left = insertRec(root.left, key);
        else if (key > root.key)
            root.right = insertRec(root.right, key);

        // Return the unchanged node pointer
        return root;
    }

    // This method calls deleteRec()
    void deleteKey(int key) {
        root = deleteRec(root, key);
    }

    // A recursive function to delete a key from BST
    Node deleteRec(Node root, int key) {
        // Base Case: If the tree is empty
        if (root == null) return root;

        // Otherwise, recur down the tree
        if (key < root.key)
            root.left = deleteRec(root.left, key);
        else if (key > root.key)
            root.right = deleteRec(root.right, key);

        // If key is same as root's key, then this is the node to be deleted
        else {
            // Node with only one child or no child
            if (root.left == null)
                return root.right;
            else if (root.right == null)
                return root.left;

            // Node with two children: Get the inorder successor (smallest in the right subtree)
            root.key = minValue(root.right);

            // Delete the inorder successor
            root.right = deleteRec(root.right, root.key);
        }

        return root;
    }

    int minValue(Node root) {
        int minValue = root.key;
        while (root.left != null) {
            minValue = root.left.key;
            root = root.left;
        }
        return minValue;
    }

    // A utility method to search a given key in BST
    public Node search(Node root, int key) {
        // Base Cases: root is null or key is present at root
        if (root == null || root.key == key)
            return root;

        // Key is greater than root's key
        if (root.key > key)
            return search(root.left, key);

        // Key is smaller than root's key
        return search(root.right, key);
    }

    // This method mainly calls InorderRec()
    void inorder() {
        inorderRec(root);
    }

    // A utility function to do inorder traversal of BST
    void inorderRec(Node root) {
        if (root != null) {
            inorderRec(root.left);
            System.out.print(root.key + " ");
            inorderRec(root.right);
        }
    }

    // This method mainly calls PreorderRec()
    void preorder() {
        preorderRec(root);
    }

    // A utility function to do preorder traversal of BST
    void preorderRec(Node root) {
        if (root != null) {
            System.out.print(root.key + " ");
            preorderRec(root.left);
            preorderRec(root.right);
        }
    }

    // This method mainly calls PostorderRec()
    void postorder() {
        postorderRec(root);
    }

    // A utility function to do postorder traversal of BST
    void postorderRec(Node root) {
        if (root != null) {
            postorderRec(root.left);
            postorderRec(root.right);
            System.out.print(root.key + " ");
        }
    }
}
