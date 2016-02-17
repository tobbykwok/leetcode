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

    public static int[] my_twoSum(int[] numbers, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < numbers.length; i++) {
            if(map.containsKey(target - numbers[i])){
                int[] r = {i, map.get(target-numbers[i])};
                return r;
            }
            map.put(numbers[i],i);
        }
        return new int[]{-1,-1};
    }

    public static void main(String[] args) {
        int[] result = my_twoSum(new int[]{1, 2, 3, 4, 5, 6, 7, 8}, 10);
        System.out.println(result[0]);
        System.out.println(result[1]);
    }
}
