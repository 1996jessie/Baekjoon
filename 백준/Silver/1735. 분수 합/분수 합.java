import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int A1 = scanner.nextInt();
        int B1 = scanner.nextInt();
        int A2 = scanner.nextInt();
        int B2 = scanner.nextInt();
        
        int numerator = A1 * B2 + A2 * B1;
        int denominator = B1 * B2;
        
        int gcd = gcd(numerator, denominator);
        
        numerator /= gcd;
        denominator /= gcd;
        
        System.out.println(numerator + " " + denominator);
        
        scanner.close();
    }
    
    private static int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}
