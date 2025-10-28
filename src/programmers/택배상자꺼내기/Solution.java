package programmers.택배상자꺼내기;

import java.util.Arrays;

class Solution {
    public int solution(int n, int w, int num) {
        int answer = 0;

        int height = (int) Math.ceil(1.0 * n / w);
        int[][] arr = new int[height][w];
        int count = 0;
        int ht = 0;
        int wd = 0;
        for (int i = 0; i < height; i++) {
            if (i % 2 == 0) {
                for (int j = 0; j < w; j++) {
                    if (count >= n) break;
                    arr[i][j] = ++count;

                    if (count == num) {
                        ht = i;
                        wd = j;
                    }
                }
            } else {
                for (int j = w - 1; j >= 0; j--) {
                    if (count >= n) break;
                    arr[i][j] = ++count;

                    if (count == num) {
                        ht = i;
                        wd = j;
                    }
                }
            }
        }
        System.out.println(Arrays.deepToString(arr));

        for (int i = ht; i < height; i++) {
            if (arr[i][wd] != 0) {
                answer++;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.solution(10, 4, 4));
    }
}
