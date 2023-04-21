package LinkedLists;
//eetcode 234.
public class palindromelinkedlist {
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
    public int lengthofLL(ListNode head) {
        ListNode temp = head;
        int len = 0;
        while (temp != null) {
            temp = temp.next;
            len++;
        }
        return len;
    }

    static ListNode th = null;
    static ListNode tt = null;

    public void addFirst(ListNode curr) {
        if (th == null) {
            th = curr;
            tt = curr;
        } else {
            curr.next = th;
            th = curr;
        }
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) {
            return head;
        }
        ListNode oh = null;
        ListNode ot = null;
        ListNode curr = head;
        int len = lengthofLL(head);
        while (len >= k) {
            int tempk = k;
            while (tempk-- > 0) {
                ListNode frwd = curr.next;
                curr.next = null;
                addFirst(curr);
                curr = frwd;
            }
            if (oh == null) {
                oh = th;
                ot = tt;
            } else {
                ot.next = th;
                ot = tt;
            }
            tt = null;
            th = null;
            len -= k;

        }
        ot.next = curr;
        return oh;

    }
}
