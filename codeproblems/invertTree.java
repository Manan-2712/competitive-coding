package codeproblems;
//https://leetcode.com/problems/invert-binary-tree/submissions/
public class invertTree {
    public TreeNode invertTree(TreeNode root) {
         if(root== null){
             return root;
         }
        root.left=invertTree(root.left);
        root.right= invertTree(root.right);
        if(root.left == null){
            root.left= root.right;
            root.right= null;
        }
        else if(root.right == null){
            root.right= root.left;
             root.left= null;
        }
        
        else
        {
            if(root.left !=null &&  root.right!= null){
            TreeNode temp= root.left;
            root.left = root.right;
            root.right = temp;
        }
     
        
    }
        return root;
}
}

