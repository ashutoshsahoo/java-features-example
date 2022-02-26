package com.ashu.practice.tree.verticallayout;

import com.ashu.practice.tree.Node;

public class BinaryTreePrinterVerticalExample {

    private static Node<Integer> test1() {
        Node<Integer> root = new Node<>(2);
        Node<Integer> n11 = new Node<>(7);
        Node<Integer> n12 = new Node<>(5);
        Node<Integer> n21 = new Node<>(2);
        Node<Integer> n22 = new Node<>(6);
        Node<Integer> n23 = new Node<>(3);
        Node<Integer> n24 = new Node<>(6);
        Node<Integer> n31 = new Node<>(5);
        Node<Integer> n32 = new Node<>(8);
        Node<Integer> n33 = new Node<>(4);
        Node<Integer> n34 = new Node<>(5);
        Node<Integer> n35 = new Node<>(8);
        Node<Integer> n36 = new Node<>(4);
        Node<Integer> n37 = new Node<>(5);
        Node<Integer> n38 = new Node<>(8);

        root.setLeft(n11);
        root.setRight(n12);

        n11.setLeft(n21);
        n11.setRight(n22);
        n12.setLeft(n23);
        n12.setRight(n24);

        n21.setLeft(n31);
        n21.setRight(n32);
        n22.setLeft(n33);
        n22.setRight(n34);
        n23.setLeft(n35);
        n23.setRight(n36);
        n24.setLeft(n37);
        n24.setRight(n38);

        return root;
    }

    private static Node<Integer> test2() {
        Node<Integer> root = new Node<>(2);
        Node<Integer> n11 = new Node<>(7);
        Node<Integer> n12 = new Node<>(5);
        Node<Integer> n21 = new Node<>(2);
        Node<Integer> n22 = new Node<>(6);
        Node<Integer> n23 = new Node<>(9);
        Node<Integer> n31 = new Node<>(5);
        Node<Integer> n32 = new Node<>(8);
        Node<Integer> n33 = new Node<>(4);

        root.setLeft(n11);
        root.setRight(n12);

        n11.setLeft(n21);
        n11.setRight(n22);

        n12.setRight(n23);
        n22.setLeft(n31);
        n22.setRight(n32);

        n23.setLeft(n33);

        return root;
    }

    public static void main(String[] args) {
        BinaryTreePrinterVertical.printNode(test1());
        BinaryTreePrinterVertical.printNode(test2());
    }
}
