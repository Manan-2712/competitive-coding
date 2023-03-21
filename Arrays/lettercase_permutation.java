package Arrays;
import java.util.*;
//https://leetcode.com/problems/letter-case-permutation/description/
public class lettercase_permutation {

    public List<String> letterCasePermutation(String s) {
        List<String> res = new ArrayList<>();
        char ch[] = s.toCharArray();
        permute(res, 0, ch);
        return res;

    }

    public void permute(List<String> res, int index, char[] ch) {
        if (index == ch.length) {
            res.add(new String(ch));
            return;
        }
        if (Character.isLetter(ch[index])) {
            ch[index] = Character.toUpperCase(ch[index]);
            permute(res, index + 1, ch);
            ch[index] = Character.toLowerCase(ch[index]);
            permute(res, index + 1, ch);
        } else {
            permute(res, index + 1, ch);
        }
    }
}
