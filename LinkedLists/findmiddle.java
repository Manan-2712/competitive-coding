package LinkedLists;
//https://leetcode.com/problems/middle-of-the-linked-list/description/
public class findmiddle {
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode() {}
     * ListNode(int val) { this.val = val; }
     * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */
    class Solution {
        public ListNode middleNode(ListNode head) {
            // BRUTE FORCE
            // int len =0;
            // ListNode temp = head;
            // while(temp != null){
            // temp = temp.next;
            // len++;
            // }
            // int mid = len / 2 ;
            // int start = len - mid;
            // ListNode temp1= head;
            // int i=1;
            // while(i != mid+1){
            // temp1= temp1.next;
            // i++;
            // }
            // return temp1;

            // OPTIMAL APPROACH
            ListNode slow = head;
            ListNode fast = head;
            while (fast != null && fast.next != null) {
                slow = slow.next;
                fast = fast.next.next;
            }
            return slow;
        }
    }
}
