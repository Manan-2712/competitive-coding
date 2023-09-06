package bst;
//https://www.codingninjas.com/studio/problems/check-for-dead-end-in-a-bst_1169457?leftPanelTab=1

public class hasdeadend {

    class TreeNode<T> {
        public T data;
        TreeNode<T> left;
        TreeNode<T> right;

        TreeNode(T data) {
            this.data = data;
            left = null;
            right = null;
        }
    };

    public static boolean helper(TreeNode<Integer> root, int min, int max) {
        if (root == null) {
            return false;
        }
        if (min == max) {
            return true;
        }
        return helper(root.left, min, root.data - 1) || helper(root.right, root.data + 1, max);
    }

    public static Boolean isDeadEnd(TreeNode<Integer> root) {
        if (root != null) {
            return helper(root, 1, Integer.MAX_VALUE);
        }

        return null;
    }
}
