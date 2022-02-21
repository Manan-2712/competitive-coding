//https://leetcode.com/problems/second-minimum-node-in-a-binary-tree/submissions/

package BINARYTREES;

import java.util.ArrayList;
import java.util.*;

public class second_minimum_nodein_tree {

    public class TreeNode {
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

    public static void inorder(TreeNode root, ArrayList<Integer> ans) {
        if (root == null) {
            return;
        }
        inorder(root.left, ans);
        ans.add(root.val);
        inorder(root.right, ans);
    }

    public int findSecondMinimumValue(TreeNode root, ArrayList<Integer> Collections) {
        ArrayList<Integer> ans = new ArrayList<>();
        inorder(root, ans);
        Collections.sort(ans);
        for (int i = 0; i < ans.size(); i++) {
            int n1 = ans.get(i);
            int n2 = ans.get(0);
            if (n1 != n2) {
                return n1;
            }
        }
        return -1;
    }
}
