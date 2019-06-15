package medium;

//给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
//
//        示例 1：
//        输入: "babad"
//        输出: "bab"
//        注意: "aba" 也是一个有效答案。

//        示例 2：
//        输入: "cbbd"
//        输出: "bb"

//解决这类 “最优子结构” 问题，考虑使用 “动态规划”。我们只要找准 “状态” 的定义和 “状态转移方程” 就可以了。
//        在下面的说明中，s[i, j] 表示原始字符串的一个子串，i、j 分别是索引，使用左闭、右闭区间表示左右端点可以取到。

//        1、定义状态，这里动态规划的数组是二维的。
//        dp[i][j] 表示子串 s[i, j]（包括区间左右端点）是否构成回文串，是一个二维布尔型数组。
//        即如果子串 s[i, j] 是回文串，那么 dp[i][j] = true。
//
//        2、状态转移。
//        如果 s[i, j] 是一个回文串，例如 “abccba”，那么 s[i + 1, j - 1] 也一定是一个回文串，
//        即如果 dp[i][j] == true 成立，一定有 dp[i + 1][j - 1] = true。
//        反过来，如果已知 dp[i + 1, j - 1]，就可以通过比较 s[i] 和 s[j] 并且考虑 dp[i + 1, j - 1]
//        进而得到 dp[i, j]。
//        整理一下：dp[i, j] = (s[i] == s[j] and dp[i + 1, j - 1])，
//        不过，此时我们要保证 [i + 1, j - 1] 能够形成区间，因此有 i + 1 <= j - 1，整理得 i - j <= -2，
//        或者 j - i >= 2。
//
//        作者：liweiwei1419
//        链接：https://leetcode-cn.com/problems/two-sum/solution/zhong-xin-kuo-san-dong-tai-gui-hua-by-liweiwei1419/
//        来源：力扣（LeetCode）
//        著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。

public class LongestPalindrome {
    public String longestPalindrome(String str) {
        if (str.length() == 0) {
            return str;
        }
        int len = str.length();
        boolean[][] dp = new boolean[len][len];
        String longestPalindromeStr = str.substring(0, 1);
        for (int i = 0; i < len; i++) {
            for (int j = i; j >= 0; j--) {
                if (str.charAt(i) == str.charAt(j) && (i <= j + 2 || dp[j + 1][i - 1])) {
                    dp[j][i] = true;
                    if (i - j + 1 > longestPalindromeStr.length()) {
                        longestPalindromeStr = str.substring(j, i + 1);
                    }
                }
            }
        }
        return longestPalindromeStr;
    }

    //中心扩散
}
