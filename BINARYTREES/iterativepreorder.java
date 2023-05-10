package BINARYTREES;

import java.util.*;

class Node {
    int data;
    Node left, right;

    Node(int item) {
        data = item;
        left = right = null;
    }
}

public class iterativepreorder {

    // Return a list containing the Preorder traversal of the given tree
    ArrayList<Integer> preOrder(Node root) {
        ArrayList<Integer> preorder = new ArrayList<>();
        Stack<Node> st = new Stack<>();
        Node node = root;
        while (true) {
            if (node != null) {
                preorder.add(node.data);
                st.push(node);
                node = node.left;
            } else {
                if (st.isEmpty()) {
                    break;
                }
                node = st.pop();
                node = node.right;
            }

        }
        return preorder;

    }
}
