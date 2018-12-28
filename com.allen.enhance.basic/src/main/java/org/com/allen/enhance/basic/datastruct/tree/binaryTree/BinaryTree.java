package org.com.allen.enhance.basic.datastruct.tree.binaryTree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author allen.wu
 * @since 2018-09-15 19:58
 */
public class BinaryTree {

    private Node root;

    public BinaryTree() {

    }


    public void insert(Node node) {
        if (root == null) {
            this.root = node;
            return;
        }
        Node currentNode = this.root;
        Node parentNode = this.root;
        boolean isLeft = true;
        while (currentNode != null) {
            parentNode = currentNode;
            if (node.getItem() < currentNode.getItem()) {
                currentNode = currentNode.getLeft();
                isLeft = true;
            } else if (node.getItem() > currentNode.getItem()) {
                currentNode = currentNode.getRight();
                isLeft = false;
            } else {
                break;
            }
        }
        if (parentNode != currentNode) {
            if (isLeft) {
                parentNode.setLeft(node);
            } else {
                parentNode.setRight(node);
            }
        }
    }

    public void inPreRec(Node node) {
        if (node == null) {
            return;
        }
        System.out.println(node.getItem());
        inPreRec(node.getLeft());
        inPreRec(node.getRight());
    }

    public void inPre(Node node) {
        if (node == null) {
            return;
        }
        Node currentNode = node;
        Stack<Node> stack = new Stack();
        List<Node> lists = new ArrayList<>();
        while (currentNode != null || !stack.isEmpty()) {
            while (currentNode != null) {
                stack.push(currentNode);
                lists.add(currentNode);
                currentNode = currentNode.getLeft();
            }
            if (!stack.isEmpty()) {
                Node pop = stack.pop();
                currentNode = pop.getRight();
            }
        }
        for (Node item : lists) {
            System.out.println(item.getItem());
        }
    }

    public void inMinRec(Node node) {
        if (node == null) {
            return;
        }
        inMinRec(node.getLeft());
        System.out.println(node.getItem());
        inMinRec(node.getRight());
    }

    public void inMin(Node node) {
        if (node == null) {
            return;
        }
        Node currentNode = node;
        Stack<Node> stack = new Stack();
        List<Node> lists = new ArrayList<>();
        while (currentNode != null || !stack.isEmpty()) {
            while (currentNode != null) {
                stack.push(currentNode);
                currentNode = currentNode.getLeft();
            }
            if (!stack.isEmpty()) {
                Node pop = stack.pop();
                lists.add(pop);
                currentNode = pop.getRight();
            }
        }
        for (Node item : lists) {
            System.out.println(item.getItem());
        }
    }

    public void postRec(Node node) {
        if (node == null) {
            return;
        }
        inMinRec(node.getLeft());
        inMinRec(node.getRight());
        System.out.println(node.getItem());
    }

    public void post(Node node) {
        if (node == null) {
            return;
        }
        Node currentNode, preNode = null;
        Stack<Node> stack = new Stack();
        List<Node> lists = new ArrayList<>();
        stack.push(node);
        while (!stack.isEmpty()) {
            currentNode = stack.peek();
            if ((currentNode.getLeft() == null && currentNode.getRight() == null) ||
                (preNode != null && (currentNode.getRight() == preNode || currentNode.getRight() == preNode))) {
                Node temp = stack.pop();
                lists.add(temp);
                preNode = temp;
            } else {

            }
        }
    }

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        tree.insert(new Node(10));
        tree.insert(new Node(7));
        tree.insert(new Node(3));
        tree.insert(new Node(2));
        tree.insert(new Node(5));
        tree.insert(new Node(12));
        tree.insert(new Node(14));
        tree.insert(new Node(17));
        tree.inPreRec(tree.root);
        System.out.println();
        tree.inPre(tree.root);
        System.out.println();
        tree.inMinRec(tree.root);
        System.out.println();
        tree.inMin(tree.root);

    }

}
