package FinalTest;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 세균 증식
 * */
class Solution1 {

    public class P{
        int x, y;

        P(int x, int y){
            this.x = x;
            this.y = y;
        }

        boolean isValid(int r, int c){
            if(x < 0 || x >= r ) return false;
            if(y < 0 || y >= c) return false;
            return true;
        }
    }

    public int[][] solution(int rows, int columns, int max_virus, int[][] queries) {

        int[][] answer = new int[rows][columns];
        int len = queries.length;

        for(int i=0; i<len; i++){
            int row = queries[i][0] - 1;
            int col = queries[i][1] - 1;

            if(answer[row][col] < max_virus){
                answer[row][col]++;
            }else{
                bfs(answer, rows, columns, max_virus, queries[i]);
            }
        }

        return answer;
    }

    public void bfs(int[][] arr, int rows, int columns, int max_virus, int[] query){
        Queue<P> queue = new LinkedList<>();
        boolean[][] v = new boolean[rows][columns];

        int row = query[0] - 1;
        int col = query[1] - 1;

        queue.offer(new P(row, col));
        v[row][col] = true;

        while(!queue.isEmpty()){
            P current = queue.poll();

            final int[][] moving = {{0, -1}, {0, 1}, {1, 0}, {-1, 0}};
            for(int i=0; i<moving.length; i++){
                P moved = new P(current.x + moving[i][0], current.y + moving[i][1]);
                if(!moved.isValid(rows, columns)) continue;
                if(v[moved.x][moved.y]) continue;
                if(arr[moved.x][moved.y] < max_virus) {
                    arr[moved.x][moved.y]++;
                    v[moved.x][moved.y] = true;
                }else{
                    v[moved.x][moved.y] = true;
                    queue.offer(moved);
                }
            }
        }
    }
}

public class Final1a {
    public static void main(String[] args) {
        int rows = 3;
        int columns = 4;
        int max_virus = 2;
        int[][] queries = {{3,2},{3,2},{2,2},{3,2},{1,4},{3,2},{2,3},{3,1}};
        Solution1 sol = new Solution1();
        int[][] s = sol.solution(rows, columns, max_virus, queries);
        System.out.println("s = " + Arrays.deepToString(s)); // result = [[0,2,1,1],[2,2,2,1],[2,2,2,1]]
    }
}
