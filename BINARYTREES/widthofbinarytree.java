package BINARYTREES;
//https://leetcode.com/problems/maximum-width-of-binary-tree/description/

import java.util.*;

public class widthofbinarytree {

    public class TreeNode {
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

    class pair {
        TreeNode node;
        int level;

        public pair(TreeNode node, int level) {
            this.node = node;
            this.level = level;

        }
    }

    public int widthOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int ans = 0;
        Queue<pair> q = new LinkedList<>();
        q.add(new pair(root, 0));
        while (!q.isEmpty()) {
            int size = q.size();
            int min = q.peek().level;
            System.out.println(q.peek());
            int first = 0;
            int last = 0;
            for (int i = 0; i < size; i++) {
                int currid = q.peek().level - min;// to prevent overflow(in case of large size= 10^5
                TreeNode node = q.peek().node;
                q.poll();
                if (i == 0) {
                    first = currid;
                }
                if (i == size - 1) {
                    last = currid;
                }
                if (node.left != null) {
                    q.add(new pair(node.left, 2 * currid + 1));
                }
                if (node.right != null) {
                    q.add(new pair(node.right, 2 * currid + 2));
                }
            }
            ans = Math.max(ans, last - first + 1);
        }
        return ans;

    }
}
