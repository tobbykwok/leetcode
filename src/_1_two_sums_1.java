import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/**
 * Created by tobby on 16/2/17.
 */
public class _1_two_sums_1 {
    public static int[] twoSum(int[] numbers, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < numbers.length; i++) {
            int x = numbers[i];
            if (map.containsKey(target - x)) {
                int[] res = {map.get(target - x), i};
                return res;
            }
            map.put(x, i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }

    public static int[] my_twoSum_hash(int[] numbers, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < numbers.length; i++) {
            if (map.containsKey(target - numbers[i])) {
                int t = map.get(target - numbers[i]);
                int[] r = {t <= i ? t : i, t >= i ? t : i};
                return r;
            }
            map.put(numbers[i], i);
        }
        return new int[]{-1, -1};
    }

    public static ArrayList<int[]> my_twoSum_pointer(int[] numbers, int target) {
        Arrays.sort(numbers);
        int start = 0;
        int end = numbers.length - 1;
        ArrayList<int[]> result = new ArrayList<>();

        while (start < end) {
            int sum = numbers[start] + numbers[end];
            if (sum == target) {
                int[] temp = {start, end};
                if(!result.contains(temp)){
                    result.add(temp);
                    ++start;
                    --end;
                }
            } else if (sum < target) {
                ++start;
            } else {
                --end;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        ArrayList<int[]>result = my_twoSum_pointer(new int[]{1, 2, 3, 4, 5, 6, 7, 8}, 10);
    }
}
