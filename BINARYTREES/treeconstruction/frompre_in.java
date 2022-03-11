package BINARYTREES.treeconstruction;

public class frompre_in {
    public static BinaryTreeNode<Integer> buildtreehelper(int in[], int pre[], int inS, int inE, int preS, int preE) {
        if (inS > inE) {
            return null;
        }
        int data = pre[preS];
        BinaryTreeNode<Integer> root = new BinaryTreeNode<Integer>(data);
        int rootindex = -1;
        for (int i = inS; i <= inE; i++) {
            if (data == in[i]) {
                rootindex = i;
                break;
            }
        }
        if (rootindex == -1) {
            return null;
        }
        int leftinE = rootindex - 1;
        int leftinS = inS;
        int leftpreS = preS + 1;
        int leftpreE = leftinE - leftinS + leftpreS;
        int rightinE = inE;
        int rightinS = rootindex + 1;
        int rightpreE = preE;
        int rightpreS = leftpreE + 1;
        root.left = buildtreehelper(in, pre, leftinS, leftinE, leftpreS, leftpreE);
        root.right = buildtreehelper(in, pre, rightinS, rightinE, rightpreS, rightpreE);
        return root;
    }

    public static BinaryTreeNode<Integer> buildtree(int in[], int pre[]) {
        return buildtreehelper(in, pre, 0, in.length - 1, 0, pre.length - 1);
    }

}
