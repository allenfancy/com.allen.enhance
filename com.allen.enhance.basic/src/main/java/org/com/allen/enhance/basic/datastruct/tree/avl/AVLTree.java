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
public class AVLTree<T extends Comparable> {

    private AVLTreeNode<T> root;

    public boolean insert(T key) {
        if (root == null) {
            this.root = new AVLTreeNode<>(key, null);
        } else {
            // 设置新的临时节点
            AVLTreeNode tmp = this.root;
            // 指向当前的父亲节点
            AVLTreeNode parent;
            while (true) {
                if (tmp.key.compareTo(key) == 0) {
                    return false;
                }
                parent = tmp;
                boolean left = tmp.key.compareTo(key) > 0;
                tmp = left ? tmp.left : tmp.right;
                if (tmp == null) {
                    if (left) {
                        parent.left = new AVLTreeNode(key, parent);
                    } else {
                        parent.right = new AVLTreeNode(key, parent);
                    }
                    // 重新平衡树
                    rebalance(parent);
                    break;
                }
                // 不为空，继续查找
            }
        }
        return true;
    }

    public void delete(T key) {
        if (this.root == null) {
            return;
        }
        AVLTreeNode tmp = this.root;
        AVLTreeNode parent = this.root;
        AVLTreeNode delAVLTreeNode = null;
        AVLTreeNode child = this.root;

        while (child != null) {
            parent = tmp;
            tmp = child;
            if (tmp.key.compareTo(key) > 0) {
                child = tmp.left;
            } else {
                child = tmp.right;
            }
            if (tmp.key.compareTo(key) == 0) {
                delAVLTreeNode = tmp;
            }
        }
        if (delAVLTreeNode != null) {
            delAVLTreeNode.key = tmp.key;
            child = tmp.left != null ? tmp.left : tmp.right;
            if (root.key == key) {
                root = child;
            } else {
                if (parent.left == tmp) {
                    parent.left = child;
                } else {
                    parent.right = child;
                }
                rebalance(parent);
            }
        }
    }


    /**
     * 打印平衡度
     */
    public void printBalance() {
        printBalance(root);
    }

    private void rebalance(AVLTreeNode n) {
        setBalance(n);

        // 如果左子树高于右子树
        if (n.balance == -2) {
            // 如果挂载的是左子树的左孩子
            if (height(n.left.left) >= height(n.left.right)) {
                n = rotateRight(n);
            } else {
                // 如果挂载的左子树的右孩子，则先左旋转后右旋转
                n = rotateLeftThenRight(n);
            }
        } else if (n.balance == 2) {
            //如果挂载的是右子树的右孩子
            if (height(n.right.right) >= height(n.right.left)) {

                //进行左旋操作
                n = rotateLeft(n);
            } else {
                //否则进行先右旋后左旋
                n = rotateRightThenLeft(n);
            }
        }
        if (n.parent != null) {
            //如果当前节点的父节点不为空,则平衡其父节点
            rebalance(n.parent);
        } else {
            root = n;
        }
    }

    private AVLTreeNode rotateLeft(AVLTreeNode node) {

        // 指向当前节点的右孩子
        AVLTreeNode tmp = node.right;
        // 将当前节点的右孩子挂载到当前节点的父节点
        tmp.parent = node.parent;
        // 将原来的节点的右孩子寡照到新节点的左孩子上
        node.right = tmp.left;

        if (node.right != null) {
            node.right.parent = node;
        }

        tmp.left = node;
        node.parent = tmp;

        if (tmp.parent != null) {
            if (tmp.parent.right == node) {
                tmp.parent.right = tmp;
            } else {
                tmp.parent.left = tmp;
            }
        }
        setBalance(node, tmp);
        return tmp;
    }

    private AVLTreeNode rotateRight(AVLTreeNode a) {

        AVLTreeNode b = a.left;
        b.parent = a.parent;

        a.left = b.right;

        if (a.left != null) {
            a.left.parent = a;
        }
        b.right = a;
        a.parent = b;

        if (b.parent != null) {
            if (b.parent.right == a) {
                b.parent.right = b;
            } else {
                b.parent.left = b;
            }
        }

        setBalance(a, b);

        return b;
    }

    private AVLTreeNode rotateLeftThenRight(AVLTreeNode n) {
        n.left = rotateLeft(n.left);
        return rotateRight(n);
    }

    private AVLTreeNode rotateRightThenLeft(AVLTreeNode n) {
        n.right = rotateRight(n.right);
        return rotateLeft(n);
    }

    private int height(AVLTreeNode n) {
        if (n == null) {
            return -1;
        }
        return 1 + Math.max(height(n.left), height(n.right));
    }

    private void setBalance(AVLTreeNode... AVLTreeNodes) {
        for (AVLTreeNode n : AVLTreeNodes) {
            n.balance = height(n.right) - height(n.left);
        }
    }

    private void printBalance(AVLTreeNode n) {
        if (n != null) {
            printBalance(n.left);
            System.out.printf("%s ", n.balance);
            printBalance(n.right);
        }
    }
}
