import java.util.Scanner;
import java.math.BigInteger;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        BigInteger A = scanner.nextBigInteger();
        BigInteger B = scanner.nextBigInteger();
        BigInteger C = scanner.nextBigInteger();

        BigInteger sum = A.add(B).add(C);

        System.out.println(sum);

        scanner.close();
    }
}
