package org.com.allen.enhance.basic.datastruct.tree.avl;

/**
 * @author allen.wu
 * @since 2018-09-18 16:57
 */
public class AVLTreeNodeV2<T extends Comparable> {

    public T element;       // 关键字
    public int height;  // 节点平衡度
    public AVLTreeNodeV2<T> left; // 左节点
    public AVLTreeNodeV2<T> right; // 右节点

    public AVLTreeNodeV2(T element) {
        this(element, null, null);
    }

    public AVLTreeNodeV2(T element, AVLTreeNodeV2<T> left, AVLTreeNodeV2<T> right) {
        this.element = element;
        this.left = left;
        this.right = right;
    }
}
