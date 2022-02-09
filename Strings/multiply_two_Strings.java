//https://www.codingninjas.com/codestudio/problems/multiply-strings_982763?leftPanelTab=1
package Strings;

public class multiply_two_Strings {
    public static String multiplyStrings(String s1, String s2) {
        if (s1.equals("0") || s2.equals("0")) {
            return "0";
        }
        int l1 = s1.length();
        int l2 = s2.length();
        int res[] = new int[l1 + l2];
        int i = l2 - 1;
        int pf = 0;
        while (i >= 0) {
            // int pf=0;
            int carry = 0;
            int ival = s2.charAt(i) - '0';
            i--;
            int k = res.length - 1 - pf;
            int j = l1 - 1;
            while (j >= 0 || carry != 0) {
                int jval = j >= 0 ? s1.charAt(j) - '0' : 0;
                j--;
                int product = ival * jval + carry + res[k];
                res[k] = product % 10;
                carry = product / 10;
                k--;
            }
            pf++;
        }
        // to remove leading zeros
        String result = "";
        boolean flag = false;
        for (int val : res) {
            if (val == 0 && flag == false) {
                continue;
            } else {
                flag = true;
                result += val;
                // flag = true;
            }

        }
        return result;

    }
}
