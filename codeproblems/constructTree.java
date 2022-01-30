package codeproblems;

//https://www.codingninjas.com/codestudio/problems/construct-tree-from-preorder-inorder_699832?leftPanelTab=1
class BinaryTreeNode<T> {
    T data;
    BinaryTreeNode<T> left;
    BinaryTreeNode<T> right;

    public BinaryTreeNode(T data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}

public class constructTree {

    public static BinaryTreeNode<Integer> buildTreeHelper(int[] preOrder, int[] inOrder, int preS, int preE, int inS,
            int inE) {
        if (inS > inE) {
            return null;
        }
        int rootdata = preOrder[preS];
        BinaryTreeNode<Integer> root = new BinaryTreeNode<Integer>(rootdata);
        int rootindex = -1;
        for (int i = inS; i <= inE; i++) {
            if (inOrder[i] == rootdata) {
                rootindex = i;
                break;
            }
        }
        if (rootindex == -1) {
            return null;
        }
        int leftInS = inS;
        int leftPreS = preS + 1;
        int leftInE = rootindex - 1;
        int leftPreE = leftInE - leftInS + leftPreS;
        int rightInS = rootindex + 1;
        int rightPreS = leftPreE + 1;
        int rightInE = inE;
        int rightPreE = preE;
        root.left = buildTreeHelper(preOrder, inOrder, leftPreS, leftPreE, leftInS, leftInE);
        root.right = buildTreeHelper(preOrder, inOrder, rightPreS, rightPreE, rightInS, rightInE);
        return root;

    }

    public static BinaryTreeNode<Integer> buildTree(int[] preOrder, int[] inOrder) {
        return buildTreeHelper(preOrder, inOrder, 0, preOrder.length - 1, 0, inOrder.length - 1);
    }

}
