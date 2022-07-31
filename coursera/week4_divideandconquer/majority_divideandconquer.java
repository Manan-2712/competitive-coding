package coursera.week4_divideandconquer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Random;
import java.util.StringTokenizer;

public class majority_divideandconquer {
    public static int getMajorityelement(int arr[], int low, int high) {
        if (high <= low) {
            return arr[low];
        }
        int mid = low + (high - low) / 2;
        int leftelement = getMajorityelement(arr, low, mid);
        int rightelement = getMajorityelement(arr, mid + 1, high);
        if (leftelement == rightelement) {
            return leftelement;
        }
        int leftcount = frequency(arr, leftelement, low, high);
        int rightcount = frequency(arr, rightelement, low, high);
        if (leftcount > Math.ceil(high - low + 1) / 2) {
            return leftelement;
        }
        if (rightcount > Math.ceil(high - low + 1) / 2) {
            return rightelement;
        }
        return -1;
    }

    public static int frequency(int arr[], int element, int low, int high) {

        int count = 0;
        for (int i = low; i <= high; i++) {
            if (arr[i] == element) {
                count++;
            }

        }
        return count;
    }

    public static int getMajorityElement1(int arr[], int low, int high) {
        int res = getMajorityelement(arr, 0, arr.length - 1);
        return res;
    }

    public static int getMajorityElement2(int arr[], int left, int right) {

        int val = arr[0];
        int count = 1;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] == val) {
                count++;
            } else {
                count--;
            }
            if (count == 0) {
                val = arr[i];
                count = 1;
            }
        }
        return val;

    }

    public static int majority(int arr[], int left, int right) {
        int res = getMajorityElement2(arr, 0, arr.length - 1);
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == res) {
                count++;
            }
        }
        if (count > arr.length / 2) { // check for majority
            return 1;
        } else {
            return -1;
        }
    }

    public static void main(String[] args) {
        // int arr[]= {1,2,3,5,5,5,5,5,6};
        /*
         * STRESS TESTING
         * /* Random random = new Random();
         * int limit = random.nextInt(10000);
         * int arr[] = new int[limit];
         * for (int i = 0; i < arr.length; i++) {
         * arr[i] = random.nextInt(Integer.MAX_VALUE);
         * }
         * int res1 = getMajorityElement1(arr, 0, arr.length);
         * int res2 = majority(arr, 0, arr.length);
         * if (res1 != res2) {
         * System.out.println("wrong answer" + res1 + " " + res2);
         * } else {
         * System.out.println("ok");
         * }
         */

        // System.out.println(res2);

        FastScanner scanner = new FastScanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        if (majority(a, 0, a.length) != -1) {
            System.out.println(1);
        } else {
            System.out.println(0);
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
