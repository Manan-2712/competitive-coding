//https://leetcode.com/problems/binary-tree-level-order-traversal/
package BINARYTREES.traversals;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

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

public class levelorder {

    public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        // List<Integer> list= new ArrayList<>();
        if (root == null) {
            return ans;
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            ArrayList<Integer> list = new ArrayList<>();
            int size = q.size();
            for (int i = 0; i < size; i++) {
                TreeNode tempans = q.remove();
                list.add(tempans.val);
                if (tempans.left != null) {
                    q.add(tempans.left);
                }
                if (tempans.right != null) {
                    q.add(tempans.right);
                }
            }
            ans.add(list);
        }

        // ans.add(list);
        return ans;

    }
}
