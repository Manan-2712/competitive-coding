package BINARYTREES.treeconstruction;

public class frompost_in {
    public static BinaryTreeNode<Integer> buildtreehelper2(int post[], int in[], int postS, int postE, int inS,
            int inE) {
        if (postS > postE) {
            return null;
        }
        int data = post[postE];
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
        int leftinS = inS;
        int leftinE = rootindex - 1;
        int rightinE = inE;
        int rightinS = rootindex + 1;
        int leftpostS = postS;
        int leftpostE = leftinE - leftinS + leftpostS;
        int rightpostS = leftpostE + 1;
        int rightpostE = postE - 1;
        root.left = buildtreehelper2(post, in, leftpostS, leftpostE, leftinS, leftinE);
        root.right = buildtreehelper2(post, in, rightpostS, rightpostE, rightinS, rightinE);
        return root;

    }

    public static BinaryTreeNode<Integer> buildtree2(int post[], int in[]) {
        return buildtreehelper2(post, in, 0, post.length - 1, 0, in.length - 1);
    }

}
