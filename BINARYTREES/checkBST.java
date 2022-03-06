//https://www.codingninjas.com/codestudio/problems/check-if-a-binary-tree-is-bst_5975?leftPanelTab=1
package BINARYTREES;

public class checkBST {

    class BinaryTreeNode<T> {
        T data;
        BinaryTreeNode<T> left;
        BinaryTreeNode<T> right;

        public BinaryTreeNode(T data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public static int min(BinaryTreeNode<Integer> root) {
        if (root == null) {
            return Integer.MAX_VALUE;
        }
        return Math.min(root.data, Math.min(min(root.left), min(root.right)));
    }

    public static int max(BinaryTreeNode<Integer> root) {
        if (root == null) {
            return Integer.MIN_VALUE;
        }
        return Math.max(root.data, Math.max(max(root.left), max(root.right)));
    }

    public static boolean isBST(BinaryTreeNode<Integer> root, int min, int max) {
        if (root == null) {
            return true;
        }
        if (root.data < min || root.data > max) {
            return false;
        }
        boolean isleft = isBST(root.left, min, root.data - 1);
        boolean isright = isBST(root.right, root.data, max);
        return isleft && isright;
    }

    public static boolean isBST(BinaryTreeNode<Integer> root) {
        if (root == null) {
            return true;
        }
        int min = min(root);
        int max = max(root);
        boolean yesbst = isBST(root, min, max);
        return yesbst;

    }
}
