package easy;

//Description
//        The count-and-say sequence is the sequence of integers with the first five terms as following:
//
//        1.     1
//        2.     11
//        3.     21
//        4.     1211
//        5.     111221
//        1 is read off as "one 1" or 11.
//
//        11 is read off as "two 1s" or 21.
//
//        21 is read off as "one 2, then one 1" or 1211.
//
//        Given an integer n, generate the nth term of the count-and-say sequence.
//
//        Note: Each term of the sequence of integers will be represented as a string.
//
//        Example 1:
//        Input: 1
//        Output: "1"

//        Example 2:
//        Input: 4
//        Output: "1211"
//        Tags: String

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class CountAndSay {
    public static void main(String[] args) {
        //System.out.println(myCountAndSay(4));
        System.out.println(countAndSay(4));
     }

    public static String myCountAndSay(int num) {
        String str = "";

        for (int j = 1; j <= num; j++) {
            if (j == 1) {
                str = "1";
            } else {
                Map map = new LinkedHashMap<String, Integer>();
                for (int i = 0; i < str.length(); i++) {
                    if (map.get(str.charAt(i)) != null) {
                        map.put(str.charAt(i), (Integer) map.get(str.charAt(i)) + 1);
                    } else {
                        map.put(str.charAt(i), 1);
                    }
                }
                Set<Map.Entry> entries = map.entrySet();
                str = "";
                for (Map.Entry entry : entries) {
                    str += entry.getValue() + "" + entry.getKey() + "";
                }
            }
            System.out.println("num=" + j + ",str=" + str);
        }
        return str;
    }

    public static String countAndSay(int n) {
        String str = "1";
        while (--n > 0) {
            int times = 1;
            StringBuilder sb = new StringBuilder();
            char[] charArr = str.toCharArray();
            int len = charArr.length;
            for (int i = 1; i < len; i++) {
                if (charArr[i - 1] == charArr[i]) {
                    times++;
                } else {
                    sb.append(times).append(charArr[i - 1]);
                    times = 1;
                }
            }
            str = sb.append(times).append(charArr[len - 1]).toString();
        }
        return str;
    }
}
