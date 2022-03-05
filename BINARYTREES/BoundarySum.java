//https://www.codingninjas.com/codestudio/problems/boundary-sum_790724?topList=top-amazon-coding-interview-questions&leftPanelTab=1

package BINARYTREES;

public class BoundarySum {

    class BinaryTreeNode<Integer> {
        int data;
        BinaryTreeNode<Integer> left;
        BinaryTreeNode<Integer> right;

        public BinaryTreeNode(int data) {
            this.data = data;
        }
    }

    public static int leftsum(BinaryTreeNode<Integer> root) {
        int sum = 0;
        if (root == null || (root.left == null && root.right == null)) {
            return 0;
        }
        sum += root.data;
        if (root.left != null) {
            sum += leftsum(root.left);
        } else {
            sum += leftsum(root.right);
        }
        return sum;
    }

    public static int rightsum(BinaryTreeNode<Integer> root) {
        int sumr = 0;
        if (root == null || (root.right == null && root.left == null)) {
            return 0;
        }

        sumr += root.data;
        if (root.right != null) {
            sumr += rightsum(root.right);
        } else {
            sumr += rightsum(root.left);
        }

        return sumr;
    }

    public static int leafsum(BinaryTreeNode<Integer> root) {
        int suml = 0;
        if (root == null) {
            return 0;
        }

        if (root.left == null && root.right == null) {
            suml += root.data;
        }
        suml += leafsum(root.left);
        suml += leafsum(root.right);
        return suml;
        // return left+right;
    }

    public static int boundarySum(BinaryTreeNode<Integer> root) {

        if (root != null) {

            // Add the root node to the sum.
            int sum = root.data;

            // Find the left most boundary sum with left subtree.
            sum += leftsum(root.left);

            // Sum of leaf nodes of left subtree.
            sum += leafsum(root.left);

            // Sum of leaf nodes of right subtree.
            sum += leafsum(root.right);

            // Find the right most boundary sum with right subtree.
            sum += rightsum(root.right);

            // Return answer.
            return sum;
        }
        return 0;
    }
}
