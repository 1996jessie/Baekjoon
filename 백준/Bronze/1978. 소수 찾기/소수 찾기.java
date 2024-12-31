import java.util.Scanner;

public class Main {
    
    public static boolean isPrime(int num) {
        if (num <= 1) {
            return false;
        }
        for (int i = 2; i * i <= num; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int count = 0;

        for (int i = 0; i < N; i++) {
            int num = sc.nextInt();
            if (isPrime(num)) {
                count++;
            }
        }

        System.out.println(count);
        sc.close();
    }
}
