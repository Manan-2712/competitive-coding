package Arrays;
import java.util.*;
public class longestsubstringwithoutrepeating {
    class Solution {
        public int lengthOfLongestSubstring(String s) {
    //         if(s.length()==0){
    //             return 0;
    //         }
    //        // Brute Force 
    //        int len =0;
    //        int n = s.length();
    //        for(int i=0;i<n;i++){
    //            HashSet<Character>set = new HashSet<>();
    //            for(int j =i;j<n;j++){
    //                if(set.contains(s.charAt(j))){
    //                    len = Math.max(len, (j-i));
    //                    break;
    //                }
    //                set.add(s.charAt(j));
    
    //            }
    //        }
    //        return len;
    //     }
    // }
    
    
    
            //OPTIMAL APPROACH 1
             //TC=O(2N) 
            // HashSet<Character> set = new HashSet<>();
            //  int len =0;
            //  int l =0;
            //  int n = s.length();
            //  for(int r=0;r<n;r++){
            //      if(set.contains(s.charAt(r))){
            //          while(l < r && set.contains(s.charAt(r))){
            //             set.remove(s.charAt(l));
            //             l++; 
            //          }
            //      }
            //      set.add(s.charAt(r));
            //      len = Math.max(len,r - l + 1);
            //  }
            //  return len;
    
    
    
             // OPTIMAL APPROACH 2
             // TC = O(N)
             Map<Character,Integer>map = new HashMap<>();
             int left =0;
             int right =0;
             int len =0;
             int n = s.length();
             while(right < n){
                 if(map.containsKey(s.charAt(right))){
                     left = Math.max(left,map.get(s.charAt(right))+1);
                 }
                map.put(s.charAt(right),right);
                len = Math.max(len , right - left + 1);
                right++;
    
             }
             return len;
        }
    }
}
