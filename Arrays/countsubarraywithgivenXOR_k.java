import java.io.*;
import java.util.* ;
//https://www.codingninjas.com/codestudio/problems/1115652?topList=striver-sde-sheet-problems&utm_source=striver&utm_medium=website&leftPanelTab=1
import java.util.ArrayList;
public class countsubarraywithgivenXOR_k {


public static int subarraysXor(ArrayList<Integer> arr, int x) {
		// NAIVE APPROACH 
            // int xor=0;
			// int len =0;
			// int n = arr.size();
			// for(int i=0;i<n;i++){
			// 	xor=0;
			// 	for(int j=i;j<n;j++){
			// 		xor^=arr.get(j);
			// 		if(xor == x){
			// 			len++;
			// 		}
			// 	}
			// }
			// return len;





     // OPTIMAL APPROACH 

	 HashMap<Integer,Integer> map = new HashMap<>();
	 int xor=0;
	 int count =0;
	 int n = arr.size();
	 for(int i=0;i<n;i++){
		 xor ^= arr.get(i);
		 if(xor == x){
			 count++;
		 }
		 if(map.containsKey(xor ^ x)){
			 count+=map.get(xor ^ x);
		 }
		 if(map.containsKey(xor)){
			 map.put(xor,map.get(xor)+1);
		 }
		 else{
			 map.put(xor,1);
		 }
	 }

return count;


	}
}

