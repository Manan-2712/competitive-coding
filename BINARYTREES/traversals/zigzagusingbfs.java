package BINARYTREES.traversals;
//https://leetcode.com/problems/binary-tree-right-side-view/description/
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class zigzagusingbfs {
    public List<Integer> helper(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        TreeNode rightnode = null;
        List<Integer> ans = new ArrayList<>();
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                TreeNode front = q.poll();
                if (front != null) {
                    rightnode = front;
                    if (front.left != null) {
                        q.add(front.left);
                    }
                    if (front.right != null) {
                        q.add(front.right);
                    }
                }
            }

            if (rightnode != null) {
                ans.add(rightnode.val);
            }
        }

        return ans;

    }

    public List<Integer> rightSideView(TreeNode root) {
        // List<Integer> ans = new ArrayList<>();
        // helper(root,ans,0);
        List<Integer> list = helper(root);
        return list;

    }
}
