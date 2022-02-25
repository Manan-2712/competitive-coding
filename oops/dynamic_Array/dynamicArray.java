package oops.dynamic_Array;

public class dynamicArray {

    

    private int data[];
    private int nextindex;

    public dynamicArray() {
        data = new int[10];
        nextindex = 0;
    }

    public dynamicArray(int n) {
        data = new int[n];
        nextindex = 0;
    }

    public int size() {
        return data.length;
    }

    public void add(int element) {
        if (nextindex == data.length) {
            reconstruct();
        }
        data[nextindex] = element;
        nextindex++;
    }

    public void set(int index, int element) {
        if (index < data.length) {
            data[index] = element;
        } else {
            add(element);
        }
    }

    public int get(int index) throws outofBoundsException {
        if (index > data.length) {
            outofBoundsException ob = new outofBoundsException();
            throw ob;
        }
        return data[index];

    }

    public boolean isEmpty() {
        return (size() == 0);
    }

    public int removelast() {
        if (nextindex == 0) {
            return -1;
        }
        int value = data[nextindex - 1];
        data[nextindex - 1] = 0;
        nextindex--;
        return value;
    }

    public void reconstruct() {
        int temp[] = data;
        data = new int[2 * data.length];
        for (int i = 0; i < temp.length; i++) {
            data[i] = temp[i];
        }

    }

    public void print() {
        for (int i = 0; i < size(); i++) {
            System.out.print(data[i]);
            System.out.print(" ");
        }
    }

}
