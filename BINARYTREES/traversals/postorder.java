//https://www.codingninjas.com/codestudio/problems/name_2035933?leftPanelTab=1

package BINARYTREES.traversals;

import java.util.ArrayList;

public class postorder {
    class BinaryTreeNode<T> {
        T data;
        BinaryTreeNode<T> left;
        BinaryTreeNode<T> right;

        public BinaryTreeNode(T data) {
            this.data = data;
        }
    }

    public static ArrayList<Integer> postorderhelper(BinaryTreeNode<Integer> root, ArrayList<Integer> ans) {
        if (root == null) {
            return ans;
        }
        postorderhelper(root.left, ans);
        postorderhelper(root.right, ans);
        ans.add(root.data);
        return ans;
    }

    public static ArrayList<Integer> postorderTraversal(BinaryTreeNode<Integer> root) {
        ArrayList<Integer> ans = new ArrayList<>();
        ArrayList<Integer> res = postorderhelper(root, ans);
        return res;

    }
}
