package org.com.allen.enhance.basic.datastruct.tree.RBTree;

/**
 * @author allen.wu
 * @since 2018-09-19 22:46
 */
public class RBTNode<T extends Comparable<T>> {


    public static final boolean RED = false;
    public static final boolean BLACK = true;

    public boolean color;// 颜色
    public T key;  // 关键值
    public RBTNode<T> left; // 左孩子
    public RBTNode<T> right;// 右孩子
    public RBTNode<T> parent;// 父节点


    public RBTNode(T key, boolean color, RBTNode<T> parent, RBTNode<T> left, RBTNode<T> right) {
        this.key = key;
        this.color = color;
        this.parent = parent;
        this.left = left;
        this.right = right;
    }

    public T getKey() {
        return key;
    }

    public String toString() {
        return "" + key + (this.color == RED ? "(R)" : "B");
    }
}
