package BINARYTREES;
//https://www.interviewbit.com/problems/path-to-given-node/
import java.util.*;

public class roottonodepath {
    /**
     * Definition for binary tree
     * class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode(int x) {
     * val = x;
     * left=null;
     * right=null;
     * }
     * }
     */
    public ArrayList<Integer> helper(TreeNode A, int B) {
        if (A == null) {
            return null;
        }
        // output.add(A.val);
        if (A.val == B) {
            ArrayList<Integer> output = new ArrayList<>();
            output.add(A.val);
            return output;
        }
        ArrayList<Integer> leftoutput = helper(A.left, B);
        if (leftoutput != null) {
            leftoutput.add(A.val);
            return leftoutput;
        }
        ArrayList<Integer> rightoutput = helper(A.right, B);
        if (rightoutput != null) {
            rightoutput.add(A.val);
            return rightoutput;
        } else {
            return null;
        }

    }

    public ArrayList<Integer> solve(TreeNode A, int B) {

        ArrayList<Integer> ans = helper(A, B);
        Collections.reverse(ans);
        return ans;

    }
}
