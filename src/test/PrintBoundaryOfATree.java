package test;

public class PrintBoundaryOfATree {
    Node root;

    // A simple function to print leaf nodes of a binary tree
    static void printLeaves(Node node) {
        if (node != null) {
            printLeaves(node.left);

            // Print it if it is a leaf node
            if (node.left == null && node.right == null)
                System.out.print(node.data + " ");
            printLeaves(node.right);
        }
    }

    // A function to print all left boundry nodes, except a leaf node.
    // Print the nodes in TOP DOWN manner
    static void printBoundaryLeft(Node node) {
        if (node != null) {
            if (node.left != null) {

                // to ensure top down order, print the node
                // before calling itself for left subtree
                System.out.print(node.data + " ");
                printBoundaryLeft(node.left);
            } else if (node.right != null) {
                System.out.print(node.data + " ");
                printBoundaryLeft(node.right);
            }

            // do nothing if it is a leaf node, this way we avoid
            // duplicates in output
        }
    }

    // A function to print all right boundry nodes, except a leaf node
    // Print the nodes in BOTTOM UP manner
    static void printBoundaryRight(Node node) {
        if (node != null) {
            if (node.right != null) {
                // to ensure bottom up order, first call for right
                //  subtree, then print this node
                printBoundaryRight(node.right);
                System.out.print(node.data + " ");
            } else if (node.left != null) {
                printBoundaryRight(node.left);
                System.out.print(node.data + " ");
            }
            // do nothing if it is a leaf node, this way we avoid
            // duplicates in output
        }
    }

    // A function to do boundary traversal of a given binary tree
    static void printBoundary(Node node) {
        if (node != null) {
            System.out.print(node.data + " ");

            // Print the left boundary in top-down manner.
            printBoundaryLeft(node.left);

            // Print all leaf nodes
            printLeaves(node.left);
            printLeaves(node.right);

            // Print the right boundary in bottom-up manner
            printBoundaryRight(node.right);
        }
    }

    public static void main(String[] args) {
        Node nodeRoot = new Node(1);
        Node nodeLeft = new Node(2);
        Node nodeRight = new Node(3);

        Node leaf1 = new Node(2);
        Node leaf2 = new Node(4);
        Node leaf3 = new Node(2);
        Node leaf4 = new Node(3);


        nodeRoot.left = nodeLeft;
        nodeRoot.right = nodeRight;

        nodeLeft.left = leaf1;
        nodeLeft.right = leaf2;
        nodeRight.left = leaf3;
        nodeRight.right = leaf4;

        printBoundary(nodeRoot);
    }

    private static class Node {
        int data;
        Node left;
        Node right;

        Node(int x) {
            data = x;
            left = null;
            right = null;
        }
    }
}
