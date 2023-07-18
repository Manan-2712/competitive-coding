package Queues;
//https://www.codingninjas.com/studio/problems/implement-queue-using-arrays_8390825?utm_source=striver&utm_medium=website&utm_campaign=a_zcoursetuf&leftPanelTab=0
class Queue {
    int front, rear;
    int[] arr;

    Queue() {
        front = 0;
        rear = 0;
        arr = new int[3];
    }

    public class queueimplementation {

        // Enqueue (add) element 'e' at the end of the queue.
        public void enqueue(int e) {
            // Write your code here.
            arr[rear] = e;
            rear++;
        }

        // Dequeue (retrieve) the element from the front of the queue.
        public int dequeue() {
            if (front == rear) {
                return -1;
            }
            int val = arr[front];
            front++;
            return val;

        }
    }
}
