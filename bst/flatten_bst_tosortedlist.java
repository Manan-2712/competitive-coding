//https://www.codingninjas.com/codestudio/problems/flatten-bst-to-a-sorted-list_1169459?leftPanelTab=1
package bst;

import java.util.*;

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

public class flatten_bst_tosortedlist {

    public static void inorder(TreeNode<Integer> root, ArrayList<Integer> ans) {
        if (root == null) {
            return;
        }
        inorder(root.left, ans);
        ans.add(root.data);
        inorder(root.right, ans);
    }

    public static TreeNode<Integer> flatten(TreeNode<Integer> root) {
        if (root == null) {
            return null;
        }
        ArrayList<Integer> ans = new ArrayList<>();
        inorder(root, ans);
        TreeNode<Integer> newroot = new TreeNode<Integer>(ans.get(0));
        TreeNode<Integer> curr = newroot;
        for (int i = 1; i < ans.size(); i++) {
            TreeNode<Integer> temp = new TreeNode<Integer>(ans.get(i));
            curr.left = null;
            curr.right = temp;
            curr = temp;

        }
        curr.left = null;
        curr.right = null;
        return newroot;

    }
}
