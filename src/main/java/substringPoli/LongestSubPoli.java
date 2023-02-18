package substringPoli;

public class LongestSubPoli {

    //in progress
    public static void main(String[] args) {
        String s = "aac";
        System.out.println(longestPalindrome(s));
    }

    public static String longestPalindrome(String s) {
        if (s.equals("")) return "";
        if (s.length() == 1) return s;
        boolean even = s.length() % 2 == 0;
        String resS = s;
        if (even) {
            StringBuilder builder = new StringBuilder(s);
            for (int i = 0; i < s.length() * 2 + 1; i += 2) {
                builder.insert(i, "|");
            }
            System.out.println(builder);

           s = builder.toString();
        }
        int radius = 0;
        int maxLength = 0;
        char[] chars = s.toCharArray();
        int resCenter = 0;
        int resRadius = 0;

        for (int center = 0; center < chars.length; center++) {
            while ((center + (radius + 1)) < chars.length && (center - (radius + 1)) >= 0 && chars[center + (radius + 1)] == chars[center - (radius + 1)]) {
                radius++;
            }
            if (radius * 2 + 1 > maxLength) {
                resRadius = radius;
                resCenter = center;
                maxLength = radius * 2 + 1;
            }
            radius = 0;
        }
        if(resRadius == 0 && chars[chars.length-1] == chars[chars.length-2]) return resS.substring(resS.length()-2, resS.length());
        if(resRadius == 0 && chars[0] == chars[1]) return resS.substring(0, 2);
        if (resS.length() < 3 && resRadius == 1 ) return resS.substring(0, 1);
        if (even) {
            resCenter /=2;
            resRadius /=2;
            return resS.substring(resCenter - resRadius, resCenter + resRadius);
        }
        return resS.substring(resCenter - resRadius, resCenter + resRadius+1);
    }
}
