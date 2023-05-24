package bst;

public class ksmallest {
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

    static int count;
    // BETTER APPROACH
    // public void helper(TreeNode root,ArrayList<Integer> inorder){
    // // better approach
    // if(root == null){
    // return ;
    // }
    // helper(root.left,inorder);
    // inorder.add(root.val);
    // helper(root.right,inorder);
    // }
    // public int kthSmallest(TreeNode root, int k) {
    // ArrayList<Integer> inorder = new ArrayList<>();
    // helper(root,inorder);
    // return inorder.get(k-1);

    // }

    // OPTIMISED APPROACH
    public static int kthSmallest(TreeNode root, int k) {
        count = 0;
        return helper(root, k);

    }

    public static int helper(TreeNode root, int k) {
        if (root == null) {
            return -1;
        }
        int left = helper(root.left, k);
        if (left != -1) {
            return left;
        }
        System.out.println(count + " " + root.val);
        count++;
        if (count == k) {
            return root.val;
        }
        return helper(root.right, k);
    }
}
