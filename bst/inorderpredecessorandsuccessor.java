package bst;
//https://practice.geeksforgeeks.org/problems/predecessor-and-successor/1
class Node
{
	int key;
	Node left, right;
	
	Node(int item)
	{
	     data = item;
	    left = right = null;
	}
}


public class inorderpredecessorandsuccessor {
    public static void findPreSuc(Node root, Res p, Res s, int key) {
        p.pre = null;
        Node temp = root;
        while (temp != null) {
            if (temp.data >= key) {
                temp = temp.left;
            } else {
                p.pre = temp;
                temp = temp.right;
            }

        }
        s.succ = null;
        // Node temp = root;
        while (root != null) {
            if (key >= root.data) {
                root = root.right;
            } else {
                s.succ = root;
                root = root.left;
            }
        }
    }
}
