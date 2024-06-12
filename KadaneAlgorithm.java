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
    // Return the left and right index of the max subarray sum,
    // assuming there's exactly one result (no ties).
    // Sliding window variation of Kadane's: O(n)
    public static int[] slidingWindow(int[] nums) {
        int maxSum = nums[0];
        int curSum = 0;
        int maxL = 0, maxR = 0;
        int L = 0;

        for (int R = 0; R < nums.length; R++) {
            if (curSum < 0) {
                curSum = 0;
                L = R;
            }
            curSum += nums[R];
            if (curSum > maxSum) {
                maxSum = curSum;
                maxL = L; 
                maxR = R;     
            }    
        }    
        return new int[] {maxL, maxR};
}
