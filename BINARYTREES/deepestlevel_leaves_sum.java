package BINARYTREES;

import java.util.*;
import java.io.*;
//https://www.codingninjas.com/studio/guided-paths/data-structures-algorithms/content/118521/offering/1381520?leftPanelTab=1

// Following is the Tree node structure:

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
        this.val = val;
        this.left = null;
        this.right = null;
    }
}

public class deepestlevel_leaves_sum {

    public static int height(TreeNode root) {
        if (root == null) {
            return -1;
        }
        return 1 + Math.max(height(root.left), height(root.right));
    }

    public static int helper(TreeNode root, int currdepth, int maxdepth) {
        if (root == null) {
            return 0;
        }
        if (currdepth == maxdepth) {
            return root.val;
        }
        int left = helper(root.left, currdepth + 1, maxdepth);
        int right = helper(root.right, currdepth + 1, maxdepth);
        return left + right;
    }

    public static int deepestLeavesSum(TreeNode root) {
        int currdepth = 0;
        int maxdepth = height(root);
        int result = helper(root, currdepth, maxdepth);
        return result;

    }
}
