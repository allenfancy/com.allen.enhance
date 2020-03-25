package org.com.allen.enhance.basic.algorithm.base.tree;

import java.util.Stack;

/**
 * @author allen
 */
public class LeetCode98 {

    /**
     * 中序遍历，且判断是否有序.
     *
     * @param root root
     * @return bool
     */
    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        Stack<TreeNode> stack = new Stack<>();
        Integer max = null;//Long.MIN_VALUE;
        TreeNode curNode = root;
        while (curNode != null || !stack.isEmpty()) {
            while (curNode != null) {
                stack.push(curNode);
                curNode = curNode.left;
            }
            if (!stack.isEmpty()) {
                TreeNode temp = stack.pop();
                if (max >= temp.val) {
                    return false;
                }
                max = temp.val;
                curNode = temp.right;
            }
        }
        return true;
    }

    public boolean isValidBSTV2(TreeNode root) {
        return validate(root, null, null);
    }

    public boolean validate(TreeNode node, Integer mini, Integer max) {
        if (node == null) {
            return true;
        }
        if ((mini != null && node.val <= mini) || (max != null && node.val >= max)) {
            return false;
        }
        return validate(node.left, mini, node.val) && validate(node.right, node.val, max);
    }

}
