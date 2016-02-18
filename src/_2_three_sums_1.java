import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by tobby on 16/2/17.
 */
public class _2_three_sums_1 {
    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && (nums[i] == nums[i - 1])) continue; // avoid duplicates
            for (int j = i + 1, k = nums.length - 1; j < k; ) {
                if (nums[i] + nums[j] + nums[k] == 0) {
                    list.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    j++;
                    k--;
                    while ((j < k) && (nums[j] == nums[j - 1])) j++;// avoid duplicates
                    while ((j < k) && (nums[k] == nums[k + 1])) k--;// avoid duplicates
                } else if (nums[i] + nums[j] + nums[k] > 0) k--;
                else j++;
            }
        }
        return list;
    }

    /**
     * 枚举[index], 取剩下两个求和等于-[index]
     * ok
     *
     * @param numbers
     * @param target
     * @return
     */
    public static List<List<Integer>> my_threeSum_enum(int[] numbers, int target) {
        Arrays.sort(numbers);
        int N = numbers.length;
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < N - 2; i++) {
            int current = numbers[i];
            if (i > 0 && current == numbers[i - 1]) {
                continue;
            }
            int start = i + 1;
            int end = N - 1;
            while (start < end) {
                int sum1 = numbers[start] + numbers[end];
                if (current + sum1 == target) {
                    result.add(Arrays.asList(current, numbers[start], numbers[end]));
                    ++start;
                    --end;
                    while (start < end && numbers[start] == numbers[start - 1]) start++;
                    while (start < end && numbers[end] == numbers[end + 1]) end--;

                } else if (current + sum1 > target) {
                    --end;

                } else {
                    ++start;

                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        List<List<Integer>> result = my_threeSum_enum(new int[]{7, -1, 14, -12, -8, 7, 2, -15, 8, 8, -8, -14, -4, -5, 7, 9, 11, -4, -15, -6, 1, -14, 4, 3, 10, -5, 2, 1, 6, 11, 2, -2, -5, -7, -6, 2, -15, 11, -6, 8, -4, 2, 1, -1, 4, -6, -15, 1, 5, -15, 10, 14, 9, -8, -6, 4, -6, 11, 12, -15, 7, -1, -9, 9, -1, 0, -4, -1, -12, -2, 14, -9, 7, 0, -3, -4, 1, -2, 12, 14, -10, 0, 5, 14, -1, 14, 3, 8, 10, -8, 8, -5, -2, 6, -11, 12, 13, -7, -12, 8, 6, -13, 14, -2, -5, -11, 1, 3, -6}, 0);
//        List<List<Integer>> result = threeSum(new int[]{0,0,0});
//        List<List<Integer>> result = my_threeSum_enum(new int[]{0, 0, 0}, 0);

    }
}
