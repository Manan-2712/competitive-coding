package CODECHEF;

//https://www.codechef.com/LTIME109D/problems/FLOORS.
// MY SUBMISSION 
//https://www.codechef.com/viewsolution/67139868
import java.util.Scanner;

// APPROACH 
/*  In this approach we are calculating the floor number from room number as we are provided with 
    ith floor will have room numbers from 10(i-1)+1 to 10.i;
    calculate the floor number from room number 
    10(i-1)+1 = room number.
    10i-10+1= room number.
    10i-9= room number.
    10i= room number + 9.
     i(floor number)= (room number +9)/10.     
*/
public class toomanyfloors {
    public static void main(String[] args) throws java.lang.Exception {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            int res1 = (x + 9) / 10;
            int res2 = (y + 9) / 10;
            int finalres = Math.abs(res1 - res2);
            System.out.println(finalres);
        }
    }

}
