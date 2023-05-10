package BINARYTREES.traversals;
//https://practice.geeksforgeeks.org/problems/inorder-traversal-iterative/1
import java.util.*;

public class iterativeinorder {
    class Node {
        int data;
        Node left, right;

        Node(int item) {
            data = item;
            left = right = null;
        }
    }

    // Return a list containing the inorder traversal of the given tree
    ArrayList<Integer> inOrder(Node root) {
        ArrayList<Integer> inorder = new ArrayList<>();
        Stack<Node> st = new Stack<>();
        Node node = root;
        while (true) {
            if (node != null) {
                st.push(node);
                node = node.left;
            } else {
                if (st.isEmpty()) {
                    break;
                }
                node = st.pop();
                inorder.add(node.data);
                node = node.right;

            }
        }
        return inorder;
    }

}
