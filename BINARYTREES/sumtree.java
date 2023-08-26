package BINARYTREES;
//https://www.codingninjas.com/studio/problems/sum-tree_10373?leftPanelTab=0
import java.util.*;

public class sumtree {
    /*
     * 
     * Following is the representation of the Binary Tree Node
     * 
     * class BinaryTreeNode<T> {
     * T data;
     * BinaryTreeNode<T> left;
     * BinaryTreeNode<T> right;
     * 
     * public BinaryTreeNode(T data) {
     * this.data = data;
     * }
     * }
     * 
     */
    public static void helper(BinaryTreeNode<Integer> root) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            root.data = 0;
        } else if (root.left != null && root.right != null) {
            root.data = root.left.data + root.right.data;
        } else if (root.left == null) {
            root.data = root.right.data;
        } else {
            root.data = root.left.data;
        }

        helper(root.left);
        helper(root.right);
    }

    public static void preorder(BinaryTreeNode<Integer> root, ArrayList<Integer> ans) {
        if (root == null) {
            return;
        }
        ans.add(root.data);
        preorder(root.left, ans);
        preorder(root.right, ans);
    }

    public static ArrayList<Integer> sumTree(BinaryTreeNode<Integer> root) {
        ArrayList<Integer> ans = new ArrayList<>();
        helper(root);
        preorder(root, ans);
        return ans;

    }

}
