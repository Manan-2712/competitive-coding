//https://www.codingninjas.com/codestudio/problems/number-of-pairs-with-given-sum_630509?leftPanelTab=2
package Arrays;
 import java.util.HashMap;
public class NumberOfPairswithgivenSum {
	public static long pairsWithGivenSum(int arr[], int sum) 
	{
    HashMap<Integer,Integer> m= new HashMap<>();
    int n = arr.length;
    long  count = 0L;
    int result []= new int[2];

    for (int i = 0; i < n; i++) {
        if (m.containsKey(sum - arr[i])) {
            count += m.get(sum - arr[i]);
        }
        if(m.containsKey(arr[i])){
            m.put(arr[i], m.get(arr[i])+1);
        }
        else{
            m.put(arr[i], 1);
        }
    }
    return count;
   
}
}


