package oops.complexNumbers;

public class complexSolution {

    public static void main(String[] args) {
        complex c = new complex(4, 5);
        c.print();
        c.setreal(5);
        int d = c.getreal();
        c.print();

        complex c1 = new complex(5, 5);
        c.add(c1);
        c.print();

        complex c2 = new complex(1, 2);
        c.multiply(c2);
        c.print();
        c2.print();

        complex c3 = new complex(1, 2);
        c.subtract(c3);
        c.print();

        complex c4 = complex.add(c, c3);
        c4.print();
        c.print();
        c3.print();

    }

}
