package org.com.allen.enhance.basic.algorithm.tree;

import java.util.Objects;

/**
 * @author allen.wu
 * @since 2018-08-30 23:29
 */
public class Node {

    private int key;

    private int value;

    Node leftNode;

    Node rightNode;

    public Node() {

    }

    public Node(int key, int value) {
        this.key = key;
        this.value = value;
    }

    public Node(int key, int value, Node leftNode, Node rightNode) {
        this.key = key;
        this.value = value;
        this.leftNode = leftNode;
        this.rightNode = rightNode;
    }

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public Node getLeftNode() {
        return leftNode;
    }

    public void setLeftNode(Node leftNode) {
        this.leftNode = leftNode;
    }

    public Node getRightNode() {
        return rightNode;
    }

    public void setRightNode(Node rightNode) {
        this.rightNode = rightNode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Node node = (Node) o;
        return key == node.key &&
            value == node.value &&
            Objects.equals(leftNode, node.leftNode) &&
            Objects.equals(rightNode, node.rightNode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(key, value, leftNode, rightNode);
    }

    @Override
    public String toString() {
        return "Node{" +
            "key=" + key +
            ", value=" + value +
            ", leftNode=" + leftNode +
            ", rightNode=" + rightNode +
            '}';
    }
}
