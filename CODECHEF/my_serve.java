package CODECHEF;

import java.util.Scanner;

//https://www.codechef.com/submit-v2/MYSERVE
public class my_serve {
    public static void main(String[] args) {

        // FIRST APPROACH
        // Time complexity = O(1);
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int p = sc.nextInt(); // IN THIS QUESTION WE HAVE TO OBSERVE THE PATTERN FROM PROBLEM DESCRIPTION AND
                                  // ANALYSE THE GIVEN TEST CASES
                                  // ALICE WILL SERVE WHEN - 1,2,5,6,9,10 ----so on
                                  // when we modulo alice serves(%4) remainder is 1 or 2;
            int q = sc.nextInt(); // Bob WILL SERVE WHEN - 3,4,8,11,12----SO ON
                                  /// when we modulo bob serves(%4) remainder is 0 or 3;
            int x = p + q;
            int res = x + 1; // for next serve is asked in question that is why (+1);
            if (res % 4 == 1 || res % 4 == 2) { // for alice ;
                System.out.println("alice");
            } else {
                System.out.println("bob");// for bob;
            }
        }

        // SECOND APPROACH
        // TIME complexity=O(1);
        /*
         * In this approch we are going to check how many serves have already been made
         * if they are odd next serve is of bob else of alice;
         */
        while (t-- > 0) {
            int p = sc.nextInt();
            int q = sc.nextInt();
            int sum = p + q;
            if (sum % 2 == 1) { // first check if sum is odd subtract 1 from it and
                sum--; // then divide it by 2 ,for getting how many serves
            } // have already been made by bob and alice each .
            sum /= 2;
            if (sum % 2 == 1) {
                System.out.println("bob");
            } else {
                System.out.println("alice");
            }

        }

    }
}
