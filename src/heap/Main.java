package heap;

import java.util.Random;

/**
 * @author Hypnos Tsang
 * @date 2020/7/3
 */
public class Main {
    private static double testHeap(Integer[] testData, boolean isHeapify){
        long startTime = System.nanoTime();
        MaxHeap<Integer> maxHeap;
        if (isHeapify){
            maxHeap = new MaxHeap<>(testData);
        }
        else{
            maxHeap = new MaxHeap<>();
            for (int num : testData) {
                maxHeap.add(num);
            }
        }
        int[] arr = new int[testData.length];
        for (int i = 0; i < testData.length; i++) {
            arr[i] = maxHeap.extractMax();
        }
        for (int i = 1; i < testData.length; i++) {
            if (arr[i-1] < arr[i]){
                throw new IllegalArgumentException("Error");
            }
        }
       return ((System.nanoTime() - startTime) / Math.pow(10,9));
    }
    public static void main(String[] args) {
        int n = 1000000;
        Integer[] testData = new Integer[n];
        Random random = new Random();
        for (int i = 0; i < n; i++) {
            testData[i] = random.nextInt(Integer.MAX_VALUE);
        }
        double time1 = testHeap(testData, false);
        double time2 = testHeap(testData, true);
        System.out.println("Without heapify : " + time1 + " s");
        System.out.println("With heapify : " + time2 + " s");
        System.out.println("Test MaxHeap completed");
    }

}
