package coursera.C_2_Data_Structures.week_3;
import java.io.*;
    import java.util.ArrayList;
    import java.util.List;
    import java.util.StringTokenizer;
public class makeheap {
    
    

    
        private int[] data;
        private List<Swap> swaps;
    
        private FastScanner in;
        private PrintWriter out;
    
        public static void main(String[] args) throws IOException {
            new makeheap().solve();
        }
    
        private void readData() throws IOException {
            int n = in.nextInt();
            data = new int[n];
            for (int i = 0; i < n; ++i) {
                data[i] = in.nextInt();
            }
        }
    
        private void writeResponse() {
            out.println(swaps.size());
            for (Swap swap : swaps) {
                out.println(swap.index1 + " " + swap.index2);
            }
            // for(int m :data){
            // System.out.print(m +" ");
            // }
        }
    
        public void shiftdown(int data[], int i) {
            // swaps= new ArrayList<Swap>();
            int minindex = i;
            // System.out.println("befor value of minindex "+minindex);
            int n = data.length;
            int leftchild = 2 * i + 1;
            int rightchild = 2 * i + 2;
            if (leftchild < n && data[leftchild] < data[minindex]) {
                minindex = leftchild;
            }
            if (rightchild < n && data[rightchild] < data[minindex]) {
                minindex = rightchild;
            }
            // System.out.println("after value of minindex "+minindex);
            if (minindex != i) {
                swaps.add(new Swap(i, minindex));
                int temp = data[i];
                data[i] = data[minindex];
                data[minindex] = temp;
                shiftdown(data, minindex);
            }
            // shiftdown(data, minindex);
    
        }
    
        private void generateSwaps() {
            swaps = new ArrayList<Swap>();
            // The following naive implementation just sorts
            // the given sequence using selection sort algorithm
            // and saves the resulting sequence of swaps.
            // This turns the given array into a heap,
            // but in the worst case gives a quadratic number of swaps.
            //
            // TODO: replace by a more efficient implementation
            // for (int i = 0; i < data.length; ++i) {
            // for (int j = i + 1; j < data.length; ++j) {
            // if (data[i] > data[j]) {
            // swaps.add(new Swap(i, j));
            // int tmp = data[i];
            // data[i] = data[j];
            // data[j] = tmp;
            // }
            // }
            // }
            int n = data.length;
            for (int i = n / 2 - 1; i >= 0; i--) {
                shiftdown(data, i);
            }
            // Extractmax(data);
            // for(int m:data){
            // System.out.print(m+" ");
            // }
        }
    
        public void Extractmax(int data[]) {
            int n = data.length;
            for (int i = n / 2 - 1; i >= 0; i--) {
                shiftdown(data, i);
            }
            int size = n - 1;
            while (size > 0) {
                int temp = data[0];
                data[0] = data[size];
                data[size] = temp;
                size = size - 1;
                shiftdown(data, 0);
            }
            for (int i = 0; i < n; i++) {
                System.out.print(data[i] + " ");
            }
    
        }
    
        public void solve() throws IOException {
            in = new FastScanner();
            out = new PrintWriter(new BufferedOutputStream(System.out));
            readData();
            generateSwaps();
            writeResponse();
            // Extractmax(data);
    
            out.close();
        }
    
        static class Swap {
            int index1;
            int index2;
    
            public Swap(int index1, int index2) {
                this.index1 = index1;
                this.index2 = index2;
            }
        }
    
        static class FastScanner {
            private BufferedReader reader;
            private StringTokenizer tokenizer;
    
            public FastScanner() {
                reader = new BufferedReader(new InputStreamReader(System.in));
                tokenizer = null;
            }
    
            public String next() throws IOException {
                while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                    tokenizer = new StringTokenizer(reader.readLine());
                }
                return tokenizer.nextToken();
            }
    
            public int nextInt() throws IOException {
                return Integer.parseInt(next());
            }
        }
    }
    