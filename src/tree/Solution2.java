package tree;

/**
 * @author Hypnos Tsang
 * @date 2020/7/4
 */
class NumArray {
    /**
     * 307. 区域和检索 - 数组可修改
     * 给定一个整数数组  nums，求出数组从索引 i 到 j  (i ≤ j) 范围内元素的总和，包含 i,  j 两点。
     *
     * update(i, val) 函数可以通过将下标为 i 的数值更新为 val，从而对数列进行修改。
     *
     * 示例:
     *
     * Given nums = [1, 3, 5]
     *
     * sumRange(0, 2) -> 9
     * update(1, 2)
     * sumRange(0, 2) -> 8
     * 说明:
     *
     * 数组仅可以在 update 函数下进行修改。
     * 你可以假设 update 函数与 sumRange 函数的调用次数是均匀分布的。
     */
    private int[] sum;
    private int[] data;
    public NumArray(int[] nums) {
        sum = new int[nums.length + 1];
        data = new int[nums.length];
        System.arraycopy(nums, 0, data, 0, nums.length);
        sum[0] = 0;
        for (int i = 1; i < sum.length; i++) {
            sum[i] = sum[i - 1] + nums[i - 1];
        }
    }

    public void update(int index, int val) {
        data[index] = val;
        for (int i = index + 1; i < sum.length; i++) {
            sum[i] = sum[i-1] + data[i-1];
        }
    }

    public int sumRange(int i, int j) {
        return sum[j + 1] - sum[i];
    }
}


class NumArray3{
    private SegmentTree<Integer> segmentTree;
    public NumArray3(int[] nums) {
        if (nums.length > 0){
            Integer[] data = new Integer[nums.length];
            for (int i = 0; i < data.length; i++) {
                data[i] = nums[i];
            }
            segmentTree = new SegmentTree<>(data, Integer::sum);
        }
    }

    public void update(int index, int val) {
        if (segmentTree == null){
            throw new IllegalArgumentException("Segment Rree is null");
        }
        segmentTree.set(index, val);
    }

    public int sumRange(int i, int j) {
        if (segmentTree == null){
            throw new IllegalArgumentException("Error");
        }
        return segmentTree.query(i, j);
    }
}