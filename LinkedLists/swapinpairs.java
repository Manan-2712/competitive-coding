package LinkedLists;

//https://leetcode.com/problems/swap-nodes-in-pairs/description/
public class swapinpairs {
    public ListNode helper(ListNode head, int k) {
        // int k = 2;
        int count = 0;
        ListNode temp = null;
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null && count < k) {
            temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
            count++;
        }
        if (temp != null) {
            head.next = helper(temp, k);
        }

        return prev;

    }

    public ListNode swapPairs(ListNode head) {
        ListNode newhead = helper(head, 2);
        return newhead;

    }
}
