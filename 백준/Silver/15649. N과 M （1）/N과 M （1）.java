import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    static int N, M;
    static boolean[] check;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        N = scanner.nextInt();
        M = scanner.nextInt();
        check = new boolean[N + 1];

        List<Integer> temp = new ArrayList<>();
        backTracking(temp);

        scanner.close();
    }

    public static void backTracking(List<Integer> temp) {
        if (temp.size() == M) {
            for (int num : temp) {
                System.out.print(num + " ");
            }
            System.out.println();
            return;
        }

        for (int i = 1; i <= N; i++) {
            if (check[i]) {
                continue;
            }

            check[i] = true;
            temp.add(i);
            backTracking(temp);
            temp.remove(temp.size() - 1);
            check[i] = false;
        }
    }
}
