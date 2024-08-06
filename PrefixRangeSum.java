public class PrefixRangeSum {
    private int[] prefixSum;

    public static void main(String[] args) {
        int nums[] = {-2, 0, 3, -5, 2, -1};
        PrefixRangeSum prefixRangeSum = new PrefixRangeSum(nums);
        System.out.println(prefixRangeSum.rangeSum(0, 2)); // Output: 1
        System.out.println(prefixRangeSum.rangeSum(2, 5)); // Output: -1
        System.out.println(prefixRangeSum.rangeSum(0, 5)); // Output: -3
    }

    public PrefixRangeSum(int[] nums) {
        int n = nums.length;
        prefixSum = new int[n];
        if (n > 0) {
            prefixSum[0] = nums[0];
            for (int i = 1; i < n; i++) {
                prefixSum[i] = prefixSum[i - 1] + nums[i];
            }
        }
    }

    public int rangeSum(int left, int right) {
        return left > 0 ? prefixSum[right] - prefixSum[left - 1] : prefixSum[right];
    }
}
