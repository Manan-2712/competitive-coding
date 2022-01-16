package codeproblems;
//https://www.codingninjas.com/codestudio/problems/intersection-of-2-arrays_1082149?leftPanelTab=1
import java.util.HashMap;
import java.util.ArrayList;

public class Intersectionoftwoarrays {
    public static ArrayList<Integer> findArrayIntersection(ArrayList<Integer> arr1, int n, ArrayList<Integer> arr2,
            int m) {
        ArrayList<Integer> list = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int e : arr1) {
            map.put(e, map.getOrDefault(e, 0) + 1);
        }
        for (int f : arr2) {
            int ispresent = map.getOrDefault(f, 0);
            if (ispresent > 0) {
                list.add((f));

                map.put(f, ispresent - 1);
            }

        }
        return list;

    }
}
