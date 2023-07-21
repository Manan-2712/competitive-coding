package LinkedLists;

class Node<T> {
    T data;
    Node<T>  next;

    Node(T data) {
        this.data = data;
        this.next = null;
    }

}

public class mergesortlinkedlist {
    public static Node<Integer> getmid(Node<Integer> head) {
        Node<Integer> fast = head;
        Node<Integer> slow = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public static Node<Integer> mergesort(Node<Integer> head) {
        // if(head==tail
        // ){
        // return head;
        // }
        // if(head.next==tail){
        // return head;
        // }
        // Node<Integer>mid=getmid(head, tail);
        // Node<Integer>part1=mergesort(head, mid);
        // Node<Integer>part2=mergesort(mid.next, tail);
        // Node<Integer>part3=mergelist(part1,part2);
        // return part3;
        if (head == null)
            return head;
        if (head.next == null)
            return head;
        Node<Integer> midNode = getmid(head);
        Node<Integer> h2 = midNode.next;
        midNode.next = null;
        Node<Integer> part1 = mergesort(head);
        Node<Integer> part2 = mergesort(h2);
        Node<Integer> mergedList = mergelist(part1, part2);
        return mergedList;

    }

    public static Node<Integer> mergelist(Node<Integer> head, Node<Integer> head1) {
        Node<Integer> p1 = head;
        Node<Integer> p2 = head1;
        // Node<Integer>newnode=new Node<Integer>(-1);
        // Node<Integer>p3=newnode;
        Node<Integer> head3;
        Node<Integer> tail3;
        if (p1.data < p2.data) {
            head3 = p1;
            tail3 = p1;
            p1 = p1.next;
        } else {
            head3 = p2;
            tail3 = p2;
            p2 = p2.next;

        }
        while (p1 != null && p2 != null) {
            if (p1.data < p2.data) {
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
