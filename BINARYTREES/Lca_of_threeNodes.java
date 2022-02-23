//https://www.codingninjas.com/codestudio/problems/lca-of-three-nodes_794944?leftPanelTab=1f
package BINARYTREES;
public class Lca_of_threeNodes {


	class BinaryTreeNode<T> {
	    T data;
	    BinaryTreeNode<T> left;
	    BinaryTreeNode<T> right;

	    public BinaryTreeNode(T data) {
		this.data = data;
	    }
	}
	



    public static BinaryTreeNode<Integer> lcahelper(BinaryTreeNode<Integer>root,int node1,int node2,int node3){
        if(root==null){
            return null;
        }
        if(root.data==node1|| root.data==node2 || root.data==node3){
            return root;
        }
        BinaryTreeNode<Integer> left= lcahelper(root.left,node1,node2,node3);
        BinaryTreeNode<Integer>right= lcahelper(root.right,node1,node2,node3);
        if(left !=null && right!=null){
            return root; 
        }
        if(left==null && right!=null){
            return right;
        }
        if(right==null && left!=null){
            return left;
        }
        return null;
    }
    public static BinaryTreeNode<Integer> lcaOfThreeNodes(BinaryTreeNode<Integer> root, int node1, int node2,
            int node3) {
        if(root==null){
            return null;
        }
        BinaryTreeNode<Integer>head= lcahelper(root,node1,node2,node3);
        return head;
    }
}
