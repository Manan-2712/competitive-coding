package LinkedLists;
//https://www.codingninjas.com/codestudio/problems/reverse-list-in-k-groups_983644#:~:text=1.,2.

class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class reverseinKgroups {

    public static Node kReverse(Node head, int k) {
        if (head == null) {
            return null;
        }
        Node next = null;
        Node prev = null;
        Node curr = head;
        int count = 0;
        while (curr != null && count < k) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
            count++;
        }
        if (next != null) {
            head.next = kReverse(next, k);
        }
        return prev;

    }
}
