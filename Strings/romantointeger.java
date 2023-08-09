package Strings;
//https://leetcode.com/problems/roman-to-integer/description/
import java.util.HashMap;
import java.util.Map;

public class romantointeger {
    public int romanToInt(String s) {
        Map<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
        int value = map.get(s.charAt(s.length() - 1));
        for (int i = s.length() - 2; i >= 0; i--) {
            int val1 = map.get(s.charAt(i));
            int val2 = map.get(s.charAt(i + 1));
            if (val1 < val2) {
                value -= val1;
            } else {
                value += val1;
            }
        }
        return value;
    }
}