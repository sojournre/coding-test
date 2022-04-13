import java.util.Scanner;

public class Basic100_1098 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int h = sc.nextInt();
        int w = sc.nextInt();
        int n = sc.nextInt();


        int[][] arr = new int[h + 1][w + 1];

        for (int i = 1; i <= n; i++) {
            int l = sc.nextInt();
            int d = sc.nextInt();
            int x = sc.nextInt();
            int y = sc.nextInt();

            for (int j = 1; j <= l; j++) {
                if (d == 1) {
                    arr[x + j - 1][y] = 1;
                } else arr[x][y + j - 1] = 1;
            }
        }

        for (int i = 1; i <= h; i++) {
            for (int j = 1; j <= w; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }

    }
}
