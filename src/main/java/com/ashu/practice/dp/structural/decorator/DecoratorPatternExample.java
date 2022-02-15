package com.ashu.practice.dp.structural.decorator;

interface ChristmasTree {
    void decorate();
}

public class DecoratorPatternExample {
    public static void main(String[] args) {
        ChristmasTree tree1 = new Garland(new ChristmasTreeImpl());
        tree1.decorate();
        ChristmasTree tree2 = new BubbleLights(
                new Garland(new TreeTopper(new ChristmasTreeImpl())));
        tree2.decorate();
    }
}

class ChristmasTreeImpl implements ChristmasTree {

    @Override
    public void decorate() {
        System.out.println("ChristmasTree");
    }
}

abstract class ChristmasTreeDecorator implements ChristmasTree {

    private final ChristmasTree tree;

    protected ChristmasTreeDecorator(ChristmasTree tree) {
        this.tree = tree;
    }

    @Override
    public void decorate() {
        tree.decorate();
        addDecoration();
    }

    abstract void addDecoration();

}

class BubbleLights extends ChristmasTreeDecorator {

    public BubbleLights(ChristmasTree tree) {
        super(tree);
    }

    @Override
    void addDecoration() {
        System.out.println("Add BubbleLights  decoration");
    }
}


class Garland extends ChristmasTreeDecorator {

    public Garland(ChristmasTree tree) {
        super(tree);
    }

    @Override
    void addDecoration() {
        System.out.println("Add Garland  decoration");
    }
}


class TreeTopper extends ChristmasTreeDecorator {

    public TreeTopper(ChristmasTree tree) {
        super(tree);
    }

    @Override
    void addDecoration() {
        System.out.println("Add TreeTopper  decoration");
    }
}