//https://www.codingninjas.com/codestudio/problems/preorder-traversal_2035934?leftPanelTab=1

package BINARYTREES.traversals;

import java.util.ArrayList;

public class preorder {

    class BinaryTreeNode<T> {
        T data;
        BinaryTreeNode<T> left;
        BinaryTreeNode<T> right;

        public BinaryTreeNode(T data) {
            this.data = data;
        }
    }

    public static ArrayList<Integer> preorderTraversalhelper(BinaryTreeNode<Integer> root, ArrayList<Integer> ans) {
        if (root == null) {
            return ans;
        }
        ans.add(root.data);
        preorderTraversalhelper(root.left, ans);
        preorderTraversalhelper(root.right, ans);
        return ans;
    }

    public static ArrayList<Integer> preorderTraversal(BinaryTreeNode<Integer> root) {
        ArrayList<Integer> ans = new ArrayList<>();
        ArrayList<Integer> res = preorderTraversalhelper(root, ans);
        return res;

    }
}
