package LinkedLists;
//Leetcode 61.
public class rotate_linkedlist {
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
        public ListNode rotateRight(ListNode head, int k) {
            // OPTIMAL APPROACH
            if (head == null || head.next == null || k == 0) {
                return head;
            }
            int len = 1;
            ListNode temp = head;
            while (temp.next != null) {
                temp = temp.next;
                len++;
            }
            temp.next = head;
            k = len - (k % len);
            while (k-- > 0) {
                temp = temp.next;
            }
            head = temp.next;
            temp.next = null;
            return head;

            // BETTER APPROCH
            // if(head == null || head.next == null){
            // return head;
            // }
            // ListNode temphead = head;
            // int len =0;
            // while(temphead != null){
            // temphead= temphead.next;
            // len ++;
            // }
            // k = k%len;// if k>>>> large then it means any multiple of length will give
            // you repeated rotations i.e (original linkedlist)
            // for(int i=0;i<k;i++){
            // ListNode temp = head;
            // while(temp.next.next !=null){
            // temp = temp.next;
            // }
            // ListNode end = temp.next;
            // temp.next = null;
            // end.next =head;
            // head = end;

            // }
            // return head;
        }
    }
}
