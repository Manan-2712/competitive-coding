//https://www.youtube.com/watch?v=Ix72CukILW4
package CODECHEF;
import java.util.*;
import java.lang.*;
import java.io.*;
public class maxedges {
    /* package codechef; // don't place package name! */



/* Name of the class has to be "Main" only if the class is public. */

	public static void main (String[] args) throws java.lang.Exception
	{
		Scanner sc= new Scanner(System.in);
		int t= sc.nextInt();
		while(t-- > 0){
		    long n = sc.nextLong();
		    long k = sc.nextLong();
		    long l = sc.nextLong();
		    n-=l+k;
		    if(n<0){
		        
		            n = Math.abs(n);
		            l=l-n;
		            k=k-n;
		            n=0;
		            
		        
		    }
		    long ans = k*(n+l)+(n*l)+(n*(n-1))/2;
		    System.out.println(ans);
		}
	}
}

