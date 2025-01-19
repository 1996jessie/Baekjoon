import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] scores = new int[10];
        int sum = 0;
        
        for (int i = 0; i < 10; i++) {
            scores[i] = sc.nextInt();
        }

        int closest = 0;
        for (int i = 0; i < 10; i++) {
            sum += scores[i];
            if (Math.abs(100 - closest) >= Math.abs(100 - sum)) {
                closest = sum;
            }
            if (sum > 100) {
                break;
            }
        }

        System.out.println(closest);
    }
}
