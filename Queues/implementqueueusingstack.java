package Queues;
import java.util.*;

public class implementqueueusingstack {
    static class Queue {
        // Define the data members(if any) here.
        // Initialize your data structure here.
        Stack<Integer> input = new Stack<>();
        Stack<Integer> output = new Stack<>();

        Queue() {

        }

        void enQueue(int val) {
            // Implement the enqueue() function.
            if (input.isEmpty()) {
                input.push(val);
            } else {
                while (!input.isEmpty()) {
                    output.add(input.peek());
                    input.pop();
                }
                input.add(val);
                while (!output.isEmpty()) {
                    input.add(output.peek());
                    output.pop();
                }
            }
        }

        int deQueue() {
            if (input.isEmpty()) {
                return -1;
            }
            int val = input.peek();
            input.pop();
            return val;
        }

        int peek() {
            if (input.isEmpty()) {
                return -1;
            }
            return input.peek();

        }

        boolean isEmpty() {
            if (input.isEmpty()) {
                return true;
            }
            return false;
        }
    }
}
