package BINARYTREES.treeconstruction;

public class fromprepost {
    public static BinaryTreeNode<Integer> buildtreehelper3(int pre[], int post[], int preS, int preE, int postS,
            int postE) {
        int root = pre[preS];
        BinaryTreeNode<Integer> treeroot = new BinaryTreeNode<Integer>(root);
        if (postS >= postE) {
            return treeroot;
        }

        int leftrootindex = -1;

        for (int i = postS; i <= postE; i++) {
            if (post[i] == pre[preS + 1]) {
                leftrootindex = i;
                break;
            }
        }
        if (leftrootindex == -1) {
            return null;
        }
        int tnel = leftrootindex - postS + 1;

        treeroot.left = buildtreehelper3(pre, post, preS + 1, preS + tnel, postS, leftrootindex);
        treeroot.right = buildtreehelper3(pre, post, preS + tnel + 1, preE, leftrootindex + 1, postE - 1);
        return treeroot;

    }

    public static BinaryTreeNode<Integer> buildtree3(int pre[], int post[]) {
        return buildtreehelper3(pre, post, 0, pre.length - 1, 0, post.length - 1);
    }

}
