package BINARYTREES;
//https://www.codingninjas.com/codestudio/problems/largest-value-in-each-tree-row_1232659?leftPanelTab=1
import java.util.*;
public class largestvaluetree {

    
    class TreeNode <T> {
        
        public T data;
        TreeNode <T> left;
        TreeNode <T> right;

        TreeNode(T data) {
            this.data = data;
            left = null;
            right = null;
        }
    };



    public static void helper(BinaryTreeNode<Integer> root,ArrayList<Integer> ans,int level){
        if(root==null){
            return; 
        }
        if(level == ans.size()){
            ans.add(root.data);
        }
        else{
            ans.set(level,Math.max(ans.get(level),root.data));
        }
        helper(root.left,ans,level+1);
        helper(root.right,ans,level+1);
        
        
    }
  
    public static int[] largestRow(BinaryTreeNode<Integer> root) {
       ArrayList<Integer> ans= new ArrayList<>();
        helper(root,ans,0);
       int res[]= new int[ans.size()];
        for(int i=0;i<ans.size();i++){
            res[i]= ans.get(i);
        }
        return res;
     
    }
}
