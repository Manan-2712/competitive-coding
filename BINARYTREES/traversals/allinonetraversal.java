package BINARYTREES.traversals;
//https://www.codingninjas.com/codestudio/problems/981269?topList=striver-sde-sheet-problems&utm_source=striver&utm_medium=website&leftPanelTab=0
import java.util.ArrayList;
import java.util.*;

class BinaryTreeNode<T> {
    T data;
    BinaryTreeNode<T> left;
    BinaryTreeNode<T> right;

    public BinaryTreeNode(T data) {
        this.data = data;
    }
}

class pair {
    BinaryTreeNode<Integer> node;
    int num;

    public pair(BinaryTreeNode<Integer> node, int num) {
        this.node = node;
        this.num = num;
    }
}

public class allinonetraversal {

    public static List<List<Integer>> getTreeTraversal(BinaryTreeNode<Integer> root) {
        Stack<pair> st = new Stack<>();

        List<List<Integer>> arr = new ArrayList<>();
        if (root == null) {
            return arr;
        }
        List<Integer> preorder = new ArrayList<>();
        List<Integer> inorder = new ArrayList<>();
        List<Integer> postorder = new ArrayList<>();
        st.push(new pair(root, 1));
        while (!st.isEmpty()) {
            pair curr = st.pop();
            if (curr.num == 1) {
                preorder.add(curr.node.data);
                curr.num++;
                st.push(curr);
                if (curr.node.left != null) {
                    st.push(new pair(curr.node.left, 1));
                }
            } else if (curr.num == 2) {
                inorder.add(curr.node.data);
                curr.num++;
                st.push(curr);
                if (curr.node.right != null) {
                    st.push(new pair(curr.node.right, 1));
                }
            } else {
                postorder.add(curr.node.data);
            }
        }
        arr.add(inorder);
        arr.add(preorder);
        arr.add(postorder);
        return arr;

    }
}
