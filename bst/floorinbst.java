package bst;

//https://www.codingninjas.com/codestudio/problems/floor-from-bst_920457?source=youtube&campaign=Striver_Tree_Videos&utm_source=youtube&utm_medium=affiliate&utm_campaign=Striver_Tree_Videos&leftPanelTab=0
import java.util.*;
import java.io.*;

public class floorinbst {

    // Following is the TreeNode class structure

    class TreeNode<T> {
        public T data;
        TreeNode<T> left;
        TreeNode<T> right;

        TreeNode(T data) {
            this.data = data;
            left = null;
            right = null;
        }
    };

    public static int floorInBST(TreeNode<Integer> root, int X) {
        int ans = -1;
        while (root != null) {
            if (root.data == X) {
                ans = root.data;
                return ans;
            }
            if (X > root.data) {
                ans = root.data;
                root = root.right;
            } else {
                root = root.left;
            }
        }
        return ans;
    }
}
