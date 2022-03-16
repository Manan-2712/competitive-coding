package BINARYTREES;

class TreeNode<T> {
    public T val;
    public TreeNode<T> left;
    public TreeNode<T> right;

    TreeNode(T val) {
        this.val = val;
        left = right = null;
    }

};

public class binaryTreePrunning {

    public static TreeNode<Integer> binaryTreePruning(TreeNode<Integer> root) {
        if (root == null) {
            return null;
        }
        root.left = binaryTreePruning(root.left);
        root.right = binaryTreePruning(root.right);
        if (root.val == 0 && (root.left == null && root.right == null)) {
            return null;
        }
        return root;
    }

}
