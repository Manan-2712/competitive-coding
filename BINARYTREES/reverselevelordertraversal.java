//https://www.codingninjas.com/codestudio/problems/reverse-level-order-traversal_764339?leftPanelTab=1
package BINARYTREES;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.*;

    class TreeNode {
		int data;
		TreeNode left;
		TreeNode right;
		TreeNode(int data) {
			this.data = data;
			this.left = null;
			this.right = null;
		}
	}

    public class reverselevelordertraversal {
	public static ArrayList<Integer> reverseLevelOrder(TreeNode root) {

       ArrayList <Integer> res= new ArrayList<Integer>();
       
        if (root == null ) {
         
            return res;
        }
     

        Queue<TreeNode> pendingnodes = new LinkedList<>();
        pendingnodes.add(root);
    
        while (!pendingnodes.isEmpty()) {
             root = pendingnodes.poll();
         
            res.add(root.data);

            if (root.left != null) {
            
                pendingnodes.add(root.left);
             
            }
     
            if (root.right != null) {
         
                pendingnodes.add(root.right);
          
            }
        }
        Collections.reverse(res);
        return res;

    }
	}

    

