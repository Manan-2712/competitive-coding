//https://www.codingninjas.com/codestudio/problems/design-a-stack-that-supports-getmin-in-o-1-time-and-o-1-extra-space_842465?leftPanelTab=1
package Stacks;

import java.util.*;

public class specialStack {

    // Define the data members.
    Stack<Integer> st = new Stack<Integer>();
    int min;

    /*----------------- Public Functions of SpecialStack -----------------*/

    void push(int data) {
        if (st.isEmpty()) {
            st.push(data);
            min = data;
        } else {
            if (data > min) {
                st.push(data);
            } else {
                st.push(2 * data - min);
                min = data;
            }
        }
    }

    int pop() {
        if (st.isEmpty()) {
            return -1;
        }
        int curr = st.peek();
        st.pop();
        if (curr > min) {
            return curr;
        } else {
            int prevmin = min;
            int pop = 2 * min - curr;
            // st.pop();
            min = pop;
            return prevmin;
        }
    }

    int top() {
        if (st.isEmpty())
            return -1;

        int curr = st.peek();
        if (curr > min) {
            return curr;
        } else {
            return min;
        }

    }

    boolean isEmpty() {
        return st.isEmpty();
    }

    int getMin() {
        if (st.isEmpty()) {
            return -1;
        }
        return min;
    }
}
