package programmers.크레인인형뽑기;

import java.util.Arrays;
import java.util.Stack;

public class Solution {

    public int solution(int[][] board, int[] moves) {

        int n = board.length;
        Stack<Integer>[] stack = new Stack[n];
        for (int i = 0; i < n; i++) {
            stack[i] = new Stack<>();
        }

        for (int i = 0; i < n; i++){
            for (int j = n - 1; j >= 0; j--) {
                if (board[j][i] == 0) {
                    break;
                } else {
                    stack[i].push(board[j][i]);
                }
            }
        }

        Stack<Integer> basket = new Stack<>();
        int result = 0;
        for (int i = 0; i < moves.length; i++) {
            int num = moves[i] - 1;
            if (stack[num].isEmpty()) {
                continue;
            }
            int pop = stack[num].pop();
            if (!basket.isEmpty() && pop == basket.peek()) {
                basket.pop();
                result += 2;
            }
            basket.push(pop);
        }

        return result;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[][] board = new int[5][5];
        board[0] = new int[]{0,0,0,0,0};
        board[1] = new int[]{0,0,1,0,3};
        board[2] = new int[]{0,2,5,0,1};
        board[3] = new int[]{4,2,4,4,2};
        board[4] = new int[]{3,5,1,3,1};

        int[] moves = new int[]{1,5,3,5,1,2,1,4};

        System.out.println(s.solution(board, moves));
    }
}
