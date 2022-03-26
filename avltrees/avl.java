package avltrees;
class avlnode{
    int data;
    avlnode left= null;
    avlnode right= null;
    int height=0;
    int bal=0;



    public avlnode(int data){
        this.data=data;
    }
}

public class avl {
   

    public static void updataheightandbalance(avlnode node){
        int lh=-1;
        int rh=-1;
        if(node.left!=null){
            lh= node.left.height;
        }
        if(node.right!=null){
            rh= node.right.height;
        }
        int bal= lh-rh;
        int height=1+Math.max(lh, rh);
        node.height= height;
        node.bal= bal;
    }
    public static avlnode rightrotation(avlnode nodeA){
       avlnode nodeB= nodeA.left;
       avlnode nodeBright= nodeB.right;
       nodeB.right= nodeA;  
       nodeA.left= nodeBright;
       updataheightandbalance(nodeA);
       updataheightandbalance(nodeB);
       return nodeB;
        
    }
    public static avlnode leftrotation(avlnode nodeA){
        avlnode nodeB= nodeA.right;
        avlnode nodeBleft= nodeB.left;
        nodeB.left= nodeA;
        nodeA.right= nodeBleft;
        updataheightandbalance(nodeA);
        updataheightandbalance(nodeB);
        return nodeB;
    }
    public static avlnode getrotation(avlnode root){
        updataheightandbalance(root);
        if(root.bal==2){
            if(root.left.bal==1){
             return  rightrotation(root);

            }else{
                root.left= leftrotation(root.left);
                return rightrotation(root);

            }

        }
        else if(root.bal==-2){
            if(root.right.bal==1){
               return leftrotation(root);
            }
            else{
                root.right= leftrotation(root.right);
                return leftrotation(root);

            }
        }
        return root;
    }
    public static avlnode insertdata(avlnode root,int data){
        if(root==null){
            return null;
        }
        if(data<root.data){
            root.left= insertdata(root.left, data);
        }
        else{
            root.right= insertdata(root.right, data);
        }
        root= getrotation(root);
        return root;
    }
    public static avlnode deletedata(avlnode root,int data){
        if(root==null){
            return null;
        }
        if(data<root.data){
            root.left= deletedata(root.left, data);
        }
        else if(data>root.data){
            root.right= deletedata(root.right, data);
        }
        else if(data== root.data){
            if(root.left==null || root.right==null){
                return root.left!=null?root.left:root.right;
            }
            else{
                avlnode maxnode = getmaxnode(root.left);
                root.data= maxnode.data;

                root.left= deletedata(root.left, maxnode.data);
            }
        }
        root= getrotation(root);
        return root;
    }
    public static avlnode getmaxnode(avlnode root){
        avlnode curr= root;
        while(curr.right!=null ){
            curr= curr.right;
        }
        return curr;
    }
    
}

