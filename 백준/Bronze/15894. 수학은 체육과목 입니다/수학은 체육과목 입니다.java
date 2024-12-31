import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();
        long perimeter = 4 * n;
        System.out.println(perimeter);
        sc.close();
    }
}
