package BINARYTREES;
//https://leetcode.com/problems/maximum-sum-bst-in-binary-tree/description/s
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

public class maximumsum_inbst {

    class nodevalue {
        public int minnode, maxnode, sum;

        public nodevalue(int minnode, int maxnode, int sum) {
            this.minnode = minnode;
            this.maxnode = maxnode;
            this.sum = sum;
        }
    }

    class Solution {
        public int maxsum = 0;

        public nodevalue helper(TreeNode root) {
            if (root == null) {
                return new nodevalue(Integer.MAX_VALUE, Integer.MIN_VALUE, 0);
            }
            nodevalue left = helper(root.left);
            nodevalue right = helper(root.right);
            if (left == null || right == null) {
                return null;
            }
            if (root.val <= left.maxnode || root.val >= right.minnode) {
                return null;
            }
            maxsum = Math.max(maxsum, root.val + left.sum + right.sum);
            int minnode = Math.min(root.val, left.minnode);
            int maxnode = Math.max(root.val, right.maxnode);
            return new nodevalue(minnode, maxnode, left.sum + right.sum + root.val);

        }

        public int maxSumBST(TreeNode root) {
            // nodevalue node= helper(root);
            if (root == null) {
                return 0;
            }
            helper(root);
            return maxsum;

        }
    }
}
