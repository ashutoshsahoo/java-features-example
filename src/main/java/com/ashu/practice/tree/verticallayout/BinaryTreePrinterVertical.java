package com.ashu.practice.tree.verticallayout;

import com.ashu.practice.tree.Node;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public record BinaryTreePrinterVertical() {

    public static <T extends Comparable<?>> void printNode(Node<T> root) {
        int maxLevel = BinaryTreePrinterVertical.maxLevel(root);
        printNodeInternal(Collections.singletonList(root), 1, maxLevel);
    }

    private static <T extends Comparable<?>> void printNodeInternal(List<Node<T>> nodes, int level, int maxLevel) {
        if (nodes.isEmpty() || BinaryTreePrinterVertical.isAllElementsNull(nodes))
            return;

        int floor = maxLevel - level;
        int endgeLines = (int) Math.pow(2, (Math.max(floor - 1, 0)));
        int firstSpaces = (int) Math.pow(2, (floor)) - 1;
        int betweenSpaces = (int) Math.pow(2, (floor + 1)) - 1;

        BinaryTreePrinterVertical.printWhitespaces(firstSpaces);

        List<Node<T>> newNodes = new ArrayList<>();
        for (Node<T> node : nodes) {
            if (node != null) {
                System.out.print(node.getData());
                newNodes.add(node.getLeft());
                newNodes.add(node.getRight());
            } else {
                newNodes.add(null);
                newNodes.add(null);
                System.out.print(" ");
            }

            BinaryTreePrinterVertical.printWhitespaces(betweenSpaces);
        }
        System.out.println("");

        for (int i = 1; i <= endgeLines; i++) {
            for (Node<T> node : nodes) {
                BinaryTreePrinterVertical.printWhitespaces(firstSpaces - i);
                if (node == null) {
                    BinaryTreePrinterVertical.printWhitespaces(endgeLines + endgeLines + i + 1);
                    continue;
                }

                if (node.getLeft() != null)
                    System.out.print("/");
                else
                    BinaryTreePrinterVertical.printWhitespaces(1);

                BinaryTreePrinterVertical.printWhitespaces(i + i - 1);

                if (node.getRight() != null)
                    System.out.print("\\");
                else
                    BinaryTreePrinterVertical.printWhitespaces(1);

                BinaryTreePrinterVertical.printWhitespaces(endgeLines + endgeLines - i);
            }

            System.out.println("");
        }

        printNodeInternal(newNodes, level + 1, maxLevel);
    }

    private static void printWhitespaces(int count) {
        for (int i = 0; i < count; i++)
            System.out.print(" ");
    }

    private static <T extends Comparable<?>> int maxLevel(Node<T> node) {
        if (node == null)
            return 0;

        return Math.max(BinaryTreePrinterVertical.maxLevel(node.getLeft()), BinaryTreePrinterVertical.maxLevel(node.getRight())) + 1;
    }

    private static <T> boolean isAllElementsNull(List<T> list) {
        for (Object object : list) {
            if (object != null)
                return false;
        }

        return true;
    }

}


