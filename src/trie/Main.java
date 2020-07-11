package trie;

import heap.MaxHeap;
import set.BinarySearchTreeSet;
import set.FileOperation;

import javax.crypto.spec.PSource;
import java.util.ArrayList;

/**
 * @author Hypnos Tsang
 * @date 2020/7/8
 */
public class Main {
    public static void main(String[] args) {
        String file = "E:\\data\\Pride_and_Prejudice.txt";
        ArrayList<String> words = new ArrayList<>();
        if (FileOperation.readFile(file,words)){
            long startTime = System.nanoTime();
            BinarySearchTreeSet<String> set = new BinarySearchTreeSet<>();
            for (String word : words){
                set.add(word);
            }
            for (String word: words ){
                set.contains(word);
            }
            long endTime = System.nanoTime();
            double time = (endTime - startTime) / Math.pow(10, 9);
            System.out.println("Total different words : " + set.getSize());
            System.out.println("BSTSet : " + time + " s");

            startTime = System.nanoTime();
            Trie trie = new Trie();
            for (String word : words){
                trie.add(word);
            }
            for (String word: words ){
                trie.contains(word);
            }
            endTime = System.nanoTime();
            time = (endTime - startTime) / Math.pow(10, 9);
            System.out.println("Total different words : " + trie.getSize());
            System.out.println("Trie : " + time + " s");
        }
    }
}
