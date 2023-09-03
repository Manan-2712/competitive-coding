
package BINARYTREES;
//https://www.codingninjas.com/studio/problems/convert-a-given-binary-tree-to-doubly-linked-list_893106?topic=trees&leftPanelTab=0
import java.util.*;
import java.io.*;

class BinaryTreeNode<T> {
    T data;
    BinaryTreeNode<T> left;
    BinaryTreeNode<T> right;

    public BinaryTreeNode(T data) {
        this.data = data;
    }
}

public class binarytree_to_DLL {

    static BinaryTreeNode<Integer> head;
    static BinaryTreeNode<Integer> prev;

    public static void helper(BinaryTreeNode<Integer> root) {
        if (root == null) {
            return;
        }
        helper(root.left);
        if (head == null) {
            head = root;
        }
        root.left = prev;
        if (prev != null) {
            prev.right = root;
        }
        prev = root;
        helper(root.right);

    }

    public static BinaryTreeNode<Integer> BTtoDLL(BinaryTreeNode<Integer> root) {
        prev = null;
        head = null;
        helper(root);
        return head;

    }

}
