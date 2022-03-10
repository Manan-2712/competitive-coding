//https://www.codingninjas.com/codestudio/problems/two-sum-in-a-bst_1062631?leftPanelTab=1
package bst;

import java.util.*;

public class pairSum {

    class BinaryTreeNode<T> {
        T data;
        BinaryTreeNode<T> left;
        BinaryTreeNode<T> right;

        public BinaryTreeNode(T data) {
            this.data = data;
        }
    }

    public static void inorder(BinaryTreeNode<Integer> root, ArrayList<Integer> ans) {
        if (root == null) {
            return;
        }
        inorder(root.left, ans);
        ans.add(root.data);
        inorder(root.right, ans);
    }

    public static boolean twoSumInBST(BinaryTreeNode<Integer> root, int target) {
        ArrayList<Integer> ans = new ArrayList<>();
        inorder(root, ans);
        int i = 0;
        int j = ans.size() - 1;
        while (i < j) {
            int sum = ans.get(i) + ans.get(j);
            if (target == sum) {
                return true;
            } else if (sum > target) {
                j--;
            } else {
                i++;
            }
        }
        return false;

    }
}
