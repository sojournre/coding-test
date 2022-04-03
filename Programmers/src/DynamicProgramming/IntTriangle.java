package DynamicProgramming;

/**
 * 정수 삼각형
 * */
class Solution {
    public int solution(int[][] triangle) {
        int answer = 0;

        // 밑에서 위로 계산하는 방법
        for (int i = triangle.length -2; i >= 0; i--) {
            for (int j = 0; j < triangle[i].length; j++) {
                int left = triangle[i][j] + triangle[i + 1][j];
                int right = triangle[i][j] + triangle[i + 1][j + 1];
                triangle[i][j] = Math.max(left, right);
            }
        }
        return triangle[0][0];

        // 위에서 밑으로 계산하는 방법
//        for (int i = 1; i < triangle.length; i++) {
//            for (int j = 0; j < triangle[i].length; j++) {
//                if (j == 0) {
//                    triangle[i][j] = triangle[i][j] + triangle[i - 1][j];
//                } else if (i == j) {
//                    triangle[i][j] = triangle[i][j] + triangle[i - 1][j - 1];
//                } else {
//                int left = triangle[i][j] + triangle[i - 1][j - 1];
//                int right = triangle[i][j] + triangle[i - 1][j];
//                triangle[i][j] = Math.max(left, right);
//                }
//
//                answer = Math.max(answer, triangle[i][j]);
//            }
//        }
//        return answer;
    }
}
public class IntTriangle {
    public static void main(String[] args) {
        int[][] n = {{7}, {3, 8}, {8, 1, 0}, {2, 7, 4, 4}, {4, 5, 2, 6, 5}};
        Solution sol = new Solution();
        int s = sol.solution(n);
        System.out.println("s = " + s);
    }
}
