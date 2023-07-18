package Stacks;
//https://www.codingninjas.com/studio/problems/stack-implementation-using-array_3210209?utm_source=striver&utm_medium=website&utm_campaign=a_zcoursetuf&leftPanelTab=1
public class stackimplementationusing_array {
    static class Stack {
        int arr[];
        int top;

        Stack(int capacity) {
            // Write your code here.
            arr = new int[capacity];
            top = -1;
        }

        public void push(int num) {
            if (top >= arr.length - 1) {
                return;
            }
            // Write your code here.
            top++;
            arr[top] = num;
        }

        public int pop() {
            if (top == -1) {
                return -1;
            }
            int val = arr[top];
            top--;
            return val;
        }

        public int top() {
            // Write your code here.
            if (top == -1) {
                return -1;
            }
            return arr[top];
        }

        public int isEmpty() {
            if (top == -1) {
                return 1;
            }
            return 0;

        }

        public int isFull() {
            if (top == arr.length - 1) {
                return 1;
            }
            return 0;
        }
    }
}
