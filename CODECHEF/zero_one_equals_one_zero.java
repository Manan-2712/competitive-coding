package CODECHEF;

import java.util.*;

//https://www.codechef.com/submit-v2/ZOOZ
public class zero_one_equals_one_zero {
    public static void main(String[] args) throws java.lang.Exception {

        // IN this approach we just observe that we simply maintain the count of '01'
        // and '10' is 1 i.e in binary string we have only 1-'01' and 1='10';
        // so we will put 0 at 0th index and (n-1)th last index and in all the middle
        // positions i.e (from 1 to n-2 ) put '1';
        // or vice -versa of this approach i.e(interchange '0' and '1');
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            StringBuilder sb = new StringBuilder();
            sb.append('0');
            for (int i = 1; i <= n - 2; i++) {
                sb.append('1');
            }
            sb.append('0');
            System.out.println(sb);
        }
    }
}
