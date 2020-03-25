package org.com.allen.enhance.basic.algorithm.base.tree;

/**
 * @author allen
 */
public class LeetCode104 {

    /**
     * 递归
     *
     * @param root
     * @return
     */
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        } else {
            int left_height = maxDepth(root.left);
            int right_height = maxDepth(root.right);
            return java.lang.Math.max(left_height, right_height) + 1;
        }
    }

    /**
     * 使用广度优先算法.
     *
     * @param root root
     * @return
     */
    public int maxDepthV2(TreeNode root) {
        return 0;
    }
}
