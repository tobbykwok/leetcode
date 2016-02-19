/**
 * Created by tobby on 16/2/18.
 */
public class _5_multiply_strings {
    public static String multiply(String num1, String num2) {
        if (num1 == null || num2 == null || num1.length() == 0 || num2.length() == 0) {
            return null;
        }
        num1 = new StringBuilder(num1).reverse().toString();
        num2 = new StringBuilder(num2).reverse().toString();
        int[] result1 = new int[num1.length() + num2.length()];

        for (int i = 0; i < num1.length(); i++) {
            int a = num1.charAt(i) - '0';
            for (int j = 0; j < num2.length(); j++) {
                int b = num2.charAt(j) - '0';
                result1[i + j] += a * b;
            }
        }

        // 计算进位/加法
        StringBuilder result2 = new StringBuilder(result1.length);
        for (int i = 0; i < result1.length; i++) {
            int a = result1[i] % 10;
            int carrys = result1[i] / 10;
            if (i < result1.length - 1) {
                result1[i + 1] += carrys;
            }
            result2.insert(i, a);
        }

        int offset_end = result2.length() - 1;
        while (offset_end > 0 && result2.charAt(offset_end) == '0') {
            result2.deleteCharAt(offset_end--);
        }

        return result2.reverse().toString();
    }

    public static void main(String[] args) {
        String result = multiply("99", "99");
    }

}
