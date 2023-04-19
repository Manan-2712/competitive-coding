package LinkedLists;
//https://leetcode.com/problems/delete-node-in-a-linked-list/description/
public class deletenodeinlinkedlist {
    /**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public void deleteNode(ListNode node) {
        // simply copy the value of next node.
        node.val = node.next.val;
        // and node next will be node.next.next;
        node.next = node.next.next;
        
    }
}
}
