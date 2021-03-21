import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Main {
    static String nameOfFile;

    public static void main(String[] args) {
        int start = 10000;
        int step = 10000;
        int end = 1000000;
        int min = 1;
        int max = 1000000000;
        int size;
        nameOfFile = String.valueOf(max);
        StringBuilder resultString = new StringBuilder();
        AVLTree avlTree = new AVLTree();

        createFile();
        resultString.append("size" + "  " + "MaxDepth" + "  " + "addTimeElapsed" + "  " +
                "searchTimeElapsed" + "  " + "deleteTimeElapsed" + '\n');
        for (int i = start; i <= end; ) {
            size = i;
            i = i + step;
            //creating of binary tree
            long time1 = 0;
            long time2 = 0;
            long time3 = 0;
            for (int i2 = 1; i2 <= size; i2++) {
                int value = (int) (Math.random() * (max - min + 1) + min);
                long startTime = System.nanoTime();
                avlTree.add(value);
                long endTime = System.nanoTime();
                long time = (endTime - startTime) / 1;
                time1 = time1 + time;
            }
            long addTimeElapsed = time1 / size;
            int maxDepthPrint = avlTree.height(avlTree.root);

            //binary tree search method
            for (int j = 0; j < 100; j++) {
                int searchingValue = (int) (Math.random() * (max - min + 1) + min);
                long startTime2 = System.nanoTime();
                avlTree.search(avlTree.root, searchingValue);
                long endTime2 = System.nanoTime();
                long time = (endTime2 - startTime2) / 1;
                time2 = time2 + time;
            }
            long searchTimeElapsed = time2 / 100;

            //binary tree delete method
            for (int j = 0; j < 100; j++) {
                int deletingValue = (int) (Math.random() * (max - min + 1) + min);
                long startTime3 = System.nanoTime();
                avlTree.deleteKey(deletingValue);
                long endTime3 = System.nanoTime();
                long time = (endTime3 - startTime3) / 1;
                time3 = time3 + time;
            }
            long deleteTimeElapsed = time3 / 100;

            resultString.append(size + " " + maxDepthPrint + " " + addTimeElapsed + " " +
                    searchTimeElapsed + " " + deleteTimeElapsed + '\n');
            System.out.println(size + " " + maxDepthPrint + " " + addTimeElapsed + " " +
                    searchTimeElapsed + " " + deleteTimeElapsed);
        }

        fileWriter(resultString.toString());

    }

    private static void createFile() {
        try {
            File myObj = new File("AVLTree/src/" + nameOfFile + ".txt");
            if (myObj.createNewFile()) {
                System.out.println("File created: " + myObj.getName());
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    private static void fileWriter(String text) {
        try {
            FileWriter myWriter = new FileWriter("AVLTree/src/" + nameOfFile + ".txt");
            myWriter.write(text);
            myWriter.close();
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}
