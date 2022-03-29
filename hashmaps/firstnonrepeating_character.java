//https://www.codingninjas.com/codestudio/problems/first-non-repeating-character_920324?leftPanelTab=1
package hashmaps;

import java.util.*;

public class firstnonrepeating_character {

    public static char firstNonRepeatingCharacter(String str) {
        HashMap<Character, Integer> map = new HashMap<>();
        char ch[] = str.toCharArray();
        for (int i = 0; i < ch.length; i++) {
            map.put(ch[i], map.getOrDefault(ch[i], 0) + 1);
        }
        for (int i = 0; i < str.length(); i++) {
            char cha = str.charAt(i);
            if (map.get(cha) == 1) {
                return cha;
            }
        }
        return str.charAt(0);

    }
}
