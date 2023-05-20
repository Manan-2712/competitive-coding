package BINARYTREES;
//https://www.codingninjas.com/codestudio/problems/childrensumproperty_790723?topList=striver-sde-sheet-problems&utm_source=striver&utm_medium=website&leftPanelTab=1
public class childsumproperty {

    // Following is the Binary Tree node structure

    class BinaryTreeNode<Integer> {
        int data;
        BinaryTreeNode<Integer> left;
        BinaryTreeNode<Integer> right;

        public BinaryTreeNode(int data) {
            this.data = data;
        }
    }

    public static void changeTree(BinaryTreeNode<Integer> root) {
        int child = 0;
        if (root == null) {
            return;
        }
        if (root.left != null) {
            child += root.left.data;
        }
        if (root.right != null) {
            child += root.right.data;
        }
        if (child >= root.data) {
            root.data = child;
        } else {
            if (root.left != null) {
                root.left.data = root.data;
            } else if (root.right != null) {
                root.right.data = root.data;
            }
        }
        changeTree(root.left);
        changeTree(root.right);
        int tot = 0;
        if (root.left != null) {
            tot += root.left.data;
        }
        if (root.right != null) {
            tot += root.right.data;
        }
        if (root.left != null || root.right != null) {
            root.data = tot;
        }

    }
}
