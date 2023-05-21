package bst;
//https://leetcode.com/problems/construct-binary-search-tree-from-preorder-traversal/description/
public class bstfrompreorder1 {
    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode() {}
     * TreeNode(int val) { this.val = val; }
     * TreeNode(int val, TreeNode left, TreeNode right) {
     * this.val = val;
     * this.left = left;
     * this.right = right;
     * }
     * }
     */
    class Solution {
        public TreeNode helper(int[] preorder, int si, int ei) {
            if (si > ei) {
                return null;
            }
            int root = preorder[si];
            int count = 0;
            TreeNode newroot = new TreeNode(root);

            for (int i = si + 1; i <= ei; i++) {
                if (preorder[i] < preorder[si]) {
                    count++;
                }
            }

            newroot.left = helper(preorder, si + 1, si + count);
            newroot.right = helper(preorder, si + count + 1, ei);
            return newroot;

        }

        public TreeNode bstFromPreorder(int[] preorder) {
            return helper(preorder, 0, preorder.length - 1);

        }

    }

}
