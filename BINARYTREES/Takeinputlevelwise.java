package BINARYTREES;

import java.util.Scanner;

public class Takeinputlevelwise {
    public static BinaryTreeNode<Integer> takeinputlevelwise() {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter the root data");
        int data = sc.nextInt();
        if (data == -1) {
            return null;
        }
        BinaryTreeNode<Integer> root = new BinaryTreeNode<Integer>(data);
        QueueusingLinkedList<BinaryTreeNode<Integer>> pendingnodes = new QueueusingLinkedList<>();
        pendingnodes.enqueue(root);
        while (!pendingnodes.isEmpty()) {
            // BinaryTreeNode<Integer>front;
            try {
                BinaryTreeNode<Integer> front = pendingnodes.dequeue();
                System.out.println("enter the left child of " + front.data);
                int left = sc.nextInt();
                if (left != -1) {
                    BinaryTreeNode<Integer> Left = new BinaryTreeNode<Integer>(left);
                    pendingnodes.enqueue(Left);
                    front.left = Left;
                }
                System.out.println("enter the right child of " + front.data);
                int right = sc.nextInt();
                if (right != -1) {
                    BinaryTreeNode<Integer> Right = new BinaryTreeNode<Integer>(right);
                    pendingnodes.enqueue(Right);
                    front.right = Right;
                }
            } catch (QueueEmptyException e) {
                // TODO Auto-generated catch block

            }

        }
        return root;
    }

    public static void print(BinaryTreeNode<Integer> root) {
        if (root == null) {
            return;
        }
        String s = root.data + ":";
        if (root.left != null) {
            s = s + "L" + root.left.data + ",";
        }
        if (root.right != null) {
            s = s + "R" + root.right.data + ",";
        }
        System.out.println(s);
        print(root.left);
        print(root.right);
        // System.out.println(s);
    }

}
