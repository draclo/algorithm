package programmers.기능개발;

import java.util.*;

public class Solution {

    //내 풀이
    /*public Integer[] solution(int[] progresses, int[] speeds) {

        Integer[] answer = {};
        List<Integer> list = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();

        for (int i=0; i<progresses.length; i++) {
            int day = (int)Math.ceil(((double)(100 - progresses[i])) / speeds[i]);
            queue.add(day);
        }

        Integer cur = queue.peek();
        int count = 0;
        while (queue.peek() != null) {
            Integer next = queue.peek();
            if (cur >= next) {
                count++;
                queue.poll();
                if (queue.isEmpty()) {
                    list.add(count);
                }
            } else {
                list.add(count);
                count = 0;
                cur = next;
            }
        }

        return list.toArray(answer);
    }*/

    //다른 사람 풀이
    /*public Integer[] solution(int[] progresses, int[] speeds) {
        Integer[] answer = {};
        List<Integer> list = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();

        for (int i=0; i<progresses.length; i++) {
            int day = (int)Math.ceil(((double)(100 - progresses[i])) / speeds[i]);

            if (!queue.isEmpty() && queue.peek() < day) {
                list.add(queue.size());
                queue.clear();
            }

            queue.offer(day);
        }

        list.add(queue.size());

        return list.toArray(answer);
    }*/

    // Map으로 리턴
    public Map<String, Object> solution(int[] progresses, int[] speeds) {
        Map<String, Object> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();

        for (int i=0; i<progresses.length; i++) {
            int day = (int)Math.ceil(((double)(100 - progresses[i])) / speeds[i]);

            if (!queue.isEmpty() && queue.peek() < day) {
                //list.add(queue.size());
                map.put(String.valueOf(queue.peek()), queue.size());
                queue.clear();
            }

            queue.offer(day);
        }

        map.put(String.valueOf(queue.peek()), queue.size());

        return map;
    }

    public static void main(String[] args) {
        programmers.기능개발.Solution s = new programmers.기능개발.Solution();
        int[] progresses = {93, 30, 55};
        int[] speeds = {1, 30, 5};
        //String[] completion = new String[]{"stanko", "ana", "mislav"};

        //System.out.print(Arrays.stream(s.solution(progresses, speeds)).toList());
        System.out.print(s.solution(progresses, speeds));
    }
}
