package map;

import java.util.*;

/**
 * @author Hypnos Tsang
 * @date 2020/7/8
 */
public class Solution {
    /**
     * 349. 两个数组的交集
     * 给定两个数组，编写一个函数来计算它们的交集。
     *
     * 示例 1:
     *
     * 输入: nums1 = [1,2,2,1], nums2 = [2,2]
     * 输出: [2]
     * 示例 2:
     *
     * 输入: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
     * 输出: [9,4]
     * 说明:
     *
     * 输出结果中的每个元素一定是唯一的。
     * 我们可以不考虑输出结果的顺序。
     */

    public int[] intersection(int[] nums1, int[] nums2) {
        TreeSet<Integer> set = new TreeSet<>();
        for (int num : nums1){
            set.add(num);
        }
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int value : nums2) {
            if (set.contains(value)) {
                arrayList.add(value);
                set.remove(value);
            }
        }
        return arrayList.stream().mapToInt(Integer::intValue).toArray();
    }

    public int[] intersect(int[] nums1, int[] nums2) {
        HashMap<Integer,Integer> map = new HashMap<>(10);
        for (int num : nums1){

            if (!map.containsKey(num)){
                map.put(num,1);
            }
            else {
                map.put(num, map.get(num) + 1);
            }
        }
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int num : nums2){
            if (map.containsKey(num)){
                arrayList.add(num);
                map.put(num,map.get(num) - 1);
                if (map.get(num) == 0){
                    map.remove(num);
                }
            }
        }
        int[] res = new int[arrayList.size()];
        for (int i = 0; i < arrayList.size(); i++) {
            res[i] = arrayList.get(i);
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().intersection(new int[]{1,2,2,1},new int[]{2,2})));
        System.out.println(Arrays.toString(new Solution().intersect(new int[]{1,2,2,1},new int[]{2,2})));
    }
}
