package programmers.짝지어제거하기;

import java.util.*;

public class Solution {

    public int solution(String s) {

        /*Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (!stack.isEmpty() && c == stack.peek()) {
                stack.pop();
            } else {
                stack.push(c);
            }
        }

        return stack.isEmpty() ? 1 : 0;*/

        Stack<Character> stack = new Stack<>();

        for(char c : s.toCharArray()){
            if(stack.size() == 0){
                stack.push(c);
            }
            else if(stack.peek() == c){
                stack.pop();
            }
            else{
                stack.push(c);
            }
        }

        return stack.size() > 0 ? 0 : 1;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.solution("baabaaa"));
    }
}
