//https://www.codingninjas.com/codestudio/problems/pair-sum-in-bst_920493?leftPanelTab=0

package BINARYTREES;

import java.util.*;

public class pair_sum_inbst {

    class BinaryTreeNode {

        int data;
        BinaryTreeNode left;
        BinaryTreeNode right;

        BinaryTreeNode(int data) {
            this.data = data;
            left = null;
            right = null;
        }
    }

    public static void inorder(BinaryTreeNode root, ArrayList<Integer> nums) {
        if (root == null) {
            return;
        }
        inorder(root.left, nums);
        nums.add(root.data);
        inorder(root.right, nums);
    }

    public static boolean pairSumBst(BinaryTreeNode root, int k) {
        ArrayList<Integer> nums = new ArrayList<>();
        inorder(root, nums);
        int i = 0;
        int j = nums.size() - 1;
        while (i < j) {
            if (nums.get(i) + nums.get(j) == k) {
                return true;
            } else if (nums.get(i) + nums.get(j) > k) {
                j--;
            } else {
                i++;
            }
        }
        return false;

    }
}
