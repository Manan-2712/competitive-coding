//https://practice.geeksforgeeks.org/problems/maximum-sum-of-non-adjacent-nodes/1#

package BINARYTREES;

class pair<T, V> {
    T first;
    V second;

}

public class maximumsum_of_nonadjacentnodes {

    // User function Template for Java
    class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public static pair<Integer, Integer> getMaxSumhelper(Node root) {
        if (root == null) {
            pair<Integer, Integer> p = new pair<Integer, Integer>();
            p.first = 0;
            p.second = 0;
            return p;
        }

        pair<Integer, Integer> left = getMaxSumhelper(root.left);
        pair<Integer, Integer> right = getMaxSumhelper(root.right);
        pair<Integer, Integer> res = new pair<>();
        res.first = root.data + left.second + right.second;
        res.second = Math.max(left.first, left.second) + Math.max(right.first, right.second);
        return res;
    }

    static int getMaxSum(Node root) {
        pair<Integer, Integer> result = getMaxSumhelper(root);
        return Math.max(result.first, result.second);

    }
}
