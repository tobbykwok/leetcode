/**
 * Created by tobby on 16/2/26.
 */
public class quicksort_2<Value extends Comparable> {
    public int partation(Value[] s, int l, int r){
        Value x = s[l];

        while(l<r){
            while(l<r && s[r].compareTo(x)>0) --r;
            if(l<r) {
                exchange(s, l, r);
            }
            while(l<r && s[l].compareTo(x)<0) ++l;
            if(l<r){
                exchange(s, l, r);
            }
        }

        return l;
    }

    public void sort(Value[] s, int l, int r ){
        if(l<r){
            int i = this.partation(s, l, r);
            this.sort(s, l , i-1);
            this.sort(s, i+1 ,r);
        }
    }

    private void exchange(Value[] s, int a, int b){
        Value t = s[a];
        s[a] = s[b];
        s[b] = t;
    }

    public static void main(String[] args) {
        quicksort_2<Integer> qs = new quicksort_2<>();
        Integer[] source = new Integer[]{3, 0, 4, 9, 2, 1, 6, 5, 8, 7};
//        int l = qs.partation(source, 0, source.length - 1);
        qs.sort(source, 0, source.length - 1);
    }

}
