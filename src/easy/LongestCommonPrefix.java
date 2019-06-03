package easy;

//Description
//        Write a function to find the longest common prefix string amongst an array of strings.
//        If there is no common prefix, return an empty string "".
//
//        Example 1:
//        Input: ["flower","flow","flight"]
//        Output: "fl"

//        Example 2:
//        Input: ["dog","racecar","car"]
//        Output: ""

//        Explanation: There is no common prefix among the input strings.
//        Note:
//        All given inputs are in lowercase letters a-z.
//
//        Tags: String
public class LongestCommonPrefix {
    public static void main(String[] args) {
        String[] strings = {"flower", "flow", "flight"};
        System.out.println(myCommonPrefix(strings));
        System.out.println(longestCommonPrefix(strings));
    }

    public static String myCommonPrefix(String[] strings) {
        String first = strings[0];
        String commonPrefix = "";
        String prefix = "";
        outer:
        for (int i = 0; i < first.length(); i++) {
            prefix = first.substring(0, i + 1);
            inner:
            for (int j = 0; j < strings.length; j++) {
                if (strings[j].indexOf(prefix) < 0) {
                    break outer;
                }
            }
            commonPrefix = prefix;
        }
        return commonPrefix;
    }

    //题意是让你从字符串数组中找出公共前缀，我的想法是找出最短的那个字符串的长度 minLen，
    // 然后在 0...minLen 的范围比较所有字符串，如果比较到有不同的字符，那么直接返回当前索引长度的字符串即可，
    // 否则最后返回最短的字符串即可。

    public static String longestCommonPrefix(String[] strings) {
        int len = strings.length;
        if (len == 0) return "";
        int minLen = 0x7fffffff;
        for (String string : strings) minLen = Math.max(minLen, string.length());
        for (int i = 0; i < minLen; i++) {
            for (int j = 0; j < len; j++) {
                if (strings[0].charAt(i) != strings[j].charAt(i)) {
                    return strings[0].substring(0, j);
                }
            }
        }
        return strings[0].substring(0, minLen);
    }
}
