import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] difficulty = new int[n];

        for (int i = 0; i < n; i++) {
            difficulty[i] = sc.nextInt();
        }

        int first = difficulty[0];
        boolean isEasiest = true;
        boolean isHardest = true;

        for (int i = 1; i < n; i++) {
            if (difficulty[i] < first) {
                isEasiest = false;
            }
            if (difficulty[i] > first) {
                isHardest = false;
            }
        }

        if (isEasiest) {
            System.out.println("ez");
        } else if (isHardest) {
            System.out.println("hard");
        } else {
            System.out.println("?");
        }
    }
}
