package CODECHEF;
import java.util.*;
import java.lang.*;
import java.io.*;


public class Fruitchaatproblem { 

    public static int chaat(int b,int a){
    if( b == 2){
      return 1;
    }
    if(a==1){
      return 1;
    }
   // int count=0;
    b=b/2;
   // a=a/1;
   if(b< a){
     return b;
   }
   else{
    return a;
   }

}
	public static void main (String[] args) throws java.lang.Exception
	{
		Scanner sc = new Scanner(System.in);
		int t= sc.nextInt();
		while(t-- > 0){
		    int  b= sc.nextInt();
		    int a = sc.nextInt();
		    System.out.println(chaat(b,a));
		}
	}
}
}
