/**
 * Created by tobby on 16/3/4.
 */
public class InsertionSort_ex1<Value extends Comparable> {
    public void sort(Value[] s) {
        int j = 1;
        while (j < s.length) {
            Value val = s[j];
            int i = j++;
            for (; i > 0 && (val.compareTo(s[i - 1]) < 0); i--) {
                s[i] = s[i - 1];
            }
            s[i] = val;
        }
    }

    public static void main(String[] args) {
        Integer[] source = new Integer[]{3, 2, 6, 4, 0, 1, 9, 8, 6, 3, 5};
        InsertionSort_ex1 S = new InsertionSort_ex1();
        S.sort(source);

    }
}
