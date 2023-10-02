package training.design_pattern.composite;

class Main
{
    public static void main(String[] args)
    {
        Leaf leaf1 = new Leaf("a");
        Leaf leaf2 = new Leaf("b");
        Group group1 = new Group(leaf1, leaf2);
        Leaf leaf3 = new Leaf("c");
        Group group2 = new Group(group1, leaf3);

        group2.render();
    }
}
