package heap;

import java.util.Comparator;
import java.util.TreeMap;
import java.util.PriorityQueue;

/**
 * @author Hypnos Tsang
 * @date 2020/7/3
 */
public class Solution {
    /**
     * 给定一个非空的整数数组，返回其中出现频率前 k 高的元素。
     *
     *  
     *
     * 示例 1:
     *
     * 输入: nums = [1,1,1,2,2,3], k = 2
     * 输出: [1,2]
     * 示例 2:
     *
     * 输入: nums = [1], k = 1
     * 输出: [1]
     *  
     *
     * 提示：
     *
     * 你可以假设给定的 k 总是合理的，且 1 ≤ k ≤ 数组中不相同的元素的个数。
     * 你的算法的时间复杂度必须优于 O(n log n) , n 是数组的大小。
     * 题目数据保证答案唯一，换句话说，数组中前 k 个高频元素的集合是唯一的。
     * 你可以按任意顺序返回答案。
     */
/*    private class Freq implements Comparable<Freq>{
        int e, freq;

        public Freq(int e, int freq){
            this.e = e;
            this.freq = freq;
        }

        @Override
        public int compareTo(Freq another) {
            return Integer.compare(another.freq, this.freq);
        }
    }

    public int[] topKFrequent(int[] nums, int k) {
        TreeMap<Integer, Integer> treeMap = new TreeMap<>();
        int[] res = new int[k];
        for (int num : nums) {
            if (treeMap.containsKey(num)){
                treeMap.put(num, treeMap.get(num) + 1);
            }else {
                treeMap.put(num, 1);
            }
        }
        PriorityQueue<Freq> pq = new PriorityQueue<>();
        for (int key : treeMap.keySet()){
            if (pq.getSize() < k){
                pq.enqueue(new Freq(key, treeMap.get(key)));
            }
            else if (treeMap.get(key) > pq.getFront().freq){
                pq.dequeue();
                pq.enqueue(new Freq(key, treeMap.get(key)));
            }
        }
        for (int i = 0; i < k; i++) {
            res[i] = pq.dequeue().e;
        }
        return res;*/

    public int[] topKFrequent(int[] nums, int k) {
        TreeMap<Integer, Integer> treeMap = new TreeMap<>();
        int[] res = new int[k];
        for (int num : nums) {
            if (treeMap.containsKey(num)){
                treeMap.put(num, treeMap.get(num) + 1);
            }else {
                treeMap.put(num, 1);
            }
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.comparingInt(treeMap::get));
        for (int key : treeMap.keySet()){
            if (pq.size() < k){
                pq.add(key);
            }
            else if (treeMap.get(key) > treeMap.get(pq.peek())){
                pq.remove();
                pq.add(key);
            }
        }
        for (int i = 0; i < k; i++) {
            res[i] = pq.remove();
        }
        return res;
    }
}
