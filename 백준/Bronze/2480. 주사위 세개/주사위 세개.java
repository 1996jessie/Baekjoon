import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int dice1 = scanner.nextInt();
        int dice2 = scanner.nextInt();
        int dice3 = scanner.nextInt();

        if (dice1 == dice2 && dice2 == dice3) {
            System.out.println(10000 + dice1 * 1000);
        } else if (dice1 == dice2) {
            System.out.println(1000 + dice1 * 100);
        } else if (dice2 == dice3) {
            System.out.println(1000 + dice2 * 100);
        } else if (dice1 == dice3) {
            System.out.println(1000 + dice1 * 100);
        } else {
            int max = Math.max(dice1, Math.max(dice2, dice3));
            System.out.println(max * 100);
        }
    }
}
