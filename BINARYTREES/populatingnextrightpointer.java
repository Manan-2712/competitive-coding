package BINARYTREES;

//https://leetcode.com/problems/populating-next-right-pointers-in-each-node/description/
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {
    }

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};

public class populatingnextrightpointer {

    // Definition for a Node.

    public Node connect(Node root) {
        Node strtnode = root;// starting point of a process
        while (strtnode != null && strtnode.left != null) {
            Node n = strtnode;// start node of every level
            while (n != null) {
                n.left.next = n.right;
                if (n.next == null) {
                    break;
                }
                n.right.next = n.next.left;
                n = n.next;
            }
            strtnode = strtnode.left;
        }
        return root;

    }
}
