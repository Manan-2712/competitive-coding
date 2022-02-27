
package BINARYTREES;

public class replace_nodetodepth {

    class BinaryTreeNode<Integer> {
        int data;
        BinaryTreeNode<Integer> left;
        BinaryTreeNode<Integer> right;

        public BinaryTreeNode(int data) {
            this.data = data;
        }
    }

    public static BinaryTreeNode<Integer> helper(BinaryTreeNode<Integer> root, int level) {
        if (root == null) {
            return null;
        }
        root.data = level;
        BinaryTreeNode<Integer> left = helper(root.left, level + 1);
        BinaryTreeNode<Integer> right = helper(root.right, level + 1);
        return root;

    }

    public static BinaryTreeNode<Integer> changeToDepthTree(BinaryTreeNode<Integer> root) {
        BinaryTreeNode<Integer> roots = helper(root, 0);
        return roots;
    }
}
