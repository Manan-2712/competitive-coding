//https://www.codingninjas.com/codestudio/problems/odd-and-even-positioned-linked-list-nodes_1229404
package LinkedLists;
import java.util.* ;
import java.io.*; 
public class evenandoddposition {

/****************************************************************

    Following is the class structure of the Node class:

	class Node {
	    public int value;
	    public Node next;

	    Node(int value) {
	        this.value = value;
	        this.next = null;
	    }
	}

*****************************************************************/

	public static Node oddEvenLinkedList(Node head) {
		if(head == null || head.next == null){
			return head;
		}
		Node oddNode =  head;
		Node evenNode = head.next;
		Node evenhead = evenNode;
		Node currnode = evenhead.next;

		int len =1;
		while(currnode!=null){
             if(len%2!=0){
				 oddNode.next = currnode;
				 oddNode = currnode;
			 }
			 else{
				 evenNode.next= currnode;
				 evenNode = currnode;
			 }
			 len ++;
			 currnode = currnode.next;
		}
		evenNode.next= null;
		oddNode.next = evenhead;
         return head;
	}
}
}
