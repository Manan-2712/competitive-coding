//https://www.codechef.com/JUNE222D/problems/REVSORT
package CODECHEF;
import java.util.*;
public class reversalsort {
    public static void swap(int arr[],int x,int y){
          int temp = arr[x];
          arr[x]= arr[y];
          arr[y]= temp;
    }
    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0){
            int n = sc.nextInt();
            int x= sc.nextInt();
            int arr[]= new int[n];
            for(int i=0;i<n;i++){
                arr[i]= sc.nextInt();
            }
            boolean flag = true;
            for(int i=0;i<n-1;i++){
                if(arr[i]>arr[i+1]){
                    if(arr[i]+arr[i+1]<=x){
                     swap(arr, i, i+1);
                    }
                    else{
                        flag = false;
                        break;
                    }
                }
            }
            if(flag ==false){
                System.out.println("No");
            }
            else{
                System.out.println("yes");
            }

        }

    }
}

}
