package BINARYTREES.traversals;
import java.util.*;
//https://practice.geeksforgeeks.org/problems/postorder-traversal-iterative/1
class Node{
    int data;
    Node left;
    Node right;
    Node(int data){
        this.data = data;
        left=null;
        right=null;
    }
}
public class iterativepostorder {
  
    
    class Tree {
        ArrayList<Integer> postOrder(Node node) {
        ArrayList<Integer> postorder = new ArrayList<>();
        Stack<Node> st = new Stack<>();
          Node curr = node;
          while(curr != null || !st.isEmpty()){
              if(curr != null){
                 st.push(curr);
                 curr = curr.left;
              }
              else{
                  Node temp = st.peek().right;
                  if(temp == null){
                      temp = st.peek();
                      st.pop();
                      postorder.add(temp.data);
                      while(!st.isEmpty() && temp == st.peek().right){
                          temp = st.peek();
                          st.pop();
                          postorder.add(temp.data);
                      }
                  }
                  else{
                      curr = temp;
                  }
              }
          }
          return postorder;
        }
    }
}
