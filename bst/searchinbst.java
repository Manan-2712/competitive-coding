package bst;
//https://leetcode.com/problems/search-in-a-binary-search-tree/description/
public class searchinbst {
    public TreeNode searchBST(TreeNode root, int val) {
        if (root != null) {
            if (root.val == val) {
                return root;
            } else if (root.val > val) {
                return searchBST(root.left, val);
            } else {
                return searchBST(root.right, val);
            }
        }
        return null;

    }
}
