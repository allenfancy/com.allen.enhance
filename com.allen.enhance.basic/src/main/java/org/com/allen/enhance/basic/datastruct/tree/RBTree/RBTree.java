package org.com.allen.enhance.basic.datastruct.tree.RBTree;

/**
 * @author allen.wu
 * @since 2018-09-19 22:46
 *
 * 红黑树是特殊的二叉查找树，意味着它满足二叉查找树的特征：任意一个节点所包含的键值，大于等于左孩子的键值，小于等于有孩子的键值。
 * 特性：
 * 红黑树的每个节点上都有存储位置表示节点的颜色，颜色是红色(Red)或黑色(Black).
 * 1. 每个节点或者是黑色，或者是红色
 * 2. 根节点是黑色
 * 3. 每个叶子节点是黑色(这里的叶子节点，是指为空的叶子节点)
 * 4. 如果一个节点是红色的，则它的子节点必须是黑色的
 * 5. 从一个节点到该节点的子孙节点的所有路径上包含相同数目的黑节点.
 * 确保没有一条路径会比其他路径长出两倍。因而，红黑树是相对是接近平衡二叉树的
 *
 * <>
 * 红黑树的基本操作是：添加、删除和旋转.
 * 旋转的目的是让树保持红黑树的特性
 * </>
 */
public class RBTree<T extends Comparable<T>> {

    private RBTNode<T> root;

    public RBTree() {
        root = null;
    }

    private RBTNode<T> parentOf(RBTNode<T> node) {
        return node != null ? node.parent : null;
    }

    private boolean colorOf(RBTNode<T> node) {
        return node != null ? node.color : RBTNode.BLACK;
    }

    private boolean isRed(RBTNode<T> node) {
        return ((node != null) && (node.color == RBTNode.RED)) ? true : false;
    }

    private boolean isBlack(RBTNode<T> node) {
        return !isRed(node);
    }

    private void setBlack(RBTNode<T> node) {
        if (node != null)
            node.color = RBTNode.BLACK;
    }

    private void setRed(RBTNode<T> node) {
        if (node != null)
            node.color = RBTNode.RED;
    }

    private void setParent(RBTNode<T> node, RBTNode<T> parent) {
        if (node != null)
            node.parent = parent;
    }

    private void setColor(RBTNode<T> node, boolean color) {
        if (node != null)
            node.color = color;
    }

    private void preOrder(RBTNode<T> node) {
        if (node != null) {
            System.out.print(node.key + " ");
            preOrder(node.left);
            preOrder(node.right);
        }
    }

    /**
     * 前序
     */
    public void preOrder() {
        preOrder(root);
    }

    private void inOrder(RBTNode<T> node) {
        if (node != null) {
            preOrder(node.left);
            System.out.print(node.key + " ");
            preOrder(node.right);
        }
    }

    /**
     * 中序
     */
    public void inOrder() {
        inOrder(root);
    }

    private void postOrder(RBTNode<T> node) {
        if (node != null) {
            preOrder(node.left);
            preOrder(node.right);
            System.out.print(node.key + " ");
        }
    }

    /**
     * 后续
     */
    public void postOrder() {
        postOrder(root);
    }

    private RBTNode<T> search(RBTNode<T> node, T key) {
        if (node == null) {
            return node;
        }
        int res = key.compareTo(node.key);
        if (res < 0) {
            return search(node.left, key);
        } else if (res > 0) {
            return search(node.right, key);
        } else {
            return node;
        }
    }

    /**
     * 搜索key
     */
    public RBTNode<T> search(T key) {
        return search(root, key);
    }

    private RBTNode<T> iterativeSearch(RBTNode<T> node, T key) {
        while (node != null) {
            int res = key.compareTo(node.key);
            if (res < 0) {
                node = node.left;
            } else if (res > 0) {
                node = node.right;
            } else {
                return node;
            }
        }
        return node;
    }

    /**
     * 非递归搜索
     */
    public RBTNode<T> iterativeSearch(T key) {
        return iterativeSearch(root, key);
    }

    /*
     * 查找最小结点：返回tree为根结点的红黑树的最小结点。
     */
    private RBTNode<T> minimum(RBTNode<T> tree) {
        if (tree == null)
            return null;

        while (tree.left != null)
            tree = tree.left;
        return tree;
    }

    public T minimum() {
        RBTNode<T> p = minimum(root);
        if (p != null)
            return p.key;

        return null;
    }

    /*
     * 查找最大结点：返回tree为根结点的红黑树的最大结点。
     */
    private RBTNode<T> maximum(RBTNode<T> tree) {
        if (tree == null)
            return null;

        while (tree.right != null)
            tree = tree.right;
        return tree;
    }

    public T maximum() {
        RBTNode<T> p = maximum(root);
        if (p != null)
            return p.key;

        return null;
    }

    /**
     * 找node的结点的后继结点，即，红黑树中数据值大于该节点的最小节点
     */
    public RBTNode<T> successor(RBTNode<T> node) {
        // 1. 如果x存在右孩子，则"node"的后继节点为右孩子为根的子树的最小节点
        if (node.right != null) {
            return minimum(node);
        }
        // 2.如果node没有右孩子，则node有下面俩中情况
        // 2.1 node是一个左孩子，则node的后继节点为它的父节点
        // 2.2 node是一个右孩子，则查找node的最低的父节点，并且该节点具有左孩子，找到这个最低的父结点就是node的后继结点
        RBTNode tmp = node.parent;
        while (tmp != null && (node == tmp.right)) {
            node = tmp;
            tmp = tmp.parent;
        }
        return tmp;
    }


    /**
     * 查找node的前驱节点。即，查找红黑树中的数据值小于该节点的最大值
     */
    public RBTNode<T> predecessor(RBTNode<T> node) {

        // 如果x存在左孩子，则"x的前驱结点"为 "以其左孩子为根的子树的最大结点"。
        if (node.left != null) {
            return maximum(node.left);
        }

        // 如果x没有左孩子。则x有以下两种可能：
        // (01) x是"一个右孩子"，则"x的前驱结点"为 "它的父结点"。
        // (01) x是"一个左孩子"，则查找"x的最低的父结点，并且该父结点要具有右孩子"，找到的这个"最低的父结点"就是"x的前驱结点"。
        RBTNode<T> y = node.parent;
        while ((y != null) && (node == y.left)) {
            node = y;
            y = y.parent;
        }
        return y;
    }

    /**
     * 对红黑树的节点node就那些左旋转
     * pnode                           pnode
     *
     * node           ---->左旋         Y
     *
     * lnode      Y                   node      ry
     * ly     ry          lnode   ly
     */
    private void leftRotate(RBTNode<T> node) {
        RBTNode<T> y = node.right;
        // 将y的左孩子设置为x的右孩子
        // 如果y的左还在非空，将node设为y的左孩子的父孩子
        node.right = y.left;

        if (y.left != null) {
            y.left.parent = node;
        }
        // 将 “node的父亲” 设为 “y的父亲”
        y.parent = node.parent;
        if (node.parent == null) { // 如果node的父节点是空节点，则将Y设置为根节点
            this.root = y;
        } else {
            if (node.parent.left == node) {
                node.parent.left = y;       // 如果node是他父节点的左孩子，则将y设置为node的父节点的左孩子
            } else {
                node.parent.right = y;      // 如果node是他父节点的右孩子，则将y设置x的父节点的右孩子
            }
        }
        // 将 “node” 设为 “y的左孩子”
        y.left = node;
        // 将 “node的父节点” 设为 “y”
        node.parent = y;
    }

    /**
     * pnode                             pnode
     * /
     * node            --右旋-->      x
     * /   \
     * x   rnode                  lx        node
     * / \
     * lx rx                             rx     rnode
     */
    private void rightRotate(RBTNode<T> node) {

        // 1. x = node.left
        RBTNode<T> x = node.left;

        node.left = x.right;

        if (x.right != null) {
            x.right.parent = node;
        }

        x.parent = node.parent;

        if (node.parent == null) {
            this.root = x;
        } else {
            if (node.parent.right == node) {
                node.parent.right = x;
            } else {
                node.parent.left = x;
            }
        }
        // 将 “node” 设为 “x的右孩子”
        x.right = node;
        // 将 “y的父节点” 设为 “node”
        node.parent = x;
    }

    private void insertFixUp(RBTNode<T> node) {
        RBTNode<T> parent, gparent;

        //  若父节点存在，并父节点的颜色是红色
        while (((parent = parentOf(node)) != null) && isRed(parent)) {
            gparent = parentOf(parent);

            // 1. 若父节点是祖节点的左孩子
            if (parent == gparent.left) {
                RBTNode<T> uncle = gparent.right;
                if (uncle != null && isRed(uncle)) {
                    setBlack(uncle);
                    setBlack(parent);
                    setRed(gparent);
                    node = gparent;
                    continue;
                }
                if (parent.right == node) {
                    RBTNode<T> tmp;
                    leftRotate(parent);
                    tmp = parent;
                    parent = node;
                    node = tmp;
                }
                setBlack(parent);
                setRed(gparent);
                rightRotate(gparent);
            } else {
                RBTNode<T> uncle = gparent.left;
                if (uncle != null && isRed(uncle)) {
                    setBlack(uncle);
                    setBlack(parent);
                    setRed(gparent);
                    node = gparent;
                    continue;
                }

                if (parent.left == node) {
                    RBTNode<T> tmp;
                    rightRotate(parent);
                    tmp = parent;
                    parent = node;
                    node = tmp;
                }

                setBlack(parent);
                setRed(gparent);
                leftRotate(gparent);
            }
        }
        setBlack(this.root);
    }


    private void insert(RBTNode<T> node) {
        int cmp;
        RBTNode<T> y = null;
        RBTNode<T> x = this.root;
        while (x != null) {
            y = x;
            cmp = node.key.compareTo(x.key);
            if (cmp < 0) {
                x = x.left;
            } else {
                x = x.right;
            }
        }
        node.parent = y;
        if (y != null) {
            cmp = node.key.compareTo(y.key);
            if (cmp < 0) {
                y.left = node;
            } else {
                y.right = node;
            }
        } else {
            this.root = node;
        }
        node.color = RBTNode.RED;
        insertFixUp(node);
    }

    public void insert(T key) {
        RBTNode node = new RBTNode(key, RBTNode.BLACK, null, null, null);
        if (node != null) {
            insert(node);
        }
    }

    public void remove(T key) {
        RBTNode<T> search = search(root, key);
        if (search != null) {
            remove(search);
        }
    }

    private void remove(RBTNode<T> node) {
        RBTNode<T> child, parent;
        boolean color;

        if (node.left != null && node.right != null) {
            RBTNode<T> replace = node;
            replace = replace.right;
            while (replace.left != null) {
                replace = replace.left;
            }

            if (parentOf(node).left != null) {
                if (parentOf(node).left == node) {
                    parentOf(node).left = replace;
                } else {
                    parentOf(node).right = replace;
                }
            } else {
                this.root = replace;
            }
            child = replace.right;
            parent = parentOf(replace);
            color = colorOf(replace);

            if (parent == node) {
                parent = replace;
            } else {
                if (child != null) {
                    setParent(child, parent);
                }
                parent.left = child;

                replace.right = node.right;
                setParent(node.right, replace);
            }
            replace.parent = node.parent;
            replace.color = node.color;
            replace.left = node.left;
            node.left.parent = node.parent;

            if (color == RBTNode.BLACK) {
                removeFixUp(child, parent);
            }
            node = null;
            return;
        }

        if (node.left != null) {
            child = node.left;
        } else {
            child = node.right;
        }

        parent = node.parent;
        color = node.color;

        if (child != null) {
            child.parent = parent;
        }

        if (parent != null) {
            if (parent.left == node) {
                parent.left = child;
            } else {
                parent.right = child;
            }
        } else {
            this.root = child;
        }

        if (color == RBTNode.BLACK) {
            removeFixUp(child, parent);
        }
        node = null;
    }

    private void removeFixUp(RBTNode<T> child, RBTNode<T> parent) {
    }
}
