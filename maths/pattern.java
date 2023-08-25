package maths;
//https://www.codingninjas.com/studio/problems/number-pattern_624932?leftPanelTab=0
import java.util.Scanner;

public class pattern {

    public static void main(String[] args) {

        /*
         * Your class should be named Solution.
         * Read input as specified in the question.
         * Print output as specified in the question.
         */
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 1; i <= n; i++) {
            int k = i;
            for (int j = 1; j <= i; j++) {
                System.out.print(k);
                k++;
            }

            System.out.println();
        }

    }

}
