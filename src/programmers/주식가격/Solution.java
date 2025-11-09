package programmers.주식가격;

import java.util.*;

public class Solution {

    public int[] solution(int[] prices) {

        /*int[] result = new int[prices.length];

        for (int i = 0; i < prices.length; i++) {
            Stack<Integer> stack = new Stack<>();

            for (int j = i + 1; j < prices.length; j++) {
                if (prices[i] <= prices[j]) {
                    stack.push(prices[j]);
                }
            }

            result[i] = stack.size();
            stack.clear();
        }

        return result;*/


        int n = prices.length;
        int[] array = new int[n];

        Stack<Integer> stack = new Stack<>();
        stack.add(0);

        for (int i = 1; i < n; i++) {
            while (!stack.isEmpty() && prices[i] < prices[stack.peek()]) {
                int before = stack.pop();
                array[before] = i - before;
            }
            stack.push(i);
        }

        while (!stack.isEmpty()) {
            int num = stack.pop();
            int result = n - num - 1;
            array[num] = result;
        }

        return array;



        /*int len = prices.length;
        int[] answer = new int[len];
        int i, j;
        for (i = 0; i < len; i++) {
            for (j = i + 1; j < len; j++) {
                answer[i]++;
                if (prices[i] > prices[j])
                    break;
            }
        }
        return answer;*/
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] prices = new int[]{1,6,9,5};
        System.out.println(Arrays.toString(s.solution(prices)));
    }
}
