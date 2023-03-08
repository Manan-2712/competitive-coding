package LinkedLists;
import java.util.* ;
import java.io.*; 
public class selectionsort_list {
 
/****************************************************************

       Following is the class structure of the Node class:

       class Node {
	int data;
	Node next;

	Node(int data) {
		this.data = data;
		this.next = null;
	}
}

*****************************************************************/

	public static Node sortLL(Node head) {
	   Node temp = head;
	   while(temp!= null){
		   Node min = temp;
		   Node r = temp.next;
		   while(r!= null){
			   if(min.data > r.data){
				   min = r;
			   }
			   r= r.next;
		   }
		   int x = temp.data;
		   temp.data= min.data;
		   min.data= x;
		   temp= temp.next;

	   }
	   return head;
	}
}



