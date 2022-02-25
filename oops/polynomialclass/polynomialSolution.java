package oops.polynomialclass;

import oops.dynamic_Array.outofBoundsException;

public class polynomialSolution {

    public static void main(String[] args) throws outofBoundsException {
        polynomial p = new polynomial();
        p.set(2, 3);
        // p.set(5,4);
        // p.print();
        polynomial p2 = new polynomial();
        // p2.set(2,9);
        // p2.set(4,16);
        // p2.print();
        // p.add(p2);
        // p.print();
        // p2.print();
        // p.multiply(p2);
        // p.print();
        int ans = p.evaluate(10);
        System.out.println(ans);

    }
}
