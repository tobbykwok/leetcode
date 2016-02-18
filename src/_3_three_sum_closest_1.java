import java.util.Arrays;
import java.util.List;

/**
 * Created by tobby on 16/2/17.
 * https://leetcode.com/problems/3sum-closest/
 */
public class _3_three_sum_closest_1 {
    public static int my_threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int min = Integer.MAX_VALUE;
        int value = 0;
        int N = nums.length;
        for (int i = 0; i < N; i++) {
            int start = i + 1;
            int end = N - 1;
            while (start < end) {
                int sum = nums[i] + nums[start] + nums[end];
                int diff = Math.abs(target - sum);
                if (diff < min) {
                    min = diff;
                    value = sum;
                }
                if (sum > target) {
                    --end;
                } else {
                    ++start;
                }
            }
        }
        return value;
    }

    public static void main(String[] args) {
        int min = my_threeSumClosest(new int[]{4, -1, -4, 4}, 1);
    }
}

