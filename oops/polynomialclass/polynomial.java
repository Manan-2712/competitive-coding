package oops.polynomialclass;

import oops.dynamic_Array.dynamicArray;
import oops.dynamic_Array.outofBoundsException;

class OutofBoundsexception extends Exception {

}

public class polynomial {

    int coefficient;
    int degree;
    dynamicArray da; // = new dynamicarray(degree);

    public polynomial() {
        degree = 0;
        coefficient = 0;
        da = new dynamicArray();
        // capacity=0;
    }

    public void set(int degree, int coefficient) {
        // da = new dynamicarray();
        this.degree = degree;
        this.coefficient = coefficient;
        da.set(degree, coefficient);
        // ++capacity;
    }

    public void add(polynomial p2) throws outofBoundsException {
        for (int i = 0; i < this.da.size(); i++) {
            for (int j = 0; j < p2.da.size(); j++) {
                try {
                    if ((i == j) && (this.da.get(i) != 0 || p2.da.get(j) != 0)) {
                        int element = this.da.get(i) + p2.da.get(j);
                        this.da.set(i, element);
                    }
                } catch (outofBoundsException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }

            }
        }

    }

    public void multiply(polynomial p2) throws outofBoundsException {
        // int product =0;
        for (int i = 0; i < this.da.size(); i++) {
            int product = 0;
            for (int j = 0; j < p2.da.size(); j++) {
                // int product =0;
                try {
                    if (this.da.get(i) == 0 || p2.da.get(j) == 0) {
                        product = 0;
                        continue;

                    }
                    product += this.da.get(i) * p2.da.get(j);
                    this.da.set((i + j), product);

                } catch (outofBoundsException e) {
                    // TODO Auto-generated catch block
                    // e.printStackTrace();
                }

            }
        }
    }

    public int evaluate(int x) throws outofBoundsException {
        int ans = Integer.MAX_VALUE;

        for (int i = 0; i < this.da.size(); i++) {
            int res = this.da.get(i);
            if (res == 0) {
                this.da.set(i, 0);
            } else {
                int result = (int) (Math.pow(x, i) * res);
                if (result < ans) {
                    ans = result;
                }
                this.da.set(i, result);
            }

        }
        return ans;

    }

    public void print() throws outofBoundsException {
        String result = "";
        for (int i = 0; i < da.size(); i++) {
            try {
                if (da.get(i) == 0) {
                    continue;
                }

                result += da.get(i) + "x" + "^" + i + " " + "+" + " ";
                // System.out.print(result);
            } catch (outofBoundsException e) {
                // TODO Auto-generated catch block

            }
        }
        System.out.println(result);

    }

}
