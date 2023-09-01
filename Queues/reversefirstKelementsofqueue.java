package Queues;

import java.util.*;
import java.util.Queue;

//https://www.codingninjas.com/studio/problems/reverse-the-first-k-elements-of-a-queue_1164269?leftPanelTab=0
public class reversefirstKelementsofqueue {
    Queue<Integer> queue = new LinkedList<>();

    public static void reverse(Queue<Integer> queue, int k) {
        Stack<Integer> st = new Stack<Integer>();
        Stack<Integer> stack = new Stack<Integer>();
        int n = queue.size();
        for (int i = 0; i < k; i++) {
            st.add(queue.peek());
            queue.remove();
        }
        while (!st.isEmpty()) {
            queue.add(st.peek());
            st.pop();
        }
        int len = n - k;
        while (len > 0) {
            int temp = queue.remove();
            queue.add(temp);
            len--;
        }

    }

}
