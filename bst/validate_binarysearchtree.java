//https://leetcode.com/problems/validate-binary-search-tree/
package bst;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class validate_binarysearchtree {
    public boolean isValidBST(TreeNode root) {
        return isbst3(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    public static boolean isbst3(TreeNode root, int min, int max) {
        if (root == null) {
            return true;
        }
        if (root.val < min || root.val > max) {
            return false;
        }
        if (root.val == Integer.MAX_VALUE && root.right != null) {
            return false;
        }
        if (root.val == Integer.MIN_VALUE && root.left != null) {
            return false;
        }
        boolean isleft = isbst3(root.left, min, root.val - 1);
        boolean isright = isbst3(root.right, root.val + 1, max);
        return isleft && isright;
    }
}