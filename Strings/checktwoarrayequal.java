package Strings;
//https://leetcode.com/problems/check-if-two-string-arrays-are-equivalent/description/
public class checktwoarrayequal {
    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        String ar1 = "";
        int n = word1.length;
        for (int i = 0; i < n; i++) {
            ar1 += word1[i];
        }
        String ar2 = "";
        int m = word2.length;
        for (int i = 0; i < m; i++) {
            ar2 += word2[i];
        }
        if (ar1.equals(ar2)) {
            return true;
        }
        return false;
    }
}
