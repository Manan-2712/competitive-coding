package CODECHEF;
//https://www.codechef.com/submit-old/MINLCS
import java.util.*;

public class minimumlcs {
    /* Name of the class has to be "Main" only if the class is public. */
    public static void main(String[] args) throws java.lang.Exception {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            String a = sc.next();
            String b = sc.next();
            // char arr[]= a.toCharArray();
            // char ary[]= b.toCharArray();
            int ans = 0;
            Map<Character, Integer> map1 = new HashMap<>();
            Map<Character, Integer> map2 = new HashMap<>();
            for (int i = 0; i < a.length(); i++) {
                char chr1 = a.charAt(i);
                char chr2 = b.charAt(i);
                if (map1.containsKey(chr1)) {
                    map1.put(chr1, map1.get(chr1) + 1);
                } else {
                    map1.put(chr1, 1);
                }
                if (map2.containsKey(chr2)) {
                    map2.put(chr2, map2.get(chr2) + 1);
                } else {
                    map2.put(chr2, 1);
                }
            }
            int x = 0;
            int y = 0;
            int min;
            // int ans =0;
            for (int i = 0; i < a.length(); i++) {
                char ch1 = a.charAt(i);
                char ch2 = b.charAt(i);
                x = map1.get(ch1);
                if (map2.containsKey(ch1)) {
                    y = map2.get(ch1);
                } else {
                    y = 0;
                }

                if (x > y) {
                    min = y;
                } else {
                    min = x;
                }
                if (ans < min) {
                    ans = min;
                }

            }

            System.out.println(ans);

        }
    }
}
