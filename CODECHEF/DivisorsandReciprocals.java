package CODECHEF;
import java.util.*;
import java.lang.*;
import java.io.*;
public class DivisorsandReciprocals {
   public static long  divisorssum(long n){
   long sum=0;
   for(int i=1;i*i<=n;i++){
     if(n%i == 0){
       sum+=i;
     if(n/i != i){
       sum+=n/i;
     }
    }
   }
   return sum;

}
    
	public static void main (String[] args) throws java.lang.Exception
	{
	Scanner sc = new Scanner(System.in);
    int t = sc.nextInt();
    while(t-- >0){
    long X = sc.nextLong();
    long A = sc.nextLong();
    long B = sc.nextLong();

   if((X*B) % A != 0 || A<B){
     System.out.println(-1);
   }
   else{
     long n= (X*B) / A;
     long divsum = divisorssum(n);
     if(divsum==X){
       System.out.println(n);
     }
     else{
       System.out.println(-1);
     }

   }
 }
	}
}
