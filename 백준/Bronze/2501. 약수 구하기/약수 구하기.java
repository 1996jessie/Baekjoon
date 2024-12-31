import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        
        ArrayList<Integer> divisors = new ArrayList<>();
        
        for (int i = 1; i <= Math.sqrt(N); i++) {
            if (N % i == 0) {
                divisors.add(i);
                if (i != N / i) {
                    divisors.add(N / i);
                }
            }
        }
        
        Collections.sort(divisors);
        
        if (K <= divisors.size()) {
            System.out.println(divisors.get(K - 1));
        } else {
            System.out.println(0);
        }
    }
}
