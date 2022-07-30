package coursera.week4_divideandconquer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// In this problem  if there are duplicates we have to output
// the first occurence of that number 
// for example .
/*Input:
7
2 4 4 4 7 7 9
4
9 4 5 2

Your output: // output with simple binary search algorithm. 
6 3 -1 0 
Correct output:
6 1 -1 0*/ // output with binary search algorithm duplicates.

public class binarysearchduplicates {
    public static int binaryhelper(int arr[], int low, int high, int key) {
        if (low > high) {
            return -1;
        }
        int mid = low + (high - low) / 2;
        if (arr[mid] == key) {
            return mid;

        } else if (key < arr[mid]) {
            return binaryhelper(arr, low, mid - 1, key);
        } else {
            return binaryhelper(arr, mid + 1, high, key);
        }

    }

    public static int binary(int arr[], int key) {
        return binaryhelper(arr, 0, arr.length - 1, key);
    }

    public static int binaryduplicates(int arr[], int key) {
        int index = binary(arr, key);
        int firstindex = index;
        for (int i = index; i >= 0; i--) {
            if (arr[i] == key && i < index) {
                firstindex = i;
            }
        }
        return firstindex;
    }

    static int linearSearch(int[] a, int x) {
        for (int i = 0; i < a.length; i++) {
            if (a[i] == x)
                return i;
        }
        return -1;
    }

    public static void main(String[] args) {
        FastScanner scanner = new FastScanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        int m = scanner.nextInt();
        int[] b = new int[m];
        for (int i = 0; i < m; i++) {
            b[i] = scanner.nextInt();
        }
        for (int i = 0; i < m; i++) {
            // replace with the call to binarySearch when implemented
            System.out.print(binaryduplicates(a, b[i]) + " ");
            // System.out.print(binary(a,b[i])+" ");
        }
    }

    static class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        FastScanner(InputStream stream) {
            try {
                br = new BufferedReader(new InputStreamReader(stream));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        String next() {
            while (st == null || !st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }
    }
}
