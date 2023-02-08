package polindrome;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

public class polindromeNumber {
    public static void main(String[] args) {
        int a = 1221;
        System.out.println(isPalindrome(a));
    }

    public static boolean isPalindrome(int x) {
        String str = String.valueOf(x);
        char[] chars = str.toCharArray();
        int size = chars.length;
        int start = 0;
        int end = chars.length - 1;
        while (size > 1){
            if (chars[start++] != chars[end--]){
                return false;
            }
            size--;
        }
        return true;
    }
}
