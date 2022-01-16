//https://www.codingninjas.com/codestudio/problems/compress-the-string_526?leftPanelTab=1
package codeproblems;

public class compressedString {
    public static String getCompressedString(String str) {
        int count = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            count++;
            if (i == (str.length() - 1) || str.charAt(i) != str.charAt(i + 1)) {
                if (count > 1)
                    sb.append(str.charAt(i)).append(count);
                else
                    sb.append(str.charAt(i));
                count = 0;
            }
        }
        return sb.toString();
    }

}
