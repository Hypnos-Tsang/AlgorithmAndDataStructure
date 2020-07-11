package set;

import java.util.ArrayList;

/**
 * @author Hypnos Tsang
 * @date 2020/7/8
 */
public class Main {
    public static void main(String[] args) {
        String file = "E:\\data\\Pride_and_Prejudice.txt";
        LinkedListSet<String> set1 = new LinkedListSet<>();
        BinarySearchTreeSet<String> set2 = new BinarySearchTreeSet<>();
        System.out.println("LinkedListSet time : " + testSet(set1, file));
        System.out.println("BSTSet time : " + testSet(set2, file));
    }

    private static double testSet(Set<String> set, String fileName){
        long startTime = System.nanoTime();
        System.out.println(fileName);
        ArrayList<String> words = new ArrayList<>();
        if (FileOperation.readFile(fileName, words)){
            System.out.println("Total words : " + words.size());
            for (String word : words){
                set.add(word);
            }
            System.out.println("Total different words : " + set.getSize());
        }
        return (System.nanoTime() - startTime) / Math.pow(10,9);
    }
}
