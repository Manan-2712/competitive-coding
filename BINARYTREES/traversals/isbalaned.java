package BINARYTREES.traversals;
//https://leetcode.com/problems/balanced-binary-tree/solutions/?orderBy=most_votes
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

public class isbalaned {

    public int height(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int lh = height(root.left);
        int rh = height(root.right);
        if (Math.abs(lh - rh) > 1) {
            return -1;
        }
        return 1 + Math.max(lh, rh);
    }

    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        int res = height(root);
        boolean ans = true;
        if (res == -1) {
            ans = false;
            return ans;
        }
        if (isBalanced(root.left) && isBalanced(root.right)) {
            return true;
        }
        return false;

    }
}
