package bst;
import java.util.* ;
import java.io.*; 
//https://www.codingninjas.com/codestudio/problems/bst-from-preorder_2689307?topList=striver-sde-sheet-problems&utm_source=striver&utm_medium=website&leftPanelTab=0
//Following is the Binary Tree node structure
class TreeNode<T> {
    public T data;
    public TreeNode<T> left;
    public TreeNode<T> right;

    TreeNode(T data) {
        this.data = data;
        left = right = null;
    }

};
public class bstfrompreorder2 {

	static int idx;
   public static TreeNode<Integer> helper(int[]preorder,int min,int max){
	   if(idx >= preorder.length){
		   return null;
	   }
	  // System.out.println(idx);
	   if(preorder[idx]<= min || preorder[idx] >= max){
		   return null;
	   }
	   TreeNode<Integer> root = new TreeNode<Integer>(preorder[idx]);
	   idx++;
	   root.left= helper(preorder,min,root.data);
	   root.right = helper(preorder,root.data,max);
	   return root;
   }
	public static TreeNode<Integer> preOrderTree(int[] preOrder) {
 	
	  idx =0;
	
	 int min = Integer.MIN_VALUE;
	 int max = Integer.MAX_VALUE;
	 return helper(preOrder,min,max);	
	}

}
}
