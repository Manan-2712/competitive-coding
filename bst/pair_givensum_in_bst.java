package bst;

import java.util.*;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class pair_givensum_in_bst {

    // Definition for a binary tree node.

    public boolean helper(TreeNode root, int target, Set<Integer> set) {
        if (root == null) {
            return false;
        }
        if (helper(root.left, target, set) == true) {
            return true;
        }
        if (set.contains(target - root.val)) {
            return true;
        }
        set.add(root.val);
        return helper(root.right, target, set);
    }

    public boolean findTarget(TreeNode root, int k) {
        Set<Integer> set = new HashSet<>();
        return helper(root, k, set);

    }
}
