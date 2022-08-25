package coursera.C_2_Data_Structures;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Stack;

class Bracket {
    char type;
    int position;

    Bracket(char type, int position) {
        this.type = type;
        this.position = position;
    }

    boolean Match(char c) {
        if (this.type == '[' && c == ']')
            return true;
        if (this.type == '{' && c == '}')
            return true;
        if (this.type == '(' && c == ')')
            return true;
        return false;
    }

}

public class checkparenthesis {

    public static void main(String[] args) throws IOException {
        InputStreamReader input_stream = new InputStreamReader(System.in);
        BufferedReader reader = new BufferedReader(input_stream);
        String text = reader.readLine();

        Stack<Bracket> stack = new Stack<Bracket>();
        int ans = 0;
        boolean nomatch = false;
        for (int position = 0; position < text.length(); ++position) {
            // Bracket br = new Bracket(type, position);
            char next = text.charAt(position);

            // char type = text.charAt(position);
            Bracket br = new Bracket(next, position);

            if (next == '(' || next == '[' || next == '{') {
                stack.add(br);
            }

            if (next == ')' || next == ']' || next == '}') {

                if (!stack.isEmpty()) {
                    Bracket top = stack.peek();

                    if (!top.Match(next)) {
                        nomatch = true;
                        ans = position + 1;
                        break;
                    } else {
                        stack.pop();
                    }
                } else {
                    stack.add(br);
                    break;
                }
            }
        }
        if (stack.isEmpty()) {
            System.out.println("Success");
        } else {
            if (nomatch == true) {
                System.out.println(ans);
            } else {
                int res = stack.peek().position;
                System.out.println(res + 1);
            }
        }

        // Printing answer, write your code here
    }
}
