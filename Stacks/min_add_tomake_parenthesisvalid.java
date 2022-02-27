package Stacks;

import java.util.Stack;

public class min_add_tomake_parenthesisvalid {
    public int minAddToMakeValid(String s) {
        Stack<Character> st= new Stack<>();
        // int l=0;
         //int r=0;
         for(int i=0;i<s.length();i++){
             char ch=s.charAt(i);
             if(ch=='('){
                 st.push(ch);
             }
                 else{
                     if(!st.isEmpty() && st.peek()=='('){
                         st.pop();
                     }
                     else{
                         st.push(ch);
                     }
                 }
             }
         
         return st.size();
     }
       
 }
