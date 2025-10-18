package programmers.전화번호목록;

import java.util.Map;
import java.util.HashMap;

class Solution {
    public boolean solution(String[] phone_book) {
        Map<String, Integer> map = new HashMap<>();

        for(int i = 0; i<phone_book.length; i++){
            map.put(phone_book[i], i);
        }

        for(int i = 0; i<phone_book.length; i++){
            for(int j = 0; j<phone_book[i].length(); j++){
                if (map.containsKey(phone_book[i].substring(0, j))) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        String[] phone_book = new String[]{"119", "97674223", "1195524421"};

        System.out.print(s.solution(phone_book));
    }
}
