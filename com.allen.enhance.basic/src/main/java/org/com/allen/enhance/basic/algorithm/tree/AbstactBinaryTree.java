package org.com.allen.enhance.basic.algorithm.tree;

/**
 * @author allen.wu
 * @since 2018-08-30 23:26
 */
public abstract class AbstactBinaryTree {

    public abstract Node find(int key);

    public abstract boolean update(int key, int value);

    public abstract void insert(int key, int value);

    public abstract boolean delete(int key);

    public abstract Node getDirectPostNode(Node delNode);

    public abstract void preOrderRec(Node rootNode);

    public abstract void inOrderRec(Node rootNode);

    public abstract void postOrderRec(Node rootNode);

    public abstract void preOrder();

    public abstract void inOrder();

    public abstract void postOrder();

    public abstract void levelOrder();

}
