package priorityqueue;

import java.util.Collections;
import java.util.PriorityQueue;

public class medianof_streamof_integers {

    /** initialize your data structure here. */
    PriorityQueue<Integer> minheap;
    PriorityQueue<Integer> maxheap;

    public medianof_streamof_integers() {
        minheap = new PriorityQueue<>();
        maxheap = new PriorityQueue<>(Collections.reverseOrder());

    }

    public void addNum(int num) {
        if (maxheap.size() == 0 || maxheap.peek() > num) {
            maxheap.add(num);
        } else {
            minheap.add(num);
        }
        if (maxheap.size() - minheap.size() > 1) {
            int temp = maxheap.poll();
            minheap.add(temp);
        }
        if (minheap.size() - maxheap.size() > 1) {
            int temp = minheap.poll();
            maxheap.add(temp);

        }

    }

    public double findMedian() {
        if (maxheap.size() == minheap.size()) {
            return (maxheap.peek() + minheap.peek()) / 2.0;
        } else if (maxheap.size() > minheap.size()) {
            return (double) maxheap.peek();
        } else {
            return (double) minheap.peek();
        }

    }
}
