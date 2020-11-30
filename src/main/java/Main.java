import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        int start = 10000;
        int step = 10000;
        int end = 1000000;
        int min = 0;
        int max = 1000000000;
        int size;

        StringBuilder resultString = new StringBuilder();
        BinaryTree bt = new BinaryTree();

        createFile();
        resultString.append("size" + "  " + "Max Depth" + "  " + "addTimeElapsed" + "  " +
                "searchTimeElapsed" + "  " + "deleteTimeElapsed" + '\n');
        for (int i = start; i <= end; ) {
            size = i;
            i = i + step;

            //creating of binary tree
            long startTime = System.nanoTime();
            for (int i2 = 1; i2 <= size; i2++) {
                int value = (int) (Math.random() * (max - min + 1) + min);
                bt.add(value);
            }
            long endTime = System.nanoTime();
            long addTimeElapsed = (endTime - startTime) / 10000000;

            int maxDepthValue = bt.maxDepthValue(bt.root);

            //binary tree search method
            long startTime2 = System.nanoTime();
            int searchingValue = maxDepthValue;
            //   System.out.println(size + " "+maxDepthValue);
            bt.search(bt.root, searchingValue);
            long endTime2 = System.nanoTime();
            long searchTimeElapsed = (endTime2 - startTime2) / 10000000;

            //binary tree delete method
            long startTime3 = System.nanoTime();
            int deletingValue = (int) (Math.random() * (max - min + 1) + min);
            bt.delete(bt.root, deletingValue);
            long endTime3 = System.nanoTime();
            long deleteTimeElapsed = (endTime3 - startTime3) / 10000000;

            resultString.append(size + " " + bt.maxDepth(bt.root) + " " + addTimeElapsed + " " +
                    searchTimeElapsed + " " + deleteTimeElapsed + '\n');
             System.out.println(size + " " + bt.maxDepth(bt.root));
        }

        fileWriter(resultString.toString());
    }

    private static void createFile() {
        try {
            File myObj = new File("src/result.txt");
            if (myObj.createNewFile()) {
                System.out.println("File created: " + myObj.getName());
            } else {
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    private static void fileWriter(String text) {
        try {
            FileWriter myWriter = new FileWriter("src/result.txt");
            myWriter.write(text);
            myWriter.close();
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

}
