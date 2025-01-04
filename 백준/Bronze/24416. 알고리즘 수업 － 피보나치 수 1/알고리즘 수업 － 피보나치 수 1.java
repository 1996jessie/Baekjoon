import java.util.Scanner;

public class Main {
    public static int fi(int n) {
        if (n == 1 || n == 2) {
            return 1;
        } else if (n > 2) {
            return fi(n - 1) + fi(n - 2);
        }
        return 0;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(fi(n) + " " + (n - 2));
    }
}
