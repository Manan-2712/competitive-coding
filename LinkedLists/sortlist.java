//https://leetcode.com/problems/sort-list/

package LinkedLists;

//Definition for singly-linked list.
class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

public class sortlist {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }

        ListNode dummy = new ListNode();
        ListNode prev = dummy;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                prev.next = l1;
                l1 = l1.next;
            } else {
                prev.next = l2;
                l2 = l2.next;
            }

            prev = prev.next;
        }
        prev.next = l1 != null ? l1 : l2;

        return dummy.next;
    }

    public ListNode midnode(ListNode head) {

        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {

            fast = fast.next.next;
            slow = slow.next;
        }

        return slow;
    }

    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode midhead = midnode(head);
        ListNode newhead = midhead.next;
        midhead.next = null;
        ListNode l1 = sortList(head);
        ListNode l2 = sortList(newhead);
        return mergeTwoLists(l1, l2);

    }
}
