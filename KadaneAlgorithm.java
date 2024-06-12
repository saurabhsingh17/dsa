class MaxSubArray {

    //BruteForce O(N^2)
    public int bruteForce(int[] nums) {
        int n = nums.length;
        int maxSum = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = i; j < n; j++) {
                sum += nums[j];
                maxSum = Math.max(maxSum, sum);
            }
        }
        return maxSum;
    }
    //Kadane Algorithm O(N)
    public int optimal(int[] nums) {
        int n = nums.length;
        int maxSum = nums[0];
        int sum = nums[0];
        for (int i = 1; i < n; i++) {
            sum+= nums[i];
            if (sum < 0) sum = 0;
            maxSum = Math.max(maxSum, sum);
        }
        return maxSum;
    }
}
