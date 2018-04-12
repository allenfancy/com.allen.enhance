package org.com.allen.enhance.basic.datastruct;

public class TreeMain {

    public static void main(String[] args) {
        Tree theTree = new Tree();
        theTree.insert(50, 1.5);
        theTree.insert(25, 1.7);
        theTree.insert(75, 1.9);
        theTree.insert(15, 1.1);
        Node found = theTree.find(50);
        System.out.println("find  node : " + found);
        theTree.preOrder(theTree.getRoot());
        System.out.println();
        theTree.inOrder(theTree.getRoot());
        System.out.println();
        theTree.postOrder(theTree.getRoot());
        System.out.println();
    }
}
