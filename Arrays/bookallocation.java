//https://www.codingninjas.com/codestudio/problems/allocate-books_1090540


import java.util.ArrayList;

public class bookallocation {

    public static boolean ispossible(ArrayList<Integer> arr, int n, int m, int mid) {
        int studentcount = 1;
        int pagesum = 0;
        for (int i = 0; i < n; i++) {
            if (pagesum + arr.get(i) <= mid) {
                pagesum += arr.get(i);
            } else {
                studentcount++;
                if (studentcount > m || arr.get(i) > mid) {
                    return false;
                }
                pagesum = arr.get(i);
            }
        }
        return true;

    }

    public static int allocateBooks(ArrayList<Integer> arr, int n, int m) {
        int s = 0;
        int sum = 0;
        int ans = -1;
        for (int i = 0; i < n; i++) {
            sum += arr.get(i);
        }
        int e = sum;
        int mid = s + (e - s) / 2;
        while (s <= e) {
            if (ispossible(arr, n, m, mid)) {
                ans = mid;
                e = mid - 1;
            } else {
                s = mid + 1;
            }
            mid = s + (e - s) / 2;
        }
        return ans;
    }
}
