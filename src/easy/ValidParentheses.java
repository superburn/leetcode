package easy;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;
//Description
//        Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
//
//        An input string is valid if:
//        Open brackets must be closed by the same type of brackets.
//        Open brackets must be closed in the correct order.
//        Note that an empty string is also considered valid.
//
//        Example 1:
//        Input: "()"
//        Output: true

//        Example 2:
//        Input: "()[]{}"
//        Output: true

//        Example 3:
//        Input: "(]"
//        Output: false

//        Example 4:
//        Input: "([)]"
//        Output: false

//        Example 5:
//        Input: "{[]}"
//        Output: true

//        Tags: Stack, String
public class ValidParentheses {
    public static void main(String[] args) {
        String str = "{[]}";
        isValid(str);
    }
    public void processTextNode(String str) {
        Deque<String> parenthesisStack = new ArrayDeque<>();

        StringTokenizer st = new StringTokenizer(str, " ()", true);
        while (st.hasMoreTokens()) {
            String token = st.nextToken();
            if (token.equals("(")) {
                parenthesisStack.push(token);
            }
            if (token.equals(")")) {
                if (parenthesisStack.isEmpty()) {
                    System.err.println("Warning: unbalanced parentheses.");
                }
                parenthesisStack.pop();
            }
        }
    }

    public static boolean isValid(String str) {
        char[] stack = new char[str.length() + 1];
        int top = 1;
        for (char c : str.toCharArray()) {
            if (c == '(' || c == '[' || c == '{') {
                stack[top++] = c;
            } else if (c == ')' && stack[--top] != '(') {
                return false;
            } else if (c == ']' && stack[--top] != '[') {
                return false;
            } else if (c == '}' && stack[--top] != '{') {
                return false;
            }
        }
        return top == 1;
    }
}
