package org.com.allen.enhance.basic.algorithm.base.tree;

import java.util.*;

/**
 * @author allen
 * @date 2020/3/24 11:02 上午
 **/
public class AllTreeAlgorithm {

    /**
     * <li>
     * 求二叉树种的节点的个数
     * </li>
     * 通过递归实现遍历
     *
     * @param node 根节点
     * @return node个数
     */
    private int getNodeNumRec(TreeNode node) {
        if (node == null) {
            return 0;
        }
        return getNodeNumRec(node.left) + getNodeNumRec(node.right) + 1;
    }

    /**
     * <li>
     * 求二叉树的最大层数
     * </li>
     *
     * @param root 根节点
     * @return 返回最大深度
     */
    private int getMaxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(getMaxDepth(root.left), getMaxDepth(root.right)) + 1;
    }

    /**
     * <li>
     * 求二叉树最小深度:从根节点到最近叶子节点的最短路径上的节点数量.
     * </li>
     *
     * @param root root
     * @return
     */
    private int getMinDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = getMinDepth(root.left);
        int right = getMinDepth(root.right);
        return (left == 0 || right == 0) ? left + right + 1 : Math.min(left, right) + 1;
    }

    /**
     * 先序遍历：递归
     *
     * @param root
     */
    private void preOrderReverseRec(TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.println(root.val);
        preOrderReverseRec(root.left);
        preOrderReverseRec(root.right);
    }

    /**
     * 先序遍历非递归实现1
     *
     * @param root root
     */
    private void preOrderReverseNotRec01(TreeNode root) {
        if (root == null) {
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode pop = stack.pop();
            System.out.println(pop.val);
            if (pop.right != null) {
                stack.push(pop.right);
            }
            if (pop.left != null) {
                stack.push(pop.left);
            }
        }
    }

    /**
     * 先序遍历 非递归实现2
     *
     * @param root
     */
    private void preOrderReverseNotRec02(TreeNode root) {
        if (root == null) {
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()) {
            if (cur != null) {
                System.out.println(cur.val);
                stack.push(cur);
                cur = cur.left;
            } else {
                cur = stack.pop();
                cur = cur.right;
            }
        }
    }

    /**
     * 中序遍历递归
     *
     * @param root 根节点
     */
    private void inOrderRec(TreeNode root) {
        if (root == null) {
            return;
        }
        inOrderRec(root.left);
        System.out.println(root.val);
        inOrderRec(root.right);
    }

    /**
     * 中序遍历: 非递归实现
     *
     * @param root 根节点
     */
    private void inOrder01(TreeNode root) {
        if (root == null) {
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()) {
            if (cur != null) {
                stack.push(cur);
                cur = cur.left;
            } else {
                cur = stack.pop();
                System.out.println(cur.val);
                cur = cur.right;
            }
        }
    }

    /**
     * 后续遍历:递归方法实现后续遍历
     *
     * @param root
     */
    private void epilogueOrderRec(TreeNode root) {
        if (root != null) {
            return;
        }
        epilogueOrderRec(root.left);
        epilogueOrderRec(root.right);
        System.out.println(root.val);
    }

    /**
     * 后续遍历实现01
     *
     * @param root root
     */
    private void epilogueOrder01(TreeNode root) {
        if (root == null) {
            return;
        }
        LinkedList<Integer> ans = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode cur = stack.pop();
            // 采用逆序插入的方式实现.
            ans.add(cur.val);
            if (cur.left != null) {
                stack.push(cur.left);
            }
            if (cur.right != null) {
                stack.push(cur.right);
            }
        }
        // for ans.
    }

    /**
     * 使用访问的节点.
     *
     * @param root 根节点
     */
    private void epilogueOrder02(TreeNode root) {
        if (root == null) {
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        TreeNode visited = null;
        while (cur != null || !stack.isEmpty()) {
            if (cur != null) {
                stack.push(cur);
                cur = cur.left;
            } else {
                cur = stack.peek();
                if (cur.right != null && cur.right != visited) {
                    cur = cur.right;
                } else {
                    System.out.println(cur.val);
                    visited = cur;
                    stack.pop();
                    cur = null;
                }
            }
        }
    }

    /**
     * 后续遍历   第三种实现方式.
     *
     * @param root root
     */
    private void epilogueOrder03(TreeNode root) {
        if (root == null) {
            return;
        }
        LinkedList<Integer> result = new LinkedList<>();
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode p = root;
        while (!stack.isEmpty() || p != null) {
            if (p != null) {
                stack.push(p);
                result.addFirst(p.val);
                p = p.right;
            } else {
                TreeNode node = stack.pop();
                p = node.left;
            }
        }
    }

    /**
     * BFS 广度优先算法
     *
     * @param root root
     */
    private void BFS(TreeNode root) {
        if (root == null) {
            return;
        }
        // 借助队列 queue实现.
        Queue<TreeNode> stack = new LinkedList<>();
        stack.offer(root);
        while (!stack.isEmpty()) {
            TreeNode pop = stack.poll();
            if (pop.left != null) {
                stack.offer(pop.left);
            }
            if (pop.right != null) {
                stack.offer(pop.right);
            }
            System.out.println(pop.val);
        }
    }

    /**
     * 分层打印
     *
     * @param root root
     */
    private void levelOrderTop(TreeNode root) {
        if (root == null) {
            return;
        }
        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        TreeNode cur;
        while (!queue.isEmpty()) {
            List<Integer> level = new ArrayList<>();
            int l = queue.size();
            for (int i = 0; i < l; i++) {
                cur = queue.poll();
                if (cur == null) {
                    break;
                }
                level.add(cur.val);
                if (cur.left != null) {
                    queue.add(cur.left);
                }
                if (cur.right != null) {
                    queue.add(cur.right);
                }
            }
            res.add(level);
        }
    }

    /**
     * 自下而上的分层遍历
     *
     * @param root root
     */
    private void levelOrderBottom(TreeNode root) {
        if (root == null) {
            return;
        }
        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        TreeNode cur;
        while (!queue.isEmpty()) {
            List<Integer> level = new ArrayList<>();
            int l = queue.size();
            for (int i = 0; i < l; i++) {
                cur = queue.poll();
                if (cur == null) {
                    break;
                }
                level.add(cur.val);
                if (cur.left != null) {
                    queue.add(cur.left);
                }
                if (cur.right != null) {
                    queue.add(cur.right);
                }
            }
            res.add(level);
        }
        List<List<Integer>> reverse = new ArrayList<>();
        for (int i = res.size() - 1; i >= 0; i--) {
            reverse.add(res.get(i));
        }
        //  reverse 翻转.
    }

    /**
     * 利用Linked双向链表的特性
     *
     * @param root root
     */
    private void levelOrderBottom2(TreeNode root) {
        if (root == null) {
            return;
        }
        LinkedList<List<Integer>> res = new LinkedList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        TreeNode cur;
        while (!queue.isEmpty()) {
            List<Integer> level = new ArrayList<>();
            int l = queue.size();
            for (int i = 0; i < l; i++) {
                cur = queue.poll();
                if (cur == null) {
                    break;
                }
                level.add(cur.val);
                if (cur.left != null) {
                    queue.add(cur.left);
                }
                if (cur.right != null) {
                    queue.add(cur.right);
                }
            }
            res.addFirst(level);
        }
    }

    /**
     * 按照之字打印
     *
     * @param node node
     */
    private ArrayList<ArrayList<Integer>> print(TreeNode node) {
        if (node == null) {
            return new ArrayList<>();
        }

        return null;
    }

    /**
     * 求二叉树第K层的节点个数 递归实现
     *
     * @param root root
     * @param k    k
     */
    int get_k_level_number(TreeNode root, int k) {
        if (root == null || k < 0) {
            return 0;
        }
        if (k == 1) {
            return 1;
        }
        return get_k_level_number(root.left, k - 1) + get_k_level_number(root.right, k - 1);
    }

    /**
     * 求二叉树第k层的叶子节点的个数 递归实现
     *
     * @param root root
     * @param k    k
     * @return k
     */
    int get_k_level_leaf_number(TreeNode root, int k) {
        if (root == null || k <= 0) {
            return 0;
        }
        if (k == 1) {
            if (root.left == null && root.right == null) {
                return 1;
            } else {
                return 0;
            }
        }
        return get_k_level_number(root.left, k - 1) + get_k_level_number(root.right, k - 1);
    }

    /**
     * 判断俩颗树结构是否相同
     *
     * @param p p
     * @param q q
     * @return res
     */
    private boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null) {
            return false;
        }
        // 递归进行每层判断.
        if (p.val != q.val) {
            return false;
        }
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }

    /**
     * 判断二叉树是不是平衡二叉树
     *
     * @param root root
     * @return res
     * <p>
     * 一个二叉树，其中每个节点的两个子树的深度差不相差超过1
     * </p>
     */
    private boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        return Math.abs(maxHigh(root.left) - maxHigh(root.right)) <= 1
                && isBalanced(root.left) && isBalanced(root.right);
    }

    private int maxHigh(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(maxHigh(root.left), maxHigh(root.right)) + 1;
    }

    /**
     * 二叉树镜像
     * 利用递归处理.
     *
     * @param root root
     * @return treeNode
     */
    private TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode node = root.left;
        root.left = invertTree(root.right);
        root.right = invertTree(node);
        return root;
    }

    /**
     * 对称二叉树：检测一个二叉树是否是对称的.
     *
     * @param root
     * @return
     */
    private boolean isSymmetric(TreeNode root) {
        return root == null || isSymmetricHelper(root.left, root.right);
    }

    private boolean isSymmetricHelper(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }
        if (left == null || right == null) {
            return false;
        }
        if (left.val != right.val) {
            return false;
        }
        return isSymmetricHelper(left.left, right.right) && isSymmetricHelper(left.right, right.left);
    }

    /**
     * 求二叉树中两个节点的最低公共祖先节点:
     * 最近公共祖先的定义：对于有根树T的俩个节点p,q，最近公共祖先表示为一个节点x,
     * 满足x是p、q的祖先且x的深度尽可能大(一个节点也可以是它自己的祖先).
     *
     * @param root root
     * @param p    p
     * @param q    q
     * @return node
     */
    private TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) {
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left != null && right != null) {
            return root;
        }
        return left == null ? right : left;
    }

    /**
     * 求二叉搜索树的最近公共祖先
     * 定义：对于有根树T的俩个节点p、q,最近公共祖先标识为一个节点x,
     * 满足x是p、q的祖先且X的深度尽可能大(一个节点也可以是它自己的祖先)
     *
     * @param root root
     * @param p    p
     * @param q    q
     * @return node
     */
    private TreeNode lowestCommonAncestorV1(TreeNode root, TreeNode p, TreeNode q) {
        if (root.val > p.val && root.val > q.val) {
            return lowestCommonAncestorV1(root.left, p, q);
        } else if (root.val < p.val && root.val < q.val) {
            return lowestCommonAncestorV1(root.right, p, q);
        } else {
            return root;
        }
    }

    /**
     * 使用迭代的方式实现.
     * 左子树 < 根节点 < 右子树
     *
     * @param root root
     * @param p    p
     * @param q    q
     * @return node
     */
    private TreeNode lowestCommonAncestorV2(TreeNode root, TreeNode p, TreeNode q) {
        int pVal = p.val;
        int qVal = q.val;
        TreeNode cur = root;
        while (cur != null) {
            int curVal = cur.val;
            if (curVal > pVal && curVal > qVal) {
                cur = cur.right;
            } else if (curVal < q.val && curVal < qVal) {
                cur = cur.left;
            } else {
                return cur;
            }
        }
        return null;
    }

    /**
     * 求二叉树的直径
     * https://leetcode-cn.com/problems/diameter-of-binary-tree/description/
     * 对于每个节点，它的最长路径 = 左子树的最长路径+右子树的最长路径
     *
     * @param root root
     * @return int
     */
    public int diameterOfBinaryTree(TreeNode root) {
        diameterHelper(root);
        return path;
    }

    private int path = 0;

    private int diameterHelper(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = diameterHelper(root.left);
        int right = diameterHelper(root.right);
        path = Math.max(path, left + right);
        return Math.max(left, right) + 1;
    }

    /**
     * 二叉搜索树的第k个结点
     * 利用中序遍历，打印出第K个节点就行.
     *
     * @param root root
     * @param k    k
     * @return int
     */
    private int kthSmallest(TreeNode root, int k) {
        if (root == null) {
            return Integer.MIN_VALUE;
        }
        Stack<TreeNode> stack = new Stack<>();
        int count = 0;
        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()) {
            if (cur != null) {
                stack.push(cur);
                cur = cur.left;
            } else {
                TreeNode node = stack.pop();
                count++;
                if (count == k) {
                    return node.val;
                }
                cur = node.right;
            }
        }
        return Integer.MIN_VALUE;
    }

    /**
     * 判断二叉树是不是完全二叉树
     * 完全二叉的树的定义：完全二叉树是指最后一层左边是满的，右边可能慢也不能不满，然后其余层都是满的。
     * 利用层遍历。如果我们当前遍历到了NULL结点，如果后续还有非NULL结点，说明是非完全二叉树
     *
     * @param root root
     * @return true or false.
     */
    private boolean checkCompleteTree(TreeNode root) {
        if (root == null) {
            return true;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        boolean flag = false;
        while (!queue.isEmpty()) {
            TreeNode poll = queue.poll();
            if (poll != null) {
                if (flag) {
                    return false;
                }
                queue.add(poll.left);
                queue.add(poll.right);
            } else {
                flag = true;
            }
        }
        return true;
    }

    /**
     * 树的子结构
     *
     * @param root1 r1
     * @param root2 r2
     * @return true or false.
     */
    private boolean HasSubTree(TreeNode root1, TreeNode root2) {
        if (root1 == null || root2 == null) {
            return false;
        }
        return IsSubTree(root1, root2) ||
                HasSubTree(root1.left, root2) ||
                HasSubTree(root1.right, root2);
    }

    private boolean IsSubTree(TreeNode root1, TreeNode root2) {
        if (root2 == null) {
            return true;
        }
        if (root1 == null) {
            return false;
        }
        if (root1.val == root2.val) {
            return IsSubTree(root1.left, root2.left) && IsSubTree(root1.right, root2.right);
        } else {
            return false;
        }
    }

    ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
    ArrayList<Integer> temp = new ArrayList<Integer>();

    /**
     * 二叉树中和为某一值的路径
     * 输入一棵二叉树和一个整数，打印出二叉树种节点值的和为输入整数的所有路径.
     * 路径定义为: 从树的根结点开始往下一直到叶结点所经过的结点形成一条路径
     *
     * @param root
     * @param target
     * @return
     */
    private ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        if (root == null) {
            return res;
        }
        target -= root.val;
        temp.add(root.val);
        if (target == 0 && root.left == null && root.right == null) {
            res.add(new ArrayList<>(temp));
        } else {
            FindPath(root.left, target);
            FindPath(root.right, target);
        }
        temp.remove(temp.size() - 1);
        return res;
    }

    /**
     * 根据中序遍历和后续遍历
     *
     * @param inorder   inorder
     * @param postorder postorder
     * @return treeNode
     */
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder.length == 0 || postorder.length == 0) {
            return null;
        }
        return buildTreeHelper(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
    }

    public TreeNode buildTreeHelper(int[] inorder, int in_start, int in_end,
                                    int[] postorder, int post_start, int post_end) {
        if (in_start > in_end || post_start > post_end) {
            return null;
        }
        TreeNode root = new TreeNode(postorder[post_end]);
        for (int i = in_start; i <= in_end; i++) {
            if (inorder[i] == postorder[post_end]) {
                root.left = buildTreeHelper(inorder, in_start, i - 1, postorder, post_start, post_start + i - in_start - 1);
                root.right = buildTreeHelper(inorder, i + 1, in_end, postorder, post_start + i - in_start, post_end - 1);
            }
        }
        return root;
    }
}
