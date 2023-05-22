package bst;
//https://www.codingninjas.com/codestudio/problems/ceil-from-bst_920464?source=youtube&campaign=Striver_Tree_Videos&utm_source=youtube&utm_medium=affiliate&utm_campaign=Striver_Tree_Videos&leftPanelTab=1
import java.util.*;
import java.io.*;

public class ceil_inbst {

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

    public static int findCeil(TreeNode<Integer> node, int x) {

        int ans = -1;
        while (node != null) {
            if (node.data == x) {
                ans = node.data;
                return ans;
            }
            if (node.data > x) {
                ans = node.data;
                node = node.left;
            } else {
                node = node.right;
            }
        }
        return ans;

    }
}
