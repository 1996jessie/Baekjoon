import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        
        if (N == 1) {
            System.out.println(1);
            return;
        }
        
        int level = 1;
        int range = 1;
        
        while (true) {
            range += 6 * level;
            level++;
            if (range >= N) {
                break;
            }
        }
        
        System.out.println(level);
    }
}
