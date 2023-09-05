import java.util.*;
//https://www.codingninjas.com/studio/problems/minimum-number-of-swaps-required-to-sort-an-array_973251?leftPanelTab=0
public class minnumberofswaps {
    public static int findindex(int[] arr, int elem) {
        for (int i = 0; i < arr.length; i++) {
            if (elem == arr[i]) {
                return i;
            }
        }
        return -1;
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static int minSwaps(int[] arr) {
        int n = arr.length;
        int temp[] = new int[n];
        for (int i = 0; i < n; i++) {
            temp[i] = arr[i];
        }
        Arrays.sort(temp);
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] == temp[i]) {
                continue;
            } else {
                count += 1;
                int index = findindex(arr, temp[i]);
                swap(arr, i, index);
            }
        }
        return count;
    }
}


