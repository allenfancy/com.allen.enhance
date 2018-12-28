package org.com.allen.enhance.basic.datastruct.tree.binaryTree;

import lombok.Data;

/**
 * @author allen.wu
 * @since 2018-09-15 19:58
 */
@Data
public class Node {
    private Integer item;
    private Node left;
    private Node right;

    public Node(Integer item) {
        this.item = item;
        this.left = null;
        this.right = null;
    }
}
