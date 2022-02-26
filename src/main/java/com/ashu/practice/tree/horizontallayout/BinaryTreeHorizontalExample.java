package com.ashu.practice.tree.horizontallayout;

import com.ashu.practice.tree.Node;

class BinaryTree {

    private Node<Integer> root;

    public BinaryTree() {
        root = null;
    }

    public BinaryTree(int value) {
        root = new Node<>(value);
    }

    public Node<Integer> getRoot() {
        return root;
    }

    public void setRoot(Node<Integer> root) {
        this.root = root;
    }

    @Override
    public String toString() {
        return "BinaryTree{" +
                "root=" + root +
                '}';
    }
}


public class BinaryTreeHorizontalExample {

    public static void main(String[] args) {
        BinaryTree bt = new BinaryTree();

        /*create root*/
        bt.setRoot(new Node<>(1));
        BinaryTreePrinterHorizontal btp = new BinaryTreePrinterHorizontal(bt.getRoot());
        System.out.println("Print with root node only");
        btp.print();
        /* following is the tree after above statement

              1
            /   \
          null  null

        */

        bt.getRoot().setLeft(new Node<>(2));
        bt.getRoot().setRight(new Node<>(3));
        System.out.println("\nPrint with 3 nodes");
        btp.print();
        /* 2 and 3 become left and right children of 1

               1
            /     \
          2        3
        /   \     /  \
      null null null null

      */

        bt.getRoot().getLeft().setLeft(new Node<>(4));
        /* 4 becomes left child of 2

                    1
                /       \
               2          3
             /   \       /  \
            4    null  null  null
           /   \
          null null

        */
        System.out.println("\nPrint with 4 nodes");
        btp.print(System.out);
    }
/* O/P
Print with root node only
1
Print with 3 nodes
1
├──2
└──3
Print with 4 nodes
1
├──2
│  └──4
└──3
Process finished with exit code 0
 */
}
