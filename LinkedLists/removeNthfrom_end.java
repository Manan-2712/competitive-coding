package LinkedLists;

public class removeNthfrom_end {
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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // if (n ==0 || head == null){
        // return head;
        // }
        // int len=0;
        // ListNode temp = head;
        // while(temp!= null){
        // temp = temp.next;
        // len ++;
        // }
        // int ntor = len - n;
        // if(ntor == 0){
        // return head.next;
        // }
        // ListNode temp1= head;
        // int i=1;
        // while(i < ntor ){
        // temp1 = temp1.next;
        // i++;
        // }
        // temp1.next = temp1.next.next;

        // return head;

        // APPROACH 2 WITHOUT CALCULATING LENGTH
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode slow = dummy;
        ListNode fast = dummy;
        for (int i = 1; i <= n; i++) {
            fast = fast.next;
        }
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return dummy.next;
    }
}
