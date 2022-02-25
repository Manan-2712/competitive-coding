package oops.complexNumbers;

public class complex {

    private int real;
    private int imaginary;

    public complex(int real, int imaginary) {
        this.real = real;
        this.imaginary = imaginary;
    }

    public void setreal(int r) {
        this.real = r;
    }

    public void setimaginary(int i) {
        this.imaginary = i;
    }

    public int getreal() {
        return real;
    }

    public int getimaginary() {
        return imaginary;
    }

    public void add(complex c1) {
        this.real = this.real + c1.real;
        this.imaginary = this.imaginary + c1.imaginary;
    }

    public void multiply(complex c2) {
        int temp = this.real;
        this.real = this.real * c2.real - (this.imaginary * c2.imaginary);
        this.imaginary = temp * c2.imaginary + this.imaginary * c2.real;
    }

    public void subtract(complex c2) {
        this.real = (this.real - c2.real);
        this.imaginary = this.imaginary - c2.imaginary;
    }

    public static complex add(complex c1, complex c2) {
        int newreal = c1.real + c2.real;
        int newimg = c1.imaginary + c2.imaginary;
        complex cf = new complex(newreal, newimg);
        return cf;
    }

    public void print() {
        System.out.println(real + " " + "+" + " " + "i" + imaginary);
    }
}
