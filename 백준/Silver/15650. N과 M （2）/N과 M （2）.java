import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    static int N, M;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        N = scanner.nextInt();
        M = scanner.nextInt();

        List<Integer> temp = new ArrayList<>();
        backTracking(1, temp);

        scanner.close();
    }

    public static void backTracking(int start, List<Integer> temp) {
        if (temp.size() == M) {
            for (int num : temp) {
                System.out.print(num + " ");
            }
            System.out.println();
            return;
        }

        for (int i = start; i <= N; i++) {
            temp.add(i);
            backTracking(i + 1, temp);
            temp.remove(temp.size() - 1);
        }
    }
}
