import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        double x1 = sc.nextDouble();
        double y1 = sc.nextDouble();
        double r1 = sc.nextDouble();
        double x2 = sc.nextDouble();
        double y2 = sc.nextDouble();
        double r2 = sc.nextDouble();

        double d = Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));

        if (d >= r1 + r2) {
            System.out.println("0.000");
        } else if (d <= Math.abs(r1 - r2)) {
            double area = Math.PI * Math.min(r1, r2) * Math.min(r1, r2);
            System.out.printf("%.3f\n", area);
        } else {
            double part1 = Math.pow(r1, 2) * Math.acos((d * d + r1 * r1 - r2 * r2) / (2 * d * r1));
            double part2 = Math.pow(r2, 2) * Math.acos((d * d + r2 * r2 - r1 * r1) / (2 * d * r2));
            double part3 = 0.5 * Math.sqrt((-d + r1 + r2) * (d + r1 - r2) * (d - r1 + r2) * (d + r1 + r2));

            double area = part1 + part2 - part3;
            System.out.printf("%.3f\n", area);
        }
    }
}
