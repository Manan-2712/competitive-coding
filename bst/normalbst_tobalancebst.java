//https://www.codingninjas.com/codestudio/problems/normal-bst-to-balanced-bst_920472?leftPanelTab=1
package bst;

import java.util.*;

class TreeNode<T> {
    public T data;
    TreeNode<T> left;
    TreeNode<T> right;

    TreeNode(T data) {
        this.data = data;
        left = null;
        right = null;
    }
}


public class normalbst_tobalancebst {

    public static void inorder(TreeNode<Integer> root,ArrayList<Integer> ans){
        if(root == null){
            return ;
        }
        inorder(root.left,ans);
        ans.add(root.data);
        inorder(root.right,ans);
    }
    public static TreeNode<Integer> inordertobst(int s,int e,ArrayList<Integer> ans){
        if(s>e){
            return null;
        }
        int mid= (s+e)/2;
        TreeNode<Integer> root= new TreeNode<Integer> (ans.get(mid));
        root.left= inordertobst(s,mid-1,ans);
        root.right= inordertobst(mid+1,e,ans);
         return root;
    }
    public static TreeNode<Integer> balancedBst(TreeNode<Integer> root)
    {
       ArrayList<Integer> ans= new ArrayList<>();
        inorder(root,ans);
        TreeNode<Integer> newroot= inordertobst(0,ans.size()-1,ans);
        return newroot;
    }
}

