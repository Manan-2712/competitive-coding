//https://www.pepcoding.com/resources/data-structures-and-algorithms-in-java-levelup/linked-list/segregate-even-and-odd-nodes-in-a-link-list/ojquestion
package LinkedLists;

import java.util.*;

public class segregateven_odd {

    public static class ListNode {
        int val = 0;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public static ListNode segregateEvenOdd(ListNode head) {
        ListNode evenhead = new ListNode(-1);
        ListNode oddhead = new ListNode(-1);
        ListNode oddtail = oddhead;
        ListNode eventail = evenhead;
        ListNode curr = head;
        // ListNode temp = head;

        while (curr != null) {
            if (curr.val % 2 == 0) {
                eventail.next = curr;
                eventail = eventail.next;
                curr = eventail;
            } else {
                oddtail.next = curr;
                oddtail = oddtail.next;
                curr = oddtail;
            }
            curr = curr.next;

        }
        oddtail.next = null;
        eventail.next = oddhead.next;
        return evenhead.next;
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        ListNode dummy = new ListNode(-1);
        ListNode prev = dummy;
        while (n-- > 0) {
            prev.next = new ListNode(scn.nextInt());
            prev = prev.next;
        }

        ListNode head = segregateEvenOdd(dummy.next);
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
    }
}
