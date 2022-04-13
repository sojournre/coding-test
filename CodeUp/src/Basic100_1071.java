import java.util.Scanner;

public class Basic100_1071 {
    public static void main(String[] args) {
        int a, b;
        Scanner sc = new Scanner(System.in);
        a = sc.nextInt();
        b = sc.nextInt();

        System.out.println(a + b);
        System.out.println(a - b);
        System.out.println(a * b);
        System.out.println(a / b);
        System.out.println(a % b);
//        System.out.println((double) a / b);
        double c = (double) a / b;
//        System.out.println("c = " + c);
//        System.out.println(Math.round((double) a / b * 100) / 100.0);
        System.out.println(String.format("%.2f", c));

    }
}
