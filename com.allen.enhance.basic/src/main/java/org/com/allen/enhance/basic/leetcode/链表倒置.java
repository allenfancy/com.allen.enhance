package org.com.allen.enhance.basic.leetcode;

import lombok.Data;

/**
 * @author allen.wu
 * @since 2018-09-16 19:33
 */
public class 链表倒置 {


    @Data
    static class Node {
        private int item;
        private Node next;

        Node(int item, Node next) {
            this.item = item;
            this.next = next;
        }
    }

    public static Node reverseLinkedNode(Node node) {
        if (node == null || node.getNext() == null) {
            return node;
        }
        Node headNode = reverseLinkedNode(node.getNext());
        node.getNext().setNext(node);
        node.setNext(null);
        return headNode;
    }

    public static Node reverseLinkedList(Node node) {
        Node previousNode = null;
        Node currentNode = node;
        Node headNode = null;
        while (currentNode != null) {
            System.out.println(currentNode);
            Node nextNode = currentNode.next;
            if (nextNode == null) {
                headNode = currentNode;
            }
            currentNode.next = previousNode;
            previousNode = currentNode;
            currentNode = nextNode;
        }
        return headNode;
    }

    public static void main(String[] args) {
        Node node = new Node(1,null);
        Node node1 = new Node(2,node);
        Node node2 = new Node(3,node1);
        //System.out.println( reverseLinkedNode(node2));
        reverseLinkedList(node2);
    }

}
