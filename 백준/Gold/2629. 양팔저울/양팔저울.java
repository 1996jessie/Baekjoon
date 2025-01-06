import java.util.*;

public class Main {
    static boolean[] canMeasure;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        int[] weights = new int[n];
        
        for (int i = 0; i < n; i++) {
            weights[i] = sc.nextInt();
        }
        
        int m = sc.nextInt();
        int[] marbles = new int[m];
        
        for (int i = 0; i < m; i++) {
            marbles[i] = sc.nextInt();
        }
        
        canMeasure = new boolean[40001];
        canMeasure[0] = true;
        
        for (int i = 0; i < n; i++) {
            int weight = weights[i];
            boolean[] temp = new boolean[40001];
            
            for (int j = 0; j <= 40000; j++) {
                if (canMeasure[j]) {
                    if (j + weight <= 40000) temp[j + weight] = true;
                    if (Math.abs(j - weight) <= 40000) temp[Math.abs(j - weight)] = true;
                    temp[j] = true;
                }
            }
            
            canMeasure = temp;
        }
        
        for (int i = 0; i < m; i++) {
            if (canMeasure[marbles[i]]) {
                System.out.print("Y ");
            } else {
                System.out.print("N ");
            }
        }
    }
}
