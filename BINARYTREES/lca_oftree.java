//https://www.codingninjas.com/codestudio/problems/lca-of-binary-tree_920541?leftPanelTab=1

package BINARYTREES;

public class lca_oftree {

    class TreeNode<T> {
        // public:
        T data;
        TreeNode<T> left;
        TreeNode<T> right;

        TreeNode(T data) {
            this.data = data;
            left = null;
            right = null;
        }
    };

    public static int lowestCommonAncestor(TreeNode<Integer> root, int x, int y) {
        if (root == null) {
            return -1;
        }
        if (root.data == x || root.data == y) {
            return root.data;
        }
        int left = lowestCommonAncestor(root.left, x, y);
        int right = lowestCommonAncestor(root.right, x, y);
        if (left == -1) {
            return right;
        }
        if (right == -1) {
            return left;
        }
        return root.data;
    }
}
