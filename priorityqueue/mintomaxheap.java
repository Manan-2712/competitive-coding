package priorityqueue;

//https://www.codingninjas.com/codestudio/problems/convert-min-heap-to-max-heap_630293?leftPanelTab=1
public class mintomaxheap {

    public static void minHeapToMaxHeap(long[] arr) {
        int n = arr.length;
        for (int i = n / 2; i >= 0; i--) {
            helper(arr, i, n);
        }
    }

    public static void helper(long[] arr, int i, int n) {
        // int n = arr.length;
        // int index = i;
        int maxindex = i;
        int leftchildindex = 2 * i + 1;
        int rightchildindex = 2 * i + 2;

        if (leftchildindex < n && arr[leftchildindex] > arr[maxindex]) {
            maxindex = leftchildindex;
        }
        if (rightchildindex < n && arr[rightchildindex] > arr[maxindex]) {
            maxindex = rightchildindex;
        }
        if (maxindex != i) {
            long temp = arr[i];
            arr[i] = arr[maxindex];
            arr[maxindex] = temp;

            helper(arr, maxindex, n);
        }
    }
}
