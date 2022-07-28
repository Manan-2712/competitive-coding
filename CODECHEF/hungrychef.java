//https://www.codechef.com/JULY222D/problems/BURGERS2?tab=submissions
// For thinking (logic)
//https://www.youtube.com/watch?v=np895NkR7ho
import java.util.*;
import java.lang.*;
import java.io.*;

public class hungrychef {

    public static void main(String[] args) throws java.lang.Exception {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            int n = sc.nextInt();
            int r = sc.nextInt();
            if (r < n * x) {
                System.out.println(-1);
            } else {
                int b = (int) (r - n * x) / (y - x);
                int finalb = Math.min(n, b);
                int a = n - finalb;
                System.out.println(a + " " + finalb);

            }
        }
    }
}
