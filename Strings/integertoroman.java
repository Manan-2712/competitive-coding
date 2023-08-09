package Strings;

//https://leetcode.com/problems/integer-to-roman/description/
public class integertoroman {
    public String intToRoman(int num) {
        int nums[] = { 1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1 };
        String roman = "";
        String romannum[] = { "M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I" };
        for (int i = 0; i < nums.length; i++) {
            while (num >= nums[i]) {
                roman += romannum[i];
                num -= nums[i];

            }
        }
        return roman;

    }
}
