import java.util.ArrayList;
import java.util.List;

public class PrefixRangeSum {
    int[] prefixSum;
    int n;

    public static void main(String[] args) {
        int nums[] = {-2, 0, 3, -5, 2, -1};
        PrefixRangeSum prefixRangeSum = new PrefixRangeSum(nums);
         System.out.println(prefixRangeSum.rangeSum(0, 2));
         System.out.println(prefixRangeSum.rangeSum(2,5));
         System.out.println(prefixRangeSum.rangeSum(0, 5));

    }

    public PrefixRangeSum(int[] nums) {
        n = nums.length;
        prefixSum = new int[n];
        int total = 0;
        int i = 0;
        for (int n : nums) {
            total += n;
            prefixSum[i++] = total;
        }
    }

    public int rangeSum(int left, int right) {
        int preRight = prefixSum[right];
        int preLeft = left > 0 ? prefixSum[left-1] : 0;
        return (preRight - preLeft);
    }
}
