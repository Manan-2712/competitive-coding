//https://www.codingninjas.com/codestudio/problems/left-view-of-a-binary-tree_920519?leftPanelTab=1
package BINARYTREES.traversals;

import java.util.ArrayList;

public class leftviewoftree {

    class TreeNode<T> {

        T data;
        TreeNode<T> left;
        TreeNode<T> right;

        TreeNode(T data) {
            this.data = data;
            left = null;
            right = null;
        }
    }

    public static void solve(ArrayList<Integer> list, int level, TreeNode<Integer> root) {
        if (root == null) {
            return;
        }

        if (level == list.size()) {
            list.add(root.data);
        }
        solve(list, level + 1, root.left);
        solve(list, level + 1, root.right);

    }

    public static ArrayList<Integer> getLeftView(TreeNode<Integer> root) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        solve(list, 0, root);
        return list;
    }
}
