package coursera.week4_divideandconquer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Random;
import java.util.StringTokenizer;

public class improvingquicksort {
    public static void swap(int arr[], int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static int[] partition3(int arr[], int low, int high) {
        // int i=low;
        int lowerindex = low;
        int higherindex = high;
        int pivot = arr[low];
        int i = low + 1;
        while (i <= higherindex) {
            if (arr[i] < pivot) {
                swap(arr, lowerindex++, i++);
                // lowerindex++;
                // i++;
            } else if (arr[i] > pivot) {
                swap(arr, i, higherindex--);

            } else {
                i++;
            }
        }
        // for(int i=low+1 ;i<=higherindex;i++){
        // if(arr[i]<pivot){
        // // lowerindex++;
        // swap(arr, lowerindex, i);
        // lowerindex++;
        // }
        // else if(arr[i]>pivot){
        // // higherindex--;
        // swap(arr, i, higherindex);
        // higherindex--;
        // }
        // else {
        // continue;
        // }
        // }
        return new int[] { lowerindex, higherindex };
    }
    // public static void partition2(int arr[],int low ,int high){

    // }

    public static void randomized(int arr[], int low, int high) {
        if (low >= high) {
            return;
        }
        Random rand = new Random();
        int k = rand.nextInt(high - low + 1) + low;
        swap(arr, low, k);
        int[] index = partition3(arr, low, high);
        randomized(arr, low, index[0] - 1);
        randomized(arr, index[1] + 1, high);
    }

    public static void main(String[] args) {
        FastScanner scanner = new FastScanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        randomized(a, 0, n - 1);
        for (int i = 0; i < n; i++) {
            System.out.print(a[i] + " ");
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
