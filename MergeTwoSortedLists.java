//https://leetcode.com/problems/merge-two-sorted-lists/
// Definition for singly-linked list.
// class ListNode {
//     int val;
//     ListNode next;

//     ListNode() {
//     }

//     ListNode(int val) {
//         this.val = val;
//     }

//     ListNode(int val, ListNode next) {
//         this.val = val;
//         this.next = next;
//     }
// }

class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode p1 = l1;
        ListNode p2 = l2;
        ListNode head3;
        ListNode tail3;
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        if (p1.val < p2.val) {
            head3 = p1;
            tail3 = p1;
            p1 = p1.next;
        }

        else {
            head3 = p2;
            tail3 = p2;
            p2 = p2.next;
        }
        while (p1 != null && p2 != null) {
            if (p1.val < p2.val) {
                tail3.next = p1;
                tail3 = tail3.next;
                p1 = p1.next;
            } else {
                tail3.next = p2;
                tail3 = tail3.next;
                p2 = p2.next;
            }
        }
        while (p1 != null) {
            tail3.next = p1;
            tail3 = tail3.next;
            p1 = p1.next;

        }
        while (p2 != null) {
            tail3.next = p2;
            tail3 = tail3.next;
            p2 = p2.next;

        }
        return head3;
    }
}
