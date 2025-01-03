import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        scanner.close();

        int totalCombinations = N * N;
        int sameColorCombinations = N;

        int differentColorCombinations = totalCombinations - sameColorCombinations;

        System.out.println(differentColorCombinations);
    }
}
