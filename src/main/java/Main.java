import java.util.TreeMap;

public class Main {

    public static void main(String[] args) {
        int size;
//        TreeMapTask treeMapTask = new TreeMapTask();
//        System.out.println(treeMapTask.toString());
//        System.out.println(treeMapTask.putTime().size() +" " +treeMapTask.getLastKey());
        BinaryTree bt = new BinaryTree();
        for (int i = 1; i <= 200; i++) {
            size = i;
            for (int i2 = 1; i2 <= size; i2++) {
                int max = 1000000;
                int min = -1000000;
                int value = (int) (Math.random() * (max - min + 1) + min);
                bt.add(value);
            }
            System.out.println(size + " " + bt.maxDepth(bt.root));
        }
    }
}
