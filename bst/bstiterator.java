package bst;
//https://leetcode.com/problems/binary-search-tree-iterator/description/
import java.util.*;

// Definition for a binary tree node.
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

public class bstiterator {

    public Stack<TreeNode> stack = new Stack<>();

    public void BSTIterator(TreeNode root) {
        pushAll(root);

    }

    public int next() {
        TreeNode temp = stack.pop();
        pushAll(temp.right);
        return temp.val;
    }

    public boolean hasNext() {
        return !stack.isEmpty();

    }

    public void pushAll(TreeNode root) {
        for (; root != null; stack.push(root), root = root.left)
            ;
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */
