package tree;

import java.util.ArrayList;
import java.util.Random;

/**
 * @author Hypnos Tsang
 * @date 2020/7/8
 */
public class Main {
    /**
     * int[] nums = {4, 5, 2, 4, 5, 7, 3};
     *                    4
     *                  /   \
     *                 2     5
     *                / \   / \
     *                   3     7
     * @param args null
     */
    public static void main(String[] args) {
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();
        Random random = new Random();
        int n = 2000;
        for (int i = 0; i < n; i++) {
            bst.add(random.nextInt(10000));
        }
        ArrayList<Integer> arrayList = new ArrayList<>();
        while (!bst.isEmpty()){
            arrayList.add(bst.removeMin());
        }
        System.out.println(arrayList);
        for (int i = 1; i < arrayList.size(); i++) {
            if (arrayList.get(i-1) > arrayList.get(i)){
                System.out.println("Error");
            }
        }
    }
}
