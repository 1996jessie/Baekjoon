import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int bYear = scanner.nextInt();

        int gYear = bYear - 543;

        System.out.println(gYear);

        scanner.close();
    }
}
