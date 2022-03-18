//https://leetcode.com/problems/longest-univalue-path/submissions/
package BINARYTREES;

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

public class longest_univalue_path {

    static int ans;

    public int longestUnivaluePath(TreeNode root) {
        ans = 0;
        arrowLength(root);
        return ans;
    }

    public int arrowLength(TreeNode node) {
            if (node == null) return 0;
            int left = arrowLength(node.left)
            int right = arrowLength(node.right);
            int arrowLeft = 0, arrowRight = 0;
            if (node.left != null && node.left.val == node.val) {
                arrowLeft += left + 1;
            }
            if (node.right != null && node.right.val == node.val) {
                arrowRight += right + 1;
            }
            ans = Math.max(ans, arrowLeft + arrowRight);
            return Math.max(arrowLeft, arrowRight);
        }
}

}
