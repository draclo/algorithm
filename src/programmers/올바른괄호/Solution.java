package programmers.올바른괄호;

import java.util.*;

public class Solution {

    public boolean solution(String s) {

        /*int count = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (i == 0 && c == ')') {
                return false;
            }

            if (c == '(') {
                count++;
            } else {
                count--;
            }
        }*/

        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                stack.push(c);
            } else {
                if (stack.isEmpty() || stack.pop() == c) {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        String str = "";
        System.out.println(s.solution(str));
    }
}
