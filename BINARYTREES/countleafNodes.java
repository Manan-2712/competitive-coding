//https://www.codingninjas.com/codestudio/problems/count-leaf-nodes_893055?leftPanelTab=1
package BINARYTREES;

public class countleafNodes {

    class BinaryTreeNode<T> {
        T data;
        BinaryTreeNode<T> left;
        BinaryTreeNode<T> right;

        public BinaryTreeNode(T data) {
            this.data = data;
        }
    }

    public static int noOfLeafNodes(BinaryTreeNode<Integer> root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }
        int left = noOfLeafNodes(root.left);
        int right = noOfLeafNodes(root.right);
        return left + right;
    }
}
