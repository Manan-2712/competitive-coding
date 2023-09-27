package LinkedLists;

import java.util.*;

public class removeduplicatefromsorted {
    // Function to remove duplicates from sorted linked list.
    Node removeDuplicates(Node head) {
        Node curr = head;
        while (curr != null) {
            if ((curr.next != null) && (curr.data == curr.next.data)) {
                curr.next = curr.next.next;
            } else {
                curr = curr.next;
            }
        }
        return head;
    }
}
