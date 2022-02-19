//https://www.codingninjas.com/codestudio/problems/kth-ancestor-of-a-node-in-binary-tree_842561?leftPanelTab=1

package BINARYTREES;

import java.util.*;
import java.io.*;

public class kthancestor_of_tree {

    class BinaryTreeNode<T> {
        T data;
        BinaryTreeNode<T> left;
        BinaryTreeNode<T> right;

        public BinaryTreeNode(T data) {
            this.data = data;
        }
    }

    static int kth;

    public static BinaryTreeNode<Integer> kanc(BinaryTreeNode<Integer> root, int targetNodeVal) {
        if (root == null) {
            return null;
        }
        if (root.data == targetNodeVal) {
            return root;
        }
        BinaryTreeNode<Integer> left = kanc(root.left, targetNodeVal);
        BinaryTreeNode<Integer> right = kanc(root.right, targetNodeVal);
        if (left != null && right == null) {
            kth--;
            if (kth <= 0) {
                kth = Integer.MAX_VALUE;
                return root;
            }
            return left;
        }
        if (right != null && left == null) {
            kth--;
            if (kth <= 0) {
                kth = Integer.MAX_VALUE;
                return root;
            }
            return right;
        }
        return null;
    }

    static int findKthAncestor(BinaryTreeNode<Integer> root, int targetNodeVal, int k) {
        kth = k;
        BinaryTreeNode<Integer> node = kanc(root, targetNodeVal);
        if (node == null || node.data == targetNodeVal) {
            return -1;
        } else {
            return node.data;
        }

    }
}
