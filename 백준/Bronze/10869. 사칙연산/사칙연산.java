import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int A = scanner.nextInt();
        int B = scanner.nextInt();

        System.out.println(A + B);  // A+B
        System.out.println(A - B);  // A-B
        System.out.println(A * B);  // A*B
        System.out.println(A / B);  // A/B (몫)
        System.out.println(A % B);  // A%B (나머지)
        
        scanner.close();
    }
}
