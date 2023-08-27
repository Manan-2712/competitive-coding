package maths;
//https://www.codingninjas.com/studio/problems/find-two-missing-numbers_1214700?leftPanelTab=0
import java.util.*;
import java.io.*;

public class twomissingpositive {

    public static ArrayList<Integer> findMissingNumbers(ArrayList<Integer> arr, int n) {
        // BRUTE FORCE
        // Map<Integer,Integer> map = new HashMap<>();
        // for(int i=1;i<=n;i++){
        // map.put(i,1);
        // }
        // int len = arr.size();
        // for(int i=0;i<len;i++){
        // map.put(arr.get(i),map.getOrDefault(arr.get(i), 0)+1);
        // }
        // ArrayList<Integer> ans = new ArrayList<>();
        // for(Map.Entry<Integer,Integer> entry:map.entrySet()){
        // if(map.get(entry.getKey()) == 1){
        // ans.add(entry.getKey());
        // }
        // }
        // return ans;

        // OPTIMISED APPROACH using bit manipulation
        int xor = 0;
        int size = arr.size();
        for (int i = 0; i < size; i++) {
            xor ^= arr.get(i);
        }
        for (int i = 1; i <= n; i++) {
            xor ^= i;
        }
        int rsbm = xor & -xor;
        int x = 0;
        int y = 0;
        for (int i = 0; i < size; i++) {
            if ((rsbm & arr.get(i)) == 0) {
                x ^= arr.get(i);
            } else {
                y ^= arr.get(i);
            }
        }
        for (int i = 1; i <= n; i++) {
            if ((rsbm & i) == 0) {
                x ^= i;
            } else {
                y ^= i;
            }
        }
        ArrayList<Integer> ans = new ArrayList<>();
        ans.add(x);
        ans.add(y);
        Collections.sort(ans);
        return ans;

    }
}
