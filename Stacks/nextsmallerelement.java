package Stacks;

import java.util.*;
//https://www.codingninjas.com/studio/problems/immediate-smaller-element-_1062597?utm_source=striver&utm_medium=website&utm_campaign=a_zcoursetuf&leftPanelTab=0
public class nextsmallerelement {
    public static void immediateSmaller(int[] a) {

        // FIRST APPROACH - MINE
        // Stack<Integer>st = new Stack<Integer>();
        // int n = a.length;
        // int res[]= new int[n];
        // res[n-1]=-1;
        // st.add(a[n-1]);
        // for(int i = n-2;i>=0;i--){
        // if(st.peek() < a[i]){
        // res[i]= st.peek();
        // st.add(a[i]);
        // }
        // else{
        // res[i] = -1;
        // st.add(a[i]);
        // }

        // }
        // for(int i=0;i<a.length;i++){
        // a[i]= res[i];
        // }

        // SECOND APPROACH
        int n = a.length;
        Stack<Integer> st = new Stack<>();
        st.add(a[0]);
        for (int i = 1; i < n; i++) {
            if (a[i] > st.peek()) {
                a[i - 1] = -1;
            } else {
                a[i - 1] = a[i];
            }
            st.add(a[i]);
        }
        a[n - 1] = -1;

    }
}
