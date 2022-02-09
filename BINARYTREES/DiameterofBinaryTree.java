//https://www.codingninjas.com/codestudio/problems/find-diameter_5205
package BINARYTREES;
import java .util.Queue;
import java.util.LinkedList;
import java.util.Scanner;
	class BinaryTreeNode<T> {
		T data;
		BinaryTreeNode<T> left;
		BinaryTreeNode<T> right;

		public BinaryTreeNode(T data) {
			this.data = data;
			this.left = null;
			this.right = null;
		}
	}



public class DiameterofBinaryTree {

      public static int height(BinaryTreeNode<Integer> root) {
        if (root == null) {
            return 0;
        }
        int lh = height(root.left);
        int rh = height(root.right);
        return 1 + Math.max(lh, rh);
    }
   
	public static int diameterOfBinaryTree(BinaryTreeNode<Integer> root){
        if (root == null) {
            return 0;
        }
        int op1 = height(root.left) + height(root.right);
        int op2 = diameterOfBinaryTree(root.left);
        int op3 = diameterOfBinaryTree(root.right);
        return 1+Math.max(op1, Math.max(op2, op3));
    }  
	
}
	

    

