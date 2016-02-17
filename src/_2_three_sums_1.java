import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by tobby on 16/2/17.
 */
public class _2_three_sums_1 {
    /**
     * 枚举[index], 取剩下两个求和等于-[index]
     *
     * @param numbers
     * @param target
     * @return
     */
    public static List<List<Integer>> my_threeSum_enum(int[] numbers, int target) {
        Arrays.sort(numbers);
        int N = numbers.length;
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < N - 1; i++) {
            int current = numbers[i];
            int start = i + 1;
            int end = N - 1;
            while (start < end) {
                int sum1 = numbers[start] + numbers[end];
                if (current + sum1 == target) {
                    Integer[] t = {current, numbers[start], numbers[end]};
                    Arrays.sort(t);
                    ArrayList<Integer> t_l = new ArrayList<>(3);
                    for (int j = 0; j < 3; j++) {
                        t_l.add(j, t[j]);
                    }
                    if (!result.contains(t_l)) {
                        result.add(t_l);
                    }
                    ++start;
                    --end;
                } else if (current + sum1 < target) {
                    ++start;
                } else {
                    --end;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        List<List<Integer>> result = my_threeSum_enum(new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 10, 23, 431, 3, 4, 522, 3, -1, -5, -392, 2, -3, -11}, 0);
    }
}
