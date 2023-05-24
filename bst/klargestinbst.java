package bst;

class Node {
    int data;
    Node left;
    Node right;

    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}

public class klargestinbst {

    static int count;

    // return the Kth largest element in the given BST rooted at 'root'
    public int helper(Node root, int k) {
        if (root == null) {
            return -1;
        }
        int left = helper(root.right, k);
        if (left != -1) {
            return left;
        }
        // System.out.println(count+" "+root.val);
        count++;
        if (count == k) {
            return root.data;
        }
        return helper(root.left, k);
    }

    public int kthLargest(Node root, int K) {

        count = 0;
        return helper(root, K);

    }
}
