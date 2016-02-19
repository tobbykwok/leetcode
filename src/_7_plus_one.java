/**
 * Created by tobby on 16/2/20.
 */
public class _7_plus_one {
    public static int[] plusOne(int[] digits) {
        int carry = 0;
        digits[digits.length - 1] += 1;
        for(int i = digits.length - 1; i >= 0;i--){
            if(digits[i] >= 10 && i>0){
                digits[i] -= 10;
                digits[i-1] += 1;
            }else if(i == 0 && digits[i] >= 10){
                digits[i] -= 10;
                carry = 1;
            }
        }
        if(carry == 1){
            int[] a = new int[digits.length +1];
            for(int i = 0;i<digits.length;i++){
                a[i+1] = digits[i];
            }
            a[0] = carry;
            return a;
        }else{
            return digits;
        }
    }

    public static void main(String[] args) {
        int[] result = plusOne(new int[]{9,9,9});
    }
}
