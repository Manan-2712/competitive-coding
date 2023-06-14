package hashmaps;
//https://www.codingninjas.com/codestudio/problems/920336?topList=striver-sde-sheet-problems&utm_source=striver&utm_medium=website&leftPanelTab=0
import java.util.*;
import java.util.ArrayList;

public class countdistinct_inevery_window {

    public static ArrayList<Integer> countDistinctElements(ArrayList<Integer> arr, int k) {
        ArrayList<Integer> ans = new ArrayList<>();
        int n = arr.size();
        HashMap<Integer, Integer> map = new HashMap<>();// map where key is arr element and value is it's frequency.
        // first store k elements along with their frequencies in a map.
        for (int i = 0; i < k; i++) {
            map.put(arr.get(i), map.getOrDefault(arr.get(i), 0) + 1);
        }
        ans.add(map.size());
        // then as we move forward, if current index element is present  in map already then we have to decrease
        // it's frequency by one , as shown below two cases.
        // and if not then we just simply put that element in map along with its frequency.
        for (int i = k; i < arr.size(); i++) {
            if (map.get(arr.get(i - k)) == 1) {
                map.remove(arr.get(i - k));
            } else {
                map.put(arr.get(i - k), map.get(arr.get(i - k)) - 1);
            }
            map.put(arr.get(i), map.getOrDefault(arr.get(i), 0) + 1);
            ans.add(map.size());

        }
        return ans;

    }
}
