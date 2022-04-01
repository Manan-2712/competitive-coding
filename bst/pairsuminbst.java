//https://www.codingninjas.com/codestudio/problems/pair-sum-in-a-bst_920507?leftPanelTab=1
package bst;

import java.util.ArrayList;

public class pairsuminbst {

    class TreeNode<T> {
        public T data;
        TreeNode<T> left;
        TreeNode<T> right;

        TreeNode(T data) {
            this.data = data;
            left = null;
            right = null;
        }
    };

    public static void inorder(TreeNode<Integer> root, ArrayList<Integer> list) {
        if (root == null) {
            return;
        }
        inorder(root.left, list);
        list.add(root.data);
        inorder(root.right, list);
    }

    public static ArrayList<ArrayList<Integer>> printNodesSumToS(TreeNode<Integer> root, int s) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        inorder(root, list);
        ArrayList<Integer> ans = new ArrayList<>();
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        int i = 0;
        int j = list.size() - 1;
        while (i < j) {
            if (list.get(i) + list.get(j) == s) {
                ans.add(list.get(i));
                ans.add(list.get(j));
                i++;
                j--;
            } else if (list.get(i) + list.get(j) < s) {
                i++;
            } else {
                j--;
            }
        }
        if (ans.isEmpty()) {
            ans.add(-1);
            ans.add(-1);
        }
        res.add(ans);
        return res;

    }
}
