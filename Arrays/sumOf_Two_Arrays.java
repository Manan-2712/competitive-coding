// https://www.codingninjas.com/codestudio/problems/sum-of-two-arrays_893186

package Arrays;

import java.util.ArrayList;

public class sumOf_Two_Arrays {

    public static int[] reverse(int arr[]) {
        int n = arr.length;
        for (int i = 0; i < arr.length / 2; i++) {
            int temp = arr[i];
            arr[i] = arr[(n - i) - 1];
            arr[(n - i) - 1] = temp;
        }
        return arr;
    }

    public static int[] findArraySum(int[] a, int n, int[] b, int m) {
        // int sum=0;
        // n= a.length;
        // m= b.length;
        int i = n - 1;
        int j = m - 1;
        int carry = 0;
        int sum1 = n > m ? n : m;
        ArrayList<Integer> ans = new ArrayList<>();
        while (i >= 0 && j >= 0) {
            int sum = a[i] + b[j] + carry;
            sum = sum % 10;
            carry = sum / 10;
            ans.add(sum);
            i--;
            j--;
        }
        while (i >= 0) {
            int sum = a[i] + carry;
            // sum= sum%10;
            carry = sum / 10;
            sum = sum % 10;
            ans.add(sum);
            i--;
        }
        while (j >= 0) {
            int sum = b[j] + carry;
            carry = sum / 10;
            sum = sum % 10;
            ans.add(sum);
            j--;
        }
        while (carry != 0) {
            int sum = carry;
            sum = sum % 10;
            carry = sum / 10;
            // sum= sum%10;
            ans.add(sum);

        }
        int result[] = new int[ans.size()];
        for (int k = 0; k < ans.size(); k++) {
            result[k] = ans.get(k);
        }
        return reverse(result);

    }
}
