package bst;

//https://www.codingninjas.com/codestudio/problems/bst-to-sorted-dll_1263694?leftPanelTab=0
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

public class bst_to_DLL {

    static TreeNode<Integer> prev;

    public static void helper(TreeNode<Integer> root) {
        if (root == null) {
            return;
        }
        // TreeNode<Integer> curr= root;
        helper(root.left);
        prev.right = root;
        root.left = prev;
        prev = root;
        helper(root.right);
    }

    public static TreeNode<Integer> bstToSortedDLL(TreeNode<Integer> root) {
        if (root == null) {
            return null;
        }
        TreeNode<Integer> dummy = new TreeNode<>(-1);
        prev = dummy;
        helper(root);
        TreeNode<Integer> head = dummy.right;
        dummy.right = null;
        head.left = null;
        return head;

    }
}
