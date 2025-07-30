import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int S = sc.nextInt();
        int K = sc.nextInt();

        int q = S / K;
        int r = S % K;

        long result = 1;
        for (int i = 0; i < K - r; i++) {
            result *= q;
        }
        for (int i = 0; i < r; i++) {
            result *= (q + 1);
        }

        System.out.println(result);
    }
}
