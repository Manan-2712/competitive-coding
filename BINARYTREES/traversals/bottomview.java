//https://www.codingninjas.com/codestudio/problems/bottom-view-of-binary-tree_893110
package BINARYTREES.traversals;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;
public class bottomview {


    class BinaryTreeNode {
        int val;
        BinaryTreeNode left;
        BinaryTreeNode right;

        BinaryTreeNode(int val) {
            this.val = val;
            this.left = null;
            this.right = null;
        }
    }



    class Pair{
    int level;
    BinaryTreeNode node;

    public Pair(BinaryTreeNode node,int level){
        this.level= level;
        this.node= node;
    }
    }
    public static ArrayList<Integer> bottomView(BinaryTreeNode root) {
        ArrayList<Integer> res= new ArrayList<>();
		  if(root==null){
        return res;
    }
    bottomview t = new bottomview();
    
    Queue<Pair> pendingnodes= new LinkedList<>();
    pendingnodes.add(t.new Pair(root,0));
    Map<Integer,Integer> map= new TreeMap<>();
    while(!pendingnodes.isEmpty()){
        Pair front= pendingnodes.poll();
        int level= front.level;
        BinaryTreeNode node= front.node;
       // if(map.get(level)==null){
            map.put(level, node.val);
       // }
//           if(map.containsKey(level)){
//             map.remove(level);
//             map.put(level, node.val);
//         }
        if(node.left!=null){
            pendingnodes.add(t.new Pair(node.left, level-1));
        }
        if(node.right!=null){
            pendingnodes.add(t.new Pair(node.right,level+1));
        }
    }

    for(Map.Entry<Integer,Integer>entry:map.entrySet()){
        res.add(entry.getValue());
    }
    return res;
	}         
    }


    
}
