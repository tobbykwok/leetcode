import java.util.ArrayList;

/**
 * Created by tobby on 16/2/20.
 */
public class _8_Longest_Substring_Without_Repeating_Characters {
    public static int lengthOfLongestSubstring(String s) {
        return -1;
    }
    public static int lengthOfLongestSubstring_1(String s) {
        int res = 0, left = 0;
        int prev[] = new int[300];

        // init prev array
        for (int i = 0; i < 300; ++i)
            prev[i] = -1;

        for (int i = 0; i < s.length(); ++i) {
            if (prev[s.charAt(i)] >= left)
                left = prev[s.charAt(i)] + 1;
            prev[s.charAt(i)] = i;
            if (res < i - left + 1)
                res = i - left + 1;
        }
        return res;
    }

    public static int my_lengthOfLongestSubstring(String s){
        int result = 0;
        int start = 0;
return 0;
    }

    public static void main(String[] args) {
        int result= my_lengthOfLongestSubstring("1213456");
    }
}
