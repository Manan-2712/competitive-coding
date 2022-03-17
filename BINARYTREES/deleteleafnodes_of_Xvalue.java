package BINARYTREES;

class BinaryTreeNode<T> {
    T data;
    BinaryTreeNode<T> left;
    BinaryTreeNode<T> right;

    public BinaryTreeNode(T data) {
        this.data = data;
    }
}

public class deleteleafnodes_of_Xvalue {

    public static BinaryTreeNode<Integer> deleteLeafNodes(BinaryTreeNode<Integer> root, int x) {
        if (root == null) {
            return null;
        }
        root.left = deleteLeafNodes(root.left, x);
        root.right = deleteLeafNodes(root.right, x);
        if (root.data == x && (root.left == null && root.right == null)) {
            return null;
        }
        return root;
    }
}
