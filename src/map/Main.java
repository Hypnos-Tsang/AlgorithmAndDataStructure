package map;

import set.FileOperation;
import java.util.ArrayList;

/**
 * @author Hypnos Tsang
 * @date 2020/7/8
 */
public class Main {
    private static double testMap(Map<String, Integer> map, String fileName){
        long time = System.nanoTime();
        System.out.println(fileName);
        ArrayList<String> words = new ArrayList<>();
        if (FileOperation.readFile(fileName, words)){
            System.out.println("Total words : " + words.size());
            for (String word : words){
                if (map.contains(word)){
                    map.set(word, map.get(word) + 1);
                }
                else {
                    map.add(word, 1);
                }
            }
            System.out.println("Total different words : " + map.getSize());
            System.out.println("Frequency of PRIDE : " + map.get("pride"));
            System.out.println("Frequency of PREJUDICE : " + map.get("prejudice"));
        }
        return (System.nanoTime() - time) / Math.pow(10,9);
    }

    public static void main(String[] args) {
        String file = "E:\\data\\Pride_and_Prejudice.txt";
        LinkedListMap<String, Integer> map1 = new LinkedListMap<>();
        BinarySearchTreeMap<String, Integer> map2 = new BinarySearchTreeMap<>();
        System.out.println("LinkedListMap Time : " + testMap(map1,file));
        System.out.println("BSTMap Time : " + testMap(map2,file));
    }
}
