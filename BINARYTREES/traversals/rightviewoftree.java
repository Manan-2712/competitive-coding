//https://www.codingninjas.com/codestudio/problems/right-view_764605?leftPanelTab=1
package BINARYTREES.traversals;

import java.util.*;

class BinaryTreeNode<T> {
    int data;
    BinaryTreeNode<Integer> left;
    BinaryTreeNode<Integer> right;

    public BinaryTreeNode(int data) {
        this.data = data;
    }
}

public class rightviewoftree {

    public static void solve(ArrayList<Integer> list, int level, BinaryTreeNode<Integer> root) {
        if (root == null) {
            return;
        }
        // ArrayList<Integer>list = new ArrayList<Integer>();

        if (level == list.size()) {
            list.add(root.data);
        }
        solve(list, level + 1, root.right);
        solve(list, level + 1, root.left);

    }

    public static ArrayList<Integer> printRightView(BinaryTreeNode<Integer> root) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        solve(list, 0, root);
        return list;
    }

}
