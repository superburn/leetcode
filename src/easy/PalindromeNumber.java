package easy;

//Description
//        Determine whether an integer is a palindrome. An integer is a palindrome when it reads the same backward as forward.
//
//        Example 1:
//        Input: 121
//        Output: true

//        Example 2:
//        Input: -121
//        Output: false
//        Explanation: From left to right, it reads -121. From right to left, it becomes 121-. Therefore it is not a palindrome.

//        Example 3:
//        Input: 10
//        Output: false
//        Explanation: Reads 01 from right to left. Therefore it is not a palindrome.

//        Follow up:
//        Coud you solve it without converting the integer to a string?
//
//        Tags: Math
public class PalindromeNumber {
    //思路 0
    //题意是判断一个有符号整型数是否是回文，也就是逆序过来的整数和原整数相同，
    //首先负数肯定不是，接下来我们分析一下最普通的解法，就是直接算出他的回文数，然后和给定值比较即可。
    public boolean isPalindrome(int x) {
        if (x < 0) return false;
        int copyX = x, reverse = 0;
        while (copyX > 0) {
            reverse = reverse * 10 + copyX % 10;
            copyX /= 10;
        }
        return x == reverse;
    }

    //思路 1
    //好好思考下是否需要计算整个长度，比如 1234321，其实不然，我们只需要计算一半的长度即可，
    //就是在计算过程中的那个逆序数比不断除 10 的数大就结束计算即可，但是这也带来了另一个问题，
    //比如 10 的倍数的数 10010，它也会返回 true，所以我们需要对 10 的倍数的数再加个判断即可，代码如下所示。
    public boolean isPalindrome2(int x) {
        if (x < 0 || x != 0 && x % 10 == 0) return false;
        int halfRes = 0;
        while (x > halfRes) {
            halfRes = halfRes * 10 + x % 10;
            x /= 10;
        }
        return halfRes == x || halfRes / 10 == x;
    }
}
