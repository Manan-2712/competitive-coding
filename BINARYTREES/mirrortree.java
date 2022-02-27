//https://www.codingninjas.com/codestudio/problems/convert-binary-tree-to-mirror-tree_873140?leftPanelTab=0
package BINARYTREES;

public class mirrortree {

    class BinaryTreeNode {

        int data;
        BinaryTreeNode left;
        BinaryTreeNode right;

        BinaryTreeNode(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public static void mirrorTree(BinaryTreeNode root) {
        if (root == null) {
            return;
        }
        BinaryTreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        mirrorTree(root.left);
        mirrorTree(root.right);
    }
}
