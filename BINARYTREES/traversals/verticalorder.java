package BINARYTREES.traversals;

import java.util.*;
//https://leetcode.com/problems/vertical-order-traversal-of-a-binary-tree/description/
class Tuple {
    TreeNode root;
    int vl;
    int hl;

    public Tuple(TreeNode root, int vl, int hl) {
        this.root = root;
        this.vl = vl;
        this.hl = hl;
    }
}

public class verticalorder {
    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode() {}
     * TreeNode(int val) { this.val = val; }
     * TreeNode(int val, TreeNode left, TreeNode right) {
     * this.val = val;
     * this.left = left;
     * this.right = right;
     * }
     * }
     */

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map = new TreeMap<>();
        Queue<Tuple> q = new LinkedList<>();
        q.add(new Tuple(root, 0, 0));
        while (!q.isEmpty()) {
            Tuple curr = q.poll();
            TreeNode node = curr.root;
            int xvl = curr.vl;
            int yhl = curr.hl;
            if (!map.containsKey(xvl)) {
                map.put(xvl, new TreeMap<>());
            }
            if (!map.get(xvl).containsKey(yhl)) {
                map.get(xvl).put(yhl, new PriorityQueue<>());
            }
            map.get(xvl).get(yhl).add(curr.root.val);
            if (node.left != null) {
                q.add(new Tuple(node.left, curr.vl - 1, curr.hl + 1));
            }
            if (node.right != null) {
                q.add(new Tuple(node.right, curr.vl + 1, curr.hl + 1));
            }
        }
        List<List<Integer>> ans = new ArrayList<>();
        for (TreeMap<Integer, PriorityQueue<Integer>> elem : map.values()) {
            // System.out.println(elem);
            ans.add(new ArrayList<>());
            for (PriorityQueue<Integer> m : elem.values()) {
                while (!m.isEmpty()) {
                    ans.get(ans.size() - 1).add(m.poll());
                }
            }
        }
        return ans;
    }
}
