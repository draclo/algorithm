package programmers.두개의수로특정값만들기;

import java.util.*;

public class Solution {

    public boolean solution(int[] arr, int target) {

        Set<Integer> hashSet = new HashSet<>();

        for (int num : arr) {
            if (hashSet.contains(target - num)) {
                return true;
            }
            hashSet.add(num);
        }

        return false;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] arr = {1,2,3,4,8};
        int target = 6;
        System.out.print(s.solution(arr, target));
    }
}
