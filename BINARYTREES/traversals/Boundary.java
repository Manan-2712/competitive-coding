//https://www.codingninjas.com/codestudio/problems/boundary-traversal_790725?leftPanelTab=1
package BINARYTREES.traversals;

import java.util.ArrayList;

public class Boundary {

    class TreeNode {
        int data;
        TreeNode left;
        TreeNode right;

        TreeNode(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }

    }

    public static void lefttraversal(TreeNode root, ArrayList<Integer> ans) {
        if (root == null || (root.left == null && root.right == null)) {
            return;
        }
        ans.add(root.data);
        if (root.left != null) {
            lefttraversal(root.left, ans);
        } else {
            lefttraversal(root.right, ans);
        }
    }

    public static void leaftraversal(TreeNode root, ArrayList<Integer> ans) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            ans.add(root.data);
            return;
        }
        leaftraversal(root.left, ans);
        leaftraversal(root.right, ans);
    }

    public static void righttraversal(TreeNode root, ArrayList<Integer> ans) {
        if (root == null || (root.right == null && root.left == null)) {
            return;
        }
        if (root.right != null) {
            righttraversal(root.right, ans);
        } else {
            righttraversal(root.left, ans);
        }
        ans.add(root.data);
    }

    public static ArrayList<Integer> traverseBoundary(TreeNode root) {
        ArrayList<Integer> ans = new ArrayList<Integer>();
        if (root == null) {
            return ans;
        }

        ans.add(root.data);
        lefttraversal(root.left, ans);
        leaftraversal(root.left, ans);
        leaftraversal(root.right, ans);
        righttraversal(root.right, ans);
        return ans;
    }
}
