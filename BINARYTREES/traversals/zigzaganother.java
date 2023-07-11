package BINARYTREES.traversals;

//https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/submissions/
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class zigzaganother {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> arr = new ArrayList<>();
        System.out.println("base case is going to hit");
        if (root == null) {
            return arr;
        }
        Queue<TreeNode> q = new LinkedList<>();
        int level = 1;
        q.add(root);
        while (!q.isEmpty()) {
            ArrayList<Integer> list = new ArrayList<>();
            int n = q.size();
            for (int i = 0; i < n; i++) {
                TreeNode front = q.peek();
                list.add(front.val);
                q.remove();
                if (front.left != null) {
                    q.add(front.left);
                }
                if (front.right != null) {
                    q.add(front.right);
                }
            }

            if (level == 1) {
                arr.add(list);
            } else {
                Collections.reverse(list);
                arr.add(list);
            }

            level = 1 - level;
        }
        return arr;

    }
}
