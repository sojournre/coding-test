import java.util.Scanner;

public class Basic100_1085 {
    public static void main(String[] args) {
        int h, b, c, s;
        Scanner sc = new Scanner(System.in);
        h = sc.nextInt();
        b = sc.nextInt();
        c = sc.nextInt();
        s = sc.nextInt();

        double i = (double) h * b * c * s / (8 * 1024 * 1024);
//        System.out.println(i);
        System.out.println(String.format("%.1f", i) + " MB");
//        System.out.println(String.format("%.2f", i));
    }
}
