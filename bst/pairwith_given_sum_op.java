package bst;
//https://leetcode.com/problems/two-sum-iv-input-is-a-bst/description/
import java.util.*;

public class pairwith_given_sum_op {

    // OPTIMISED APPROACH 2
    public class BSTIterator {
        public Stack<TreeNode> stack = new Stack<>();
        boolean reverse = true;

        public BSTIterator(TreeNode root, boolean isReverse) {
            reverse = isReverse;
            pushAll(root);

        }

        public int next() {
            TreeNode temp = stack.pop();
            if (reverse == true) {
                pushAll(temp.left);
            } else {
                pushAll(temp.right);
            }
            return temp.val;
        }

        public boolean hasNext() {
            return !stack.isEmpty();

        }

        public void pushAll(TreeNode root) {
            while (root != null) {
                stack.push(root);
                if (reverse == true) {
                    root = root.right;
                } else {
                    root = root.left;
                }
            }
        }
    }

    class Solution {
        public boolean findTarget(TreeNode root, int k) {
            if (root == null) {
                return false;
            }
            // for next;
            BSTIterator l = new BSTIterator(root, false);
            // for before
            BSTIterator r = new BSTIterator(root, true);
            int i = l.next();
            int j = r.next();
            while (i < j) {
                if ((i + j) == k) {
                    return true;
                } else if (i + j < k) {
                    i = l.next();
                } else {
                    j = r.next();
                }
            }
            return false;
        }
    }
}
