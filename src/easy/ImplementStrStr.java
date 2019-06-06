package easy;

//Description
//        Implement strStr().
//        Return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.
//
//        Example 1:
//        Input: haystack = "hello", needle = "ll"
//        Output: 2

//        Example 2:
//        Input: haystack = "aaaaa", needle = "bba"
//        Output: -1

//        Clarification:
//        What should we return when needle is an empty string? This is a great question to ask during an interview.
//        For the purpose of this problem, we will return 0 when needle is an empty string. This is consistent to C's strstr() and Java's indexOf().
//
//        Tags:** Two Pointers, String
public class ImplementStrStr {
    public static void main(String[] args) {
        System.out.println(implementStrStr("hello","ll"));
    }
    public static int implementStrStr(String str, String needle) {
        int needleLen = needle.length();
        int strLen = str.length();
        if (needleLen == 0) return 0;
        for (int i = 0; i <= strLen - needleLen; i++) {
            if (str.substring(i, i+needleLen).equals(needle)) {
                return i;
            }
        }
        return -1;
    }

    public static int strStr(String haystack, String needle) {
        int l1 = haystack.length();
        int l2 = needle.length();
        if (l1 < l2) return -1;
        for (int i = 0; ; i++) {
            if (i + l2 > l1) return -1;
            for (int j = 0; ; j++) {
                if (j == l2) return i;
                if (haystack.charAt(i + j) != needle.charAt(j)) break;
            }
        }
    }
}
