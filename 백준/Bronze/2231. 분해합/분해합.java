import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int result = 0;
        
        for (int M = Math.max(1, N - 54); M < N; M++) {
            int sum = M;
            int temp = M;
            
            while (temp > 0) {
                sum += temp % 10;
                temp /= 10;
            }
            
            if (sum == N) {
                result = M;
                break;
            }
        }
        
        System.out.println(result);
    }
}
