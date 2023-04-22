package LinkedLists;
//https://practice.geeksforgeeks.org/problems/flattening-a-linked-list/1
public class flatteningoflinkedlist {

    // Node class used in the program
    class Node {
        int data;
        Node next;
        Node bottom;

        Node(int d) {
            data = d;
            next = null;
            bottom = null;
        }
    }

    /*
     * Function which returns the root of
     * the flattened linked list.
     */
    class GfG {
        Node mergetwolist(Node root1, Node root2) {
            Node temp = new Node(0);
            Node res = temp;
            while (root1 != null && root2 != null) {
                if (root1.data < root2.data) {
                    temp.bottom = root1;
                    temp = temp.bottom;
                    root1 = root1.bottom;
                } else {
                    temp.bottom = root2;
                    temp = temp.bottom;
                    root2 = root2.bottom;
                }
            }
            if (root1 != null) {
                temp.bottom = root1;
            } else {
                temp.bottom = root2;
            }

            return res.bottom;

        }

        Node flatten(Node root) {
            if (root == null || root.next == null) {
                return root;
            }
            root.next = flatten(root.next);
            root = mergetwolist(root, root.next);
            return root;

        }
    }
}
