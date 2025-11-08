package programmers.십진수에서이진수로;

import java.util.Stack;

public class Solution {

    public String solution(int decimal) {

        int mo = 0;
        Stack<Integer> stack = new Stack<>();

        while (mo != 1) {
            mo = decimal / 2;
            int na = decimal % 2;
            stack.push(na);
            decimal = mo;
        }
        stack.push(mo);
        //System.out.println(stack);

        /*while (decimal > 0) {
            int remainder = decimal % 2;
            stack.push(remainder);
            decimal /= 2;
        }*/

        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.solution(100));
    }
}
