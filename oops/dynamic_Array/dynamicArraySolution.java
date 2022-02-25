package oops.dynamic_Array;

public class dynamicArraySolution {

    public static void main(String[] args) throws outofBoundsException {
        dynamicArray da = new dynamicArray();
        for (int i = 0; i < 20; i++) {
            da.add(i);
        }
        // System.out.println(da.size());
        // System.out.println();
        da.print();
        // da.set(2, 50);
        // System.out.println(da.removelast());
        // da.removelast();
        // da.print();
        // System.out.println(da.get(20));
        // System.out.println(da.isEmpty());
    }

}
