package FinalTest;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 세균 증식
 * */
class Solution {
    class Position {
        int x, y;

        Position(int x, int y) {
            this.x = x;
            this.y = y;
        }

        boolean isValid(int width, int height) {
            if (x < 0 || x >= width) return false;
            if (y < 0 || y >= height) return false;
            return true;
        }
    }

    public int[][] solution(int rows, int columns, int max_virus, int[][] queries) {
        int[][] answer = new int[rows][columns];

        for (int i = 0; i < queries.length; i++) {
            int row = queries[i][0] - 1;
            int col = queries[i][1] - 1;

            if (answer[row][col] < max_virus) {
                answer[row][col]++;
            }else {
                Queue<Position> queue = new LinkedList<>();
                boolean[][] v = new boolean[rows][columns];

                queue.offer(new Position(row, col));
                v[row][col] = true;

                while (!queue.isEmpty()) {
                    Position current = queue.poll();

                    final int[][] moving = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};
                    for (int j = 0; j < moving.length; j++) {
                        Position moved = new Position(current.x + moving[j][0], current.y + moving[j][1]);
                        if (!moved.isValid(rows, columns)) continue;
                        if (v[moved.x][moved.y]) continue;
                        if (answer[moved.x][moved.y] < max_virus) {
                            answer[moved.x][moved.y]++;
                        }else {
                            queue.offer(moved);
                        }
                        v[moved.x][moved.y] = true;
                    }
                }
            }
        }

        return answer;
    }
}

public class Final1 {
    public static void main(String[] args) {
        int rows = 3;
        int columns = 4;
        int max_virus = 2;
        int[][] queries = {{3,2},{3,2},{2,2},{3,2},{1,4},{3,2},{2,3},{3,1}};
        Solution sol = new Solution();
        int[][] s = sol.solution(rows, columns, max_virus, queries);
        System.out.println("s = " + Arrays.deepToString(s)); // result = [[0,2,1,1],[2,2,2,1],[2,2,2,1]]
    }
}
