package org.com.allen.enhance.basic.datastruct;

public class Tree {

    private Node root;
    
    public Node getRoot() {
        return root;
    }
    
    public void setRoot(Node root) {
        this.root = root;
    }

    public Node find(int iData) {
        Node current = root;
        while (current != null && current.getIData() != iData) {
            if (iData < current.getIData()) {
                current = current.getLeftChild();
            } else {
                current = current.getRightChild();
            }
            if (current == null) {
                return null;
            }
        }
        return current;
    }

    public void insert(int key, double data) {
        Node newNode = new Node();
        newNode.setIData(key);
        newNode.setDData(data);
        if (root == null) {
            root = newNode;
        } else {
            Node current = root;
            Node parent = null;
            while (true) {
                parent = current;
                System.out.println(current);
                if (key < current.getIData()) {
                    current = current.getLeftChild();
                    if (current == null) {
                        parent.setLeftChild(newNode);
                        return;
                    }
                } else {
                    current = current.getRightChild();
                    if (current == null) {
                        parent.setRightChild(newNode);
                        return;
                    }
                }
            }
        }

    }

    public void delete(int key) {

    }

    public void preOrder(Node localRoot) {
        if (localRoot != null) {
            System.out.print(localRoot.getIData() + "=>" + localRoot.getDData() + " ");
            inOrder(localRoot.getLeftChild());
            inOrder(localRoot.getRightChild());
        }
    }
    
    public void inOrder(Node localRoot) {
        if (localRoot != null) {
            inOrder(localRoot.getLeftChild());
            System.out.print(localRoot.getIData() + "=>" + localRoot.getDData() + " ");
            inOrder(localRoot.getRightChild());
        }
    }
    
    public void postOrder(Node localRoot) {
        if (localRoot != null) {
            inOrder(localRoot.getLeftChild());
            inOrder(localRoot.getRightChild());
            System.out.print(localRoot.getIData() + "=>" + localRoot.getDData() + " ");
        }
    }
}
