package org.com.allen.enhance.basic.datastruct.tree.avl;

/**
 * @author allen.wu
 * @since 2018-09-18 16:58
 * <p>
 * AVL树的平衡因子 = 左子树的高度-右子树的高度
 * AVL树的平衡因子保持为(1,0,-1)
 * 当插入和删除的操作会导致AVL树的自我调整，使得所有结构的平衡因此保持为+1、-1 或 0
 * 当子树的根节点的平衡因子为+1时，它是左倾斜的(left-heavy)
 * 当子树的根节点的平衡因子为-1时，它是右倾斜的(right-heavy)
 * 一颗子树的根结点的平衡因子就代表该子树的平衡性
 * 保持所有子树几乎都处于平衡状态，AVL树在总体上就能够基本保持平衡
 * </p>
 */
public class AVLTreeV2<T extends Comparable<T>> {

    private AVLTreeNodeV2 root;

    public void insert(T element) {
        root = insert(element, root);
    }

    public void remove(T element) {
        remove(element, root);
    }


    public int height() {
        return height(root);
    }


    public AVLTreeNodeV2<T> insert(T element, AVLTreeNodeV2<T> node) {
        if (node == null) {
            return new AVLTreeNodeV2<>(element);
        }
        int result = element.compareTo(node.element);
        if (result < 0) { //左
            node.left = insert(element, node.left);
            // 插入左边，判断是否打破平衡
            if (height(node.left) - height(node.right) == 2) {
                // 如果等于2，平衡被打破，需要进行调整
                if (element.compareTo(node.left.element) < 0) {
                    // 如果element小于node左子树的值，那么x会被插入到t的左子树上，符合LL 用右旋跳转
                    node = rightRotate(node);
                } else {
                    // 如果element的值大于node的左子树的值，则会被插入到左子树的右子树上，符合LR，用先左旋转后在右旋转调整
                    node = leftAndRightRotate(node);
                }
            }
        } else if (result > 0) {//右
            node.right = insert(element, node.right);
            if (height(node.right) - height(node.left) == 2) {
                if (element.compareTo(node.right.element) > 0) {
                    node = leftRotate(node);
                } else {
                    node = rightAndLeftRotate(node);
                }
            }
        } else {
            // exist
        }
        node.height = Math.max(height(node.left), height(node.right)) + 1;
        return node;
    }

    /**
     * 删除
     * TODO
     */
    public AVLTreeNodeV2<T> remove(T element, AVLTreeNodeV2<T> node) {
        if (node == null) {
            return null;
        }
        int result = element.compareTo(node.element);
        if (result < 0) {
            node.left = remove(element, node.left);
            if (node.right != null) {
                if (node.left == null) {
                    if (height(node.right) - node.height == 2) {

                    }
                }
            }
        } else if (result > 0) {

        }
        return node;
    }

    /**
     * 右旋
     */
    private AVLTreeNodeV2<T> rightRotate(AVLTreeNodeV2<T> node) {
        AVLTreeNodeV2 newNode = node.left;
        node.left = newNode.right;
        newNode.right = node;
        node.height = Math.max(height(node.left), height(node.right)) + 1;
        newNode.height = Math.max(height(newNode.left), height(newNode.right));
        return newNode;
    }

    /**
     * 左旋
     */
    private AVLTreeNodeV2<T> leftRotate(AVLTreeNodeV2<T> node) {
        AVLTreeNodeV2<T> newNode = node.right;
        node.right = newNode.left;
        newNode.left = node;
        node.height = Math.max(height(node.left), height(node.right)) + 1;
        newNode.height = Math.max(height(node.left), height(newNode.right));
        return newNode;
    }


    /**
     * 先左旋后右旋
     */
    private AVLTreeNodeV2<T> leftAndRightRotate(AVLTreeNodeV2<T> node) {
        node.left = leftRotate(node.left);
        return rightRotate(node);
    }

    /**
     * 先右旋后左旋
     */
    private AVLTreeNodeV2<T> rightAndLeftRotate(AVLTreeNodeV2<T> node) {
        node.right = rightRotate(node.right);
        return leftRotate(node);
    }

    private int height(AVLTreeNodeV2<T> node) {
        return node == null ? -1 : node.height;
    }
}
