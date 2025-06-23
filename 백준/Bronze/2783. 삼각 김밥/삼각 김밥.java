import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        double minCost = Double.MAX_VALUE;

        double x = sc.nextDouble();
        double y = sc.nextDouble();
        minCost = Math.min(minCost, (x / y) * 1000);

        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            double xi = sc.nextDouble();
            double yi = sc.nextDouble();
            double cost = (xi / yi) * 1000;
            minCost = Math.min(minCost, cost);
        }

        System.out.printf("%.2f\n", minCost);
    }
}
