//codingninjas.com/codestudio/problems/deepest-leaves-sum_797824?leftPanelTab=1
package BINARYTREES;

public class deepestleavesSum {

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
            this.left = null;
            this.right = null;
        }
    }

    public static int heightt(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = heightt(root.left);
        int right = heightt(root.right);
        return 1 + Math.max(left, right);

    }

    public static int helper(TreeNode root, int height) {
        if (root == null) {
            return 0;
        }
        if (height == 1) {
            return root.val;
        }
        int left = helper(root.left, height - 1);
        int right = helper(root.right, height - 1);
        return left + right;
    }

    public static int deepestLeavesSum(TreeNode root) {

        int height = heightt(root);
        return helper(root, height);

    }
}
