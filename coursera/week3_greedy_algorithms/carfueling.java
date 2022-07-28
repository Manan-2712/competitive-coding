package coursera.week3_greedy_algorithms;

import java.util.Scanner;
//PROBLEM STATEMENT
/*Suppose a person is making a travel plan driving from city 1 to city n, where n>1. Following a route that will go
*through cities 2 through n-1 in between. The person knows the mileages between two adjacent cities and knows how
*many miles a full tank of gasoline can travel. Based on this information, the problem is to minimize the number of
*many miles a full tank of gasoline can travel. Based on this information, the problem is to minimize the number of 
stops for filling up the gas tank, assuming there is exactly one gas station in each of the cities.*/

//ALGORITHM USED:

/*find_gas_stops(): current position = start position; while (current position < end position) compute the position 
at which car will run out of gas.
 if (that position < end position) then find closest gas station before reaching that position. 
 output fill up gas at that gas station. 
current position = that gas station location else current position = end position;  reached */

//EXPLANATION
/*nput: A car which can travel at most L kms with full tank, a source point A, a destination point B and n gas station 
at distances x1, x2, x3.. xn in kms from A along the path from A to B.
Output: The minimum number of refills to get from A to B, besides refill at A. 
This program has loop nested within another loop. So it seems to have O(n*n) run-time.
But, the run time of the program is O(n) as • 
CurrentRefills can be at most n+1(one-by-one) • numRefills can be at most n(one-by-one) • So, there will be at most n+1 operations • O(n+1) => O(n)*/

public class carfueling {
    public static int minrefills(int distance, int tank, int[] stops) {
        int numrefills = 0;
        int currentrefills = 0;
        int lastrefill = 0;
        int n = stops.length - 2;
        System.out.println("valule of n " + n);
        System.out.println();
        while (currentrefills <= n) {
            lastrefill = currentrefills;
            System.out.println("value of outercurrentrefills " + currentrefills);
            System.out.println();
            System.out.println("value of outerlastrefills " + lastrefill);
            while (currentrefills <= n && ((stops[currentrefills + 1] - stops[lastrefill]) <= tank)) {
                currentrefills = currentrefills + 1;
                System.out.println("value of innercurrentrefill " + currentrefills);

            }

            if (currentrefills == lastrefill) {
                return -1;
            }
            if (currentrefills <= n) {
                numrefills = numrefills + 1;
                System.out.println("value of numrefills " + numrefills);
                System.out.println();
            }

        }
        return numrefills;

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int distance = sc.nextInt();
        int tank = sc.nextInt();
        int n = sc.nextInt();
        /*
         * we have to make array of size(n)+2 because
         * int stops[]= new int[n+2];
         * 0th index will represent distance from currentposition to source
         * distance between current position and source is 0;rest all values at indices
         * will represent
         * distance between gas station and source except last index value i.e (n+1)
         * which will represent
         * the destination value
         */
        int stops[] = new int[n + 2];
        stops[0] = 0;
        stops[n + 1] = distance;
        for (int i = 1; i <= n; i++) {
            stops[i] = sc.nextInt();
        }
        System.out.println(minrefills(distance, tank, stops));
    }
}
