package programmers.완주하지못한선수;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    public String solution(String[] participant, String[] completion) {
        String answer = "";

        Map<String, Integer> map = new HashMap<>();
        for (String name : participant) {
            map.put(name, map.getOrDefault(name, 0) + 1);
        }

        for (String name : completion) {
            map.put(name, map.get(name) - 1);
        }

        for (String name : map.keySet()) {
            if (map.get(name) != 0) {
                return name;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        String[] participant = new String[]{"mislav", "stanko", "mislav", "ana"};
        String[] completion = new String[]{"stanko", "ana", "mislav"};

        System.out.print(s.solution(participant, completion));
    }
}
