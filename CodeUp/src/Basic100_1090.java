import java.util.Scanner;

public class Basic100_1090 {
    public static void main(String[] args) {
        int a, r, n;
        Scanner sc = new Scanner(System.in);
        a = sc.nextInt();
        r = sc.nextInt();
        n = sc.nextInt();

        long v = (long) (a * Math.pow(r, n - 1));

        System.out.println(v);
    }
}
