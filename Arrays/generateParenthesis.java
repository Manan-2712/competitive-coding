package Arrays;
import java.util.ArrayList;

public class generateParenthesis {

    public static ArrayList<String> validParenthesis(int n) {
        ArrayList<String> list = new ArrayList<>();
        String ans = "";
        generate(n, ans, 0, 0, list);
        return list;
    }

    public static void generate(int n, String ans, int open, int close, ArrayList<String> list) {
        if (ans.length() == 2 * n) {
            list.add(ans);
            return;
        }
        if (open < n) {
            generate(n, ans + '(', open + 1, close, list);
        }
        if (close < open) {
            generate(n, ans + ')', open, close + 1, list);
        }
    }
}
