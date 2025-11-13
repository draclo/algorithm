package programmers.괄호회전하기;

import java.util.*;

public class Solution {

    public String rotate(String s) {
        StringBuilder sb = new StringBuilder();
        Queue<Character> queue = new LinkedList<>();

        for (int i = 0; i < s.length(); i++) {
            queue.add(s.charAt(i));
        }

        Character temp = queue.poll();
        queue.offer(temp);
        while (!queue.isEmpty()) {
            sb.append(queue.poll());
        }
        return sb.toString();
    }

    public boolean valid(String s) {
        Map<Character, Character> charMap = new HashMap<>();
        charMap.put(']', '[');
        charMap.put('}', '{');
        charMap.put(')', '(');

        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (!charMap.containsKey(c)) {
                stack.push(c);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                if (stack.peek() == charMap.get(c)) {
                    stack.pop();
                }
            }
        }
        return stack.isEmpty();
    }


    public int solution(String s) {
        int result = 0;

        if (valid(s)) result++;

        String str = rotate(s);
        while (!s.equals(str)) {
            if (valid(str)) result++;
            str = rotate(str);
        }

        return result;

        /*int result = 0;
        Map<Character,Character> map = new HashMap<>();
        map.put(')','(');
        map.put(']','[');
        map.put('}','{');

        int n = s.length();
        s += s;

        A:for (int i = 0; i < n; i++) {
            Stack<Character> stack = new Stack<>();
            for (int j = i; j < n + i; j++) {
                char c = s.charAt(j);
                if (!map.containsKey(c)) {
                    stack.push(c);
                } else {
                    if (stack.isEmpty() || stack.pop() != map.get(c)){
                        continue A;
                    }
                }
            }

            if (stack.isEmpty()) {
                result++;
            }
        }

        return result;*/
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        String str = "[](){}";
        System.out.println(s.solution(str));
    }
}
