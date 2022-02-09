package LinkedLists;

// https://www.codingninjas.com/codestudio/problems/interview-shuriken-42-detect-and-remove-loop_241049?leftPanelTab=1
public class Detect_and_remove_cycle {

    public static class Node {

        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static Node removeLoop(Node head) {
        if (head == null) {
            return null;
        }
        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                break;
            }
        }
        if (fast == null) {
            return head;
        }
        slow = head;
        if (slow != fast) {
            while (slow.next != fast.next) {
                slow = slow.next;
                fast = fast.next;
            }
            fast.next = null;
        } else {
            while (fast.next != slow) {
                fast = fast.next;
            }
            fast.next = null;

        }
        return head;
    }
}
