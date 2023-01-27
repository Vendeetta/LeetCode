package longestSub;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Stream;

public class LongestSub {

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("anviaj"));
    }

    public static int lengthOfLongestSubstring(String s) {
        int count = 0;
        int tmp = 0;
        int j = 0;
        Set<Character> chars = new HashSet<>();
        char[] string = s.toCharArray();
        for (int i = j; i < string.length; i++) {
            char ch = string[i];
            tmp++;
            chars.add(string[i]);
            if (i == string.length - 1){
                break;
            }
            if (ch == string[i + 1] || chars.contains(string[i + 1])) {
                if (tmp > count) {
                    count = tmp;
                }
                tmp=0;
                chars = new HashSet<>();
                i = j++;
            }
        }
        if (tmp > count) {
            count = tmp;
        }
        return count;
    }
}
