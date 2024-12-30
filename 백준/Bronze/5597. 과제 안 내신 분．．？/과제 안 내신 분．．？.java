import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean[] submitted = new boolean[30];

        for (int i = 0; i < 28; i++) {
            int num = sc.nextInt();
            submitted[num - 1] = true;
        }

        for (int i = 0; i < 30; i++) {
            if (!submitted[i]) {
                System.out.println(i + 1);
            }
        }
    }
}
