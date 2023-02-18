package commonPref;

import java.util.*;

public class LongestCommonPrefix {
    public static String longestCommonPrefix(String[] strs) {
        if (strs.length == 1)
            return strs[0];
        String str = strs[0];
        int count = 0;
        int minLength = str.length();
        for (int i = 1; i < strs.length; i++) {
            int tmpCount = 0;
            String tmp = strs[i];
            if (minLength > tmp.length())
                minLength = tmp.length();
            for (int j = 0; j < tmp.length(); j++) {
                if(j == str.length())
                    break;
                if (i > 1 && j == count){
                    break;
                }
                if(str.charAt(j) == tmp.charAt(j)) {
                        tmpCount = j + 1;
                }
//                else if (j < count){
//                    count = j;
//                }
                else
                    break;
            }
            if (i == 1)
                count = tmpCount;
            if (tmpCount < count)
                count = tmpCount;
            if (count == 0)
                break;
        }
        if (count == 0)
            return "";
        count = Math.min(minLength, count);
        System.out.println(count);
        return str.substring(0, count);
    }

    public static void main(String[] args) {
        String[] str = {"flower", "flow", "flight"};
        System.out.println(longestCommonPrefix(str));
//        Map<Integer, String> map = new HashMap<>();
//        map.put(1, "test");
//        System.out.println(map.computeIfPresent(1, (key, value) -> "newValue"));
//        System.out.println(map);
    }
}
