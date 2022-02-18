//https://www.codingninjas.com/codestudio/problems/zigzag-binary-tree-traversal_920532?leftPanelTab=1
package BINARYTREES.traversals;

import java.util.ArrayList;
import java.util.*;

public class zigzag {
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

    public static ArrayList<Integer> zigzagTreeTraversal(TreeNode<Integer> root) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        Queue<TreeNode<Integer>> q = new LinkedList<>();
        q.add(root);
        boolean leftoright = true;
        while (!q.isEmpty()) {
            int size = q.size();
            int ans[] = new int[size];
            for (int i = 0; i < ans.length; i++) {
                TreeNode<Integer> frontnode = q.poll();

                int index = leftoright ? i : ans.length - i - 1;
                ans[index] = frontnode.data;
                if (frontnode.left != null) {
                    q.add(frontnode.left);
                }
                if (frontnode.right != null) {
                    q.add(frontnode.right);
                }
            }
            leftoright = !leftoright;
            for (int i : ans) {
                result.add(i);
            }
        }
        return result;

    }
}
