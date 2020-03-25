package org.com.allen.enhance.basic.algorithm.base.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

/**
 * @author allen.wu
 * @since 2018-08-30 23:31
 */
public class BinaryTree extends AbstactBinaryTree {

    private Node root;

    public Node getRoot() {
        return this.root;
    }

    public void setRoot(Node root) {
        this.root = root;
    }

    @Override
    public Node find(int key) {
        Node curNode = this.root;
        while (curNode != null && curNode.getKey() != key) {
            if (key > curNode.getKey()) {
                curNode = curNode.rightNode;
            } else if (key < curNode.getKey()) {
                curNode = curNode.leftNode;
            } else {
                System.out.println("nothing ...");
            }
        }
        return curNode;
    }

    @Override
    public boolean update(int key, int value) {
        return false;
    }

    @Override
    public void insert(int key, int value) {
        if (this.root == null) {
            root = new Node(key, value);
            return;
        }
        Node curNode = this.root;
        Node parentNode = this.root; // 指向currentNode节点的父节点
        boolean isLeftChild = true;
        while (curNode != null) {
            // 当前节点
            parentNode = curNode;
            if (key < curNode.getKey()) {
                curNode = curNode.leftNode;
                isLeftChild = true;
            } else if (key > curNode.getKey()) {
                curNode = curNode.rightNode;
                isLeftChild = false;
            } else {
                break;
            }
        }
        if (parentNode != curNode) {
            Node node = new Node(key, value);
            if (isLeftChild) {
                parentNode.leftNode = node;
            } else {
                parentNode.rightNode = node;
            }
        } else {
            curNode.setValue(value);
        }
    }

    @Override
    public boolean delete(int key) {
        Node curNode = this.root;
        Node parentNode = this.root;
        boolean isLeftChild = true;
        while ((curNode != null) && curNode.getKey() != key) {
            parentNode = curNode;
            if (key < curNode.getKey()) {
                curNode = curNode.leftNode;
                isLeftChild = true;
            } else if (key > curNode.getKey()) {
                curNode = curNode.rightNode;
                isLeftChild = false;
            } else {
                break;
            }
        }
        if (curNode == null) {
            return false;
        }
        // 删除的第一种情况 没有左右孩子节点
        if (curNode.leftNode == null && curNode.rightNode == null) {
            if (curNode == this.root) {
                this.root = null;
            } else if (isLeftChild) {
                parentNode.leftNode = null;
            } else {
                parentNode.rightNode = null;
            }
        } else if (curNode.rightNode == null && curNode.leftNode != null) { // 要删除的节点只有左孩子节点 第二种情况
            if (curNode == this.root) {
                this.root = curNode.leftNode;
            } else if (isLeftChild) {
                parentNode.leftNode = curNode.leftNode;
            } else {
                parentNode.rightNode = curNode.leftNode;
            }
        } else if (curNode.leftNode == null && curNode.rightNode != null) {
            if (curNode == this.root) {
                this.root = curNode.rightNode;
            } else if (isLeftChild) {
                parentNode.leftNode = curNode.rightNode;
            } else {
                parentNode.rightNode = curNode.rightNode;
            }
        } else {
            Node directPostNode = this.getDirectPostNode(curNode);
            curNode.setKey(directPostNode.getKey());
            curNode.setValue(directPostNode.getValue());
        }
        return true;
    }

    @Override
    public Node getDirectPostNode(Node delNode) {
        return null;
    }

    @Override
    public void preOrderRec(Node rootNode) {
        if (rootNode == null) {
            return;
        }
        System.out.println(rootNode.getKey() + "  " + rootNode.getValue());
        preOrderRec(rootNode.leftNode);
        preOrderRec(rootNode.rightNode);
    }

    @Override
    public void inOrderRec(Node rootNode) {
        if (rootNode == null) {
            return;
        }
        inOrderRec(rootNode.leftNode);
        System.out.println(rootNode.getKey() + "  " + rootNode.getValue());
        inOrderRec(rootNode.rightNode);
    }

    @Override
    public void postOrderRec(Node rootNode) {
        if (rootNode == null) {
            return;
        }
        postOrderRec(rootNode.leftNode);
        postOrderRec(rootNode.rightNode);
        System.out.println(rootNode.getKey() + "  " + rootNode.getValue());
    }

    @Override
    public void preOrder() {
        Stack<Node> stack = new Stack();
        List<Node> list = new ArrayList();
        Node cur = this.root;
        while (cur != null || !stack.empty()) {
            while (cur != null) {
                list.add(cur);
                stack.push(cur);
                cur = cur.leftNode;
            }
            if (!stack.empty()) {
                Node pop = stack.pop();
                cur = pop.rightNode;
            }
        }
        for (Node node : list) {
            System.out.println(node.getKey() + " " + node.getValue());
        }
    }

    @Override
    public void inOrder() {
        List<Node> list = new ArrayList();
        Stack<Node> stack = new Stack<>();
        Node p = root;
        while (p != null || !stack.empty()) {
            while (p != null) {
                stack.push(p);
                p = p.leftNode;
            }
            if (!stack.empty()) {
                Node temp = stack.pop();
                list.add(temp);
                p = temp.rightNode;
            }
        }
        for (Node node : list) {
            System.out.println(node.getKey() + " " + node.getValue());
        }
    }

    @Override
    public void postOrder() {
        List<Node> list = new ArrayList();
        Stack<Node> stack = new Stack<>();
        if (root == null) {
            return;
        }
        Node cur, pre = null;
        stack.push(root);
        while (!stack.empty()) {
            cur = stack.peek();
            if ((cur.leftNode == null && cur.rightNode == null) || (pre != null && (cur.leftNode == pre || cur.rightNode == pre))) {
                Node temp = stack.pop();
                list.add(temp);
                pre = temp;
            } else {
                if (cur.rightNode != null) {
                    stack.push(cur.rightNode);
                }
                if (cur.leftNode != null) {
                    stack.push(cur.leftNode);
                }
            }
        }
        for (Node node : list) {
            System.out.println(node.getKey() + " " + node.getValue());
        }
    }

    @Override
    public void levelOrder() {
        Queue<Node> queue = new LinkedList();
        if (this.root == null) {
            return;
        }
        queue.offer(this.root);
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            System.out.println(node.getKey() + " " + node.getValue());
            if (node.leftNode != null) {
                queue.offer(node.leftNode);
            }

            if (node.rightNode != null) {
                queue.offer(node.rightNode);
            }
        }
    }

    public static int maxDepth(Node root) {
        if (root == null) {
            return 0;
        }
        int left = maxDepth(root.getLeftNode());
        int rigth = maxDepth(root.getRightNode());
        return Math.max(left, rigth) + 1;
    }

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        tree.insert(6, 6);// 插入操作,构造图一所示的二叉树
        tree.insert(3, 3);
        tree.insert(14, 14);
        tree.insert(16, 16);
        tree.insert(10, 10);
        tree.insert(9, 9);
        tree.insert(13, 13);
        tree.insert(11, 11);
        tree.insert(12, 12);
        tree.inOrderRec(tree.getRoot());
        tree.inOrder();
        System.out.println(maxDepth(tree.getRoot()));
    }
}
