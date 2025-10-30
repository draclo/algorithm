package programmers.유연근무제;

public class Solution {

    public int solution(int[] schedules, int[][] timelogs, int startday) {
        int count = schedules.length;
        for (int i=0; i<schedules.length; i++) {
            //ex) 8시 55분 + 10분 = 9시 5분
            int hopeTime = schedules[i] + 10;
            if (hopeTime % 100 >= 60) {
                hopeTime += 100;
                hopeTime -= 60;
            }

            for (int j=0; j<timelogs[i].length; j++) {
                int exclude = (j + startday) % 7;
                if (exclude != 0 && exclude != 6) {
                    if (hopeTime < timelogs[i][j]) {
                        count--;
                        break;
                    }
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] schedules = new int[]{700, 800, 1100};
        int[][] timelogs = new int[][]{{710, 2359, 1050, 700, 650, 631, 659}, {800, 801, 805, 800, 759, 810, 809}, {1105, 1001, 1002, 600, 1059, 1001, 1100}};
        int startday = 5;

        System.out.print(s.solution(schedules, timelogs, startday));
    }
}
