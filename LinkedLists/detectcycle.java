package LinkedLists;
//Leetcode = 141
import java.util.*;

public class detectcycle {
    /**
     * Definition for singly-linked list.
     * class ListNode {
     * int val;
     * ListNode next;
     * ListNode(int x) {
     * val = x;
     * next = null;
     * }
     * }
     */
    public boolean hasCycle(ListNode head) {
        // OPTIMAL APPROACH USING FLOYYD DETECTION METHOD
        if (head == null) {
            return false;
        }
        // ListNode slow = head;
        // ListNode fast = head;
        // while(fast.next!=null && fast.next.next != null){
        // slow = slow.next;
        // fast = fast.next.next;
        // if(slow == fast){
        // return true;
        // }
        // }

        // BETTER APPROACH
        HashSet<ListNode> set = new HashSet<>();
        ListNode temp = head;
        while (temp != null) {
            if (set.contains(temp)) {
                return true;
            }
            set.add(temp);
            temp = temp.next;
        }
        return false;
    }
}
