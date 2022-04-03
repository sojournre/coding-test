package BFS;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 올바른 괄호의 갯수
 */

class Solution {
    class P {
        int open, close;

        public P(int open, int close) {
            this.open = open;
            this.close = close;
        }
    }

    public int solution(int n) {
        int answer = 0;
        Queue<P> stack = new LinkedList<>();
        stack.offer(new P(0, 0));
        while (!stack.isEmpty()) {
            P p = stack.poll();

            if (p.open > n) continue;
            if (p.open < p.close) continue;
            if (p.open + p.close == 2 * n) {
                answer++;
                continue;
            }

            stack.offer(new P(p.open + 1, p.close));
            stack.offer(new P(p.open, p.close + 1));
        }

        return answer;
    }
}
public class BFS {

    public static void main(String[] args) {
        int n = 2;
        Solution sol = new Solution();
        int s = sol.solution(n);
        System.out.println("s = " + s);
    }
}
