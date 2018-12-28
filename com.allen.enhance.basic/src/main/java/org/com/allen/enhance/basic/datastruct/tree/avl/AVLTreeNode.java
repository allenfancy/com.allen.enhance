package org.com.allen.enhance.basic.datastruct.tree.avl;

/**
 * @author allen.wu
 * @since 2018-09-18 16:57
 */
public class AVLTreeNode<T extends Comparable> {

    public T key;       // 关键字
    public int balance;  // 节点平衡度
    public AVLTreeNode<T> left; // 左节点
    public AVLTreeNode<T> right; // 右节点
    public AVLTreeNode<T> parent; // 父节点

    AVLTreeNode(T key, AVLTreeNode<T> parent) {
        this.key = key;
        this.parent = parent;
    }
}
