//https://www.codingninjas.com/codestudio/problems/special-binary-tree_920502?leftPanelTab=0
package BINARYTREES;

public class specialbinaryTree {

    class BinaryTreeNode {

        int data;
        BinaryTreeNode left;
        BinaryTreeNode right;

        BinaryTreeNode(int data) {
            this.data = data;
            left = null;
            right = null;
        }
    }

    public static boolean isSpecialBinaryTree(BinaryTreeNode root) {
        if (root == null) {
            return true;
        }
        boolean isleft = isSpecialBinaryTree(root.left);
        boolean isright = isSpecialBinaryTree(root.right);
        if (root.left != null && root.right == null) {
            return false;
        }
        if (root.right != null && root.left == null) {
            return false;
        }
        return isleft && isright;

    }
}
