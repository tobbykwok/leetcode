import java.util.Arrays;

/**
 * Created by tobby on 16/2/19.
 */
public class _6_add_binary_1 {
    //艹
    public static String addBinary(String a, String b) {
        if (a == null || b == null || a.length() == 0 || b.length() == 0) {
            return null;
        }
        int[] result = new int[a.length() + b.length()];
        int num1_pos = a.length() - 1;
        int num2_pos = b.length() - 1;
        int num1 = a.charAt(num1_pos) - '0';
        int num2 = b.charAt(num2_pos) - '0';
        int pos = result.length - 1;
        int carry = 0;
        while (num1_pos >= 0 || num2_pos >= 0 || carry > 0) {
            carry = (result[pos] + num1 + num2) / 2;
            result[pos] = (num1 + num2 + result[pos]) % 2;
            if(pos> 0) {
                result[--pos] = carry;
            }
            num1 = --num1_pos >= 0 ? a.charAt(num1_pos) - '0' : 0;
            num2 = --num2_pos >= 0 ? b.charAt(num2_pos) - '0' : 0;
        }
        StringBuilder sb = new StringBuilder(result.length);
        for (int j = 0; j < result.length; j++) {
            if (result[j] == 0 && sb.length() == 0) {
                continue;
            }
            sb.append(result[j]);
        }
        if (sb.length() == 0) {
            return "0";
        } else {
            return sb.toString();
        }
    }

    public static void main(String[] args) {
        String result = addBinary("1010", "1011");
    }
}
