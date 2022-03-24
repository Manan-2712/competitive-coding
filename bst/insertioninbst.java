package bst;

//https://www.codingninjas.com/codestudio/problems/insert-into-a-binary-search-tree_1279913?leftPanelTab=1

class TreeNode<T> {
    public T val;
    public TreeNode<T> left;
    public TreeNode<T> right;

    TreeNode(T val) {
        this.val = val;
        left = null;
        right = null;
    }
};

public class insertioninbst {

    public static TreeNode<Integer> insertionInBST(TreeNode<Integer> root, int val) {
        if (root == null) {
            return new TreeNode<Integer>(val);
        }
        if (root.val > val) {
            root.left = insertionInBST(root.left, val);
        } else if (root.val < val) {
            root.right = insertionInBST(root.right, val);
        } else {
            return null;
        }
        return root;
    }
}
