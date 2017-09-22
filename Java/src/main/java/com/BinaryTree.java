package com;

import org.checkerframework.checker.nullness.qual.Nullable;

/**
 * @author: pgajjar
 * @since: 9/21/17
 */
public class BinaryTree {
    public class TreeNode {
        public int data;
        public TreeNode left;
        public TreeNode right;

        public TreeNode(int data, final TreeNode left, final TreeNode right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }

        public void swap() {
            TreeNode tmp = left;
            left = right;
            right = tmp;
        }
    }

    private final TreeNode root;

    public BinaryTree(final TreeNode root) {
        this.root = root;
    }

    public boolean isMirror() {
        return isMirror(root.left, root.right);
    }

    private boolean isMirror(@Nullable final TreeNode left, @Nullable final TreeNode right) {
        if (left == null && right == null) {
            return true;
        } else if ((left != null && right == null) || (left == null && right != null)) {
            return false;
        }

        return isMirror(left.left, right.right) && isMirror(left.right, right.left) && left.data == right.data;
    }

    public void mirror() {

    }

    private void mirror(@Nullable final TreeNode node) {
        if (node != null) {
            mirror(node.left);
            mirror(node.right);
            node.swap();
        }
    }
}
