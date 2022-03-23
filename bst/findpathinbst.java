package bst;

import java.util.ArrayList;

class BinaryTreeNode<T> {
    T data;
    BinaryTreeNode<T> left;
    BinaryTreeNode<T> right;

    public BinaryTreeNode(T data) {
        this.data = data;
    }
}

public class findpathinbst {

    public static ArrayList<Integer> getPath(BinaryTreeNode<Integer> root, int data) {
        if (root == null) {
            return null;
        }
        if (root.data == data) {
            ArrayList<Integer> ans = new ArrayList<>();
            ans.add(root.data);
            return ans;
        }

        ArrayList<Integer> leftoutput = getPath(root.left, data);
        if (leftoutput != null) {
            leftoutput.add(root.data);
            return leftoutput;
        }
        ArrayList<Integer> rightoutput = getPath(root.right, data);
        if (rightoutput != null) {
            rightoutput.add(root.data);
            return rightoutput;
        } else {
            return null;
        }
    }
}
