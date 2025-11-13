package programmers.요세푸스;

import java.util.*;

public class Solution {

    public int solution(int N, int K) {

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            queue.offer(i);
        }

        while (queue.size() > 1) {

            for (int i = 0; i < K; i++) {
                int num = queue.poll();
                if (i != K - 1) {
                    queue.offer(num);
                }
            }
        }

        return queue.poll();
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.print(s.solution(5, 3));
    }
}
