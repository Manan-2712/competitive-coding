package BINARYTREES;
import java.util.LinkedList;
import java.util.Queue;


class BinaryTreeNode<T> {
    T data;
    BinaryTreeNode<T> left;
    BinaryTreeNode<T> right;

    public BinaryTreeNode(T data) {
        this.data = data;

    }
}
public class MinimalTree {

    public static BinaryTreeNode<Integer> treehelper(int arr[], int start, int end) {
        if (start > end) {
            return null;
        }
        int mid = (start + end) / 2;
        int root2 = arr[mid];
        BinaryTreeNode<Integer> root = new BinaryTreeNode<Integer>(root2);
        root.left = treehelper(arr, start, mid - 1);
        root.right = treehelper(arr, mid + 1, end);
        return root;
    }

    public static BinaryTreeNode<Integer> tree(int arr[]) {
        return treehelper(arr, 0, arr.length - 1);
    }

    public static void printlevelwise(BinaryTreeNode<Integer> root) {
        Queue<BinaryTreeNode<Integer>> pendingnodes = new LinkedList<>();
        if (root == null) {
            return;
        }
        pendingnodes.add(root);
        while (!pendingnodes.isEmpty()) {

            BinaryTreeNode<Integer> frontnode = pendingnodes.poll();
            String s = frontnode.data + ":";
            if (frontnode.left != null) {
                s = s + "L" + frontnode.left.data + ",";
                pendingnodes.add(frontnode.left);
            }
            if (frontnode.right != null) {
                s = s + "R" + frontnode.right.data + ",";
                pendingnodes.add(frontnode.right);
            }
            System.out.println(s);

        }

    }

    public static void main(String[] args) {
        int arr[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
        BinaryTreeNode<Integer> root1 = tree(arr);
        printlevelwise(root1);
    }
}

    

