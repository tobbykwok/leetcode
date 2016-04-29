/**
 * Created by tobby on 16/2/26.
 */
public class quicksort_1<Value extends Comparable> {
    /*
    int AdjustArray(int s[], int l, int r) //返回调整后基准数的位置
{
    int i = l, j = r;
    int x = s[l]; //s[l]即s[i]就是第一个坑
    while (i < j)
    {
        // 从右向左找小于x的数来填s[i]
        while(i < j && s[j] >= x)
            j--;
        if(i < j)
        {
            s[i] = s[j]; //将s[j]填到s[i]中，s[j]就形成了一个新的坑
            i++;
        }

        // 从左向右找大于或等于x的数来填s[j]
        while(i < j && s[i] < x)
            i++;
        if(i < j)
        {
            s[j] = s[i]; //将s[i]填到s[j]中，s[i]就形成了一个新的坑
            j--;
        }
    }
    //退出时，i等于j。将x填到这个坑中。
    s[i] = x;

    return i;
}

     */

    /*
        基本思想是：
        1．先从数列中取出一个数作为基准数。
        2．分区过程，将比这个数大的数全放到它的右边，小于或等于它的数全放到它的左边。
        3．再对左右区间重复第二步，直到各区间只有一个数。
     */

    public int partation(Value[] source, int start, int end) {
        int p_left = start, p_right = end;
        Value x = source[start];

        while (p_left < p_right) {
            while (p_left < p_right && source[p_right].compareTo(x) > 0) {
                p_right--;
            }
            if (p_left < p_right) {
                source[p_left] = source[p_right];
                p_left++;
            }

            while (p_left < p_right && source[p_left].compareTo(x) < 0) {
                p_left++;
            }
            if (p_left < p_right) {
                source[p_right] = source[p_left];
                p_right--;
            }
        }

        source[p_left] = x;
        return p_left;

    }

    public void sort(Value[] source, int left, int right) {
        if (left < right) {
            int i = this.partation(source, left, right);
            this.sort(source, left, i - 1);
            this.sort(source, i + 1, right);
        }

    }

    public static void main(String[] args) {
        quicksort_1<Integer> qs = new quicksort_1<>();
        Integer[] source = new Integer[]{3, 0, 4, 9, 2, 1, 6, 5, 8, 7};
//        qs.sort(source, 0, source.length - 1);
        qs.partation(source, 0, source.length - 1);

    }


}
