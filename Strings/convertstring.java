package Strings;
//https://www.codingninjas.com/studio/problems/convert-string_1062635?leftPanelTab=0
import java.util.*;
import java.io.*;

public class convertstring {

    public static String convertString(String str) {
        char ch[] = str.toCharArray();
        if (ch[0] > 90) {
            ch[0] = (char) (ch[0] - 32);
        }
        for (int i = 1; i < str.length(); i++) {
            if (ch[i - 1] == ' ' && ch[i] > 90) {
                ch[i] = (char) (ch[i] - 32);
            }
        }
        str = new String(ch);
        return str;
    }

}
