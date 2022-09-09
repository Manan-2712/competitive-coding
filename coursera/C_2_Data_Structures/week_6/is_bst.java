package coursera.C_2_Data_Structures.week_6;
import java.util.*;
import java.io.*;

public class is_bst {
    class FastScanner {
        StringTokenizer tok = new StringTokenizer("");
        BufferedReader in;

        FastScanner() {
            in = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() throws IOException {
            while (!tok.hasMoreElements())
                tok = new StringTokenizer(in.readLine());
            return tok.nextToken();
        }

        int nextInt() throws IOException {
            return Integer.parseInt(next());
        }
    }

    public class IsBST {
        class Node {
            int key;
            int left;
            int right;

            Node(int key, int left, int right) {
                this.left = left;
                this.right = right;
                this.key = key;
            }
        }

        int nodes;
        Node[] tree;

        void read() throws IOException {
            FastScanner in = new FastScanner();
            nodes = in.nextInt();
            tree = new Node[nodes];
            for (int i = 0; i < nodes; i++) {
                tree[i] = new Node(in.nextInt(), in.nextInt(), in.nextInt());
            }
        }

        boolean isBinarySearchTree() {
            if (nodes == 0) {
                return true;
            }
            return isBinarySearchTreehelper(0, Integer.MIN_VALUE, Integer.MAX_VALUE);
        }

        boolean isBinarySearchTreehelper(int x, int min, int max) {
            if (x < 0) {
                return true;
            }

            if (tree[x].key > max || tree[x].key < min) {
                return false;
            }
            // FOR UNDERSTANDING...............
            // System.out.println("for left subtree");
            // System.out.println("value of x "+x);
            // System.out.println("left "+tree[x].left);
            // System.out.println("key is "+ tree[x].key);
            // System.out.println("min is "+min);
            // System.out.println("for right subtree");
            // System.out.println("value of x "+x);
            // System.out.println("right "+tree[x].right);
            // System.out.println("key is "+ tree[x].key);
            // System.out.println("max is "+max);
            return isBinarySearchTreehelper(tree[x].left, min, tree[x].key - 1)
                    && isBinarySearchTreehelper(tree[x].right, tree[x].key + 1, max);

        }

    }

    static public void main(String[] args) throws IOException {
        new Thread(null, new Runnable() {
            public void run() {
                try {
                    new is_bst().run();
                } catch (IOException e) {
                }
            }
        }, "1", 1 << 26).start();
    }

    public void run() throws IOException {
        IsBST tree = new IsBST();
        tree.read();
        if (tree.isBinarySearchTree()) {
            System.out.println("CORRECT");
        } else {
            System.out.println("INCORRECT");
        }
    }
}
