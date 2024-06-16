package dataStructure;

import java.util.LinkedList;
import java.util.Queue;

public class Tree {

    public Node root;

    public static class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int value) {
            this.value = value;
        }

        public boolean isLeaf() {
            return (this.left == null) && (this.right == null);
        }
    }

    public void insert(int value) {
        if (root == null) root = new Node(value);
        else {
            Node newNode = new Node(value);
            Queue<Node> queue = new LinkedList<>();
            queue.add(root);
            while (queue.size() > 0) {
                Node currentNode = queue.remove();
                if (currentNode.left == null) {
                    currentNode.left = newNode;
                    break;
                } else {
                    queue.add(currentNode.left);
                }
                if (currentNode.right == null) {
                    currentNode.right = newNode;
                    break;
                } else {
                    queue.add(currentNode.right);
                }
            }
        }
    }

    public void preOrder() {
        preOrder(root);
    }

    public void preOrder(final Node node) {
        // RED
        if (node == null) return;
        System.out.println(node.value);
        preOrder(node.left);
        preOrder(node.right);

    }

    public void inOrder() {
        inOrder(root);
    }

    public void inOrder(final Node node) {
        // ERD
        if (node == null) return;
        inOrder(node.left);
        System.out.println(node.value);
        inOrder(node.right);

    }

    public void posOrder() {
        posOrder(root);
    }

    public void posOrder(final Node node) {
        // EDR
        if (node == null) return;
        posOrder(node.left);
        posOrder(node.right);
        System.out.println(node.value);

    }

    public void BFS() {
        if (root == null) return;
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            Node node = queue.remove();
            if (node.left != null) queue.add(node.left);
            if (node.right != null) queue.add(node.right);

            System.out.println(node.value);
        }
    }

    public static void main(String[] args) {
        Tree tree = new Tree();
        tree.insert(37);
        tree.insert(11);
        tree.insert(66);
        tree.insert(8);
        tree.insert(17);
        tree.insert(42);
        tree.insert(72);

//        BFS
//        System.out.println("##############################");
//        tree.BFS(); // 37, 11, 66, 08, 17, 42, 72
//        System.out.println("##############################");

//        EDR
//        System.out.println("##############################");
//        tree.posOrder(); // 08, 17, 11, 42, 72, 66, 37
//        System.out.println("##############################");

//        ERD
//        System.out.println("##############################");
//        tree.inOrder(); // 08, 11, 17, 37, 42, 66, 72
//        System.out.println("##############################");

//        RED / DFS
//        System.out.println("##############################");
//        tree.preOrder(); // 37, 11, 08, 17, 66, 42, 72
//        System.out.println("##############################");

//        System.out.println(tree.root.value); // 37
//        System.out.println(tree.root.left.value); // 11
//        System.out.println(tree.root.right.value); // 66

//        System.out.println(tree.root.isLeaf());
//        System.out.println(tree.root.left.isLeaf());
//        System.out.println(tree.root.right.isLeaf());
    }
}
