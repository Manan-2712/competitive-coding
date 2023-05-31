package bst;

//https://www.codingninjas.com/codestudio/problems/893103?topList=striver-sde-sheet-problems&utm_source=striver&utm_medium=website
class bstval {
    int min;
    int max;
    int size;
    boolean isbst;

}

public class sizeoflargest_bst {

    // Following is the class structure of the Node class:

    class TreeNode<T> {
        public T data;
        public TreeNode<T> left;
        public TreeNode<T> right;

        TreeNode(T data) {
            this.data = data;
            left = null;
            right = null;
        }
    }

    public static bstval bsthelper(TreeNode<Integer> root) {
        if (root == null) {
            bstval b = new bstval();
            b.min = Integer.MAX_VALUE;
            b.max = Integer.MIN_VALUE;
            b.size = 0;
            b.isbst = true;
            return b;
        }
        bstval left = bsthelper(root.left);
        bstval right = bsthelper(root.right);
        bstval ans = new bstval();
        ans.isbst = (left.isbst && right.isbst && (root.data >= left.max && root.data < right.min));
        ans.min = Math.min(root.data, Math.min(left.min, right.min));
        ans.max = Math.max(root.data, Math.max(left.max, right.max));
        if (ans.isbst) {
            ans.size = left.size + right.size + 1;
            return ans;
        } else if (left.size > right.size) {
            ans.size = left.size;
        } else {
            ans.size = right.size;
        }

        return ans;
    }

    public static int largestBST(TreeNode<Integer> root) {
        bstval bs = bsthelper(root);
        return bs.size;

    }
}
