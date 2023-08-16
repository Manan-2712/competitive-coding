package Strings;
//https://leetcode.com/problems/longest-substring-without-repeating-characters/description/
import java.util.HashMap;
import java.util.Map;

public class longestsubstringwithoutrepetition {
    public int lengthOfLongestSubstring(String s) {
        // OPTIMISED APPROACH
        Map<Character, Integer> map = new HashMap<>();
        int n = s.length();
        int left = 0;
        int right = 0;
        int len = 0;
        for (int i = 0; i < n; i++) {
            char c = s.charAt(right);
            if (map.containsKey(c)) {
                left = Math.max(map.get(c) + 1, left);
            }
            map.put(s.charAt(right), right);
            len = Math.max(len, right - left + 1);
            right++;
        }
        return len;
    }

    // BRUTE FORCE
    // Set<Character>seen = new HashSet<>();
    // int left=0;
    // int right=0;
    // int max=0;
    // while(right<s.length()){
    // char c= s.charAt(right);
    // if(seen.add(c)){
    // max= Math.max(max,right-left+1);
    // right++;
    // }
    // else{
    // while(s.charAt(left)!=c){
    // seen.remove(s.charAt(left));
    // left++;
    // }
    // seen.remove(s.charAt(left));
    // left++;
    // }

    // }
    // return max;
    // }

}
