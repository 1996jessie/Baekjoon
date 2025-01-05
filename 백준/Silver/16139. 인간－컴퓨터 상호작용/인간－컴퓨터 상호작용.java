import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String S = sc.next();
        int q = sc.nextInt();

        int[][] prefixSum = new int[26][S.length() + 1];

        for (int i = 0; i < S.length(); i++) {
            int charIndex = S.charAt(i) - 'a';
            for (int j = 0; j < 26; j++) {
                prefixSum[j][i + 1] = prefixSum[j][i];
            }
            prefixSum[charIndex][i + 1]++;
        }

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < q; i++) {
            char alpha = sc.next().charAt(0);
            int l = sc.nextInt();
            int r = sc.nextInt();

            int charIndex = alpha - 'a';
            int count = prefixSum[charIndex][r + 1] - prefixSum[charIndex][l];
            result.append(count).append("\n");
        }

        System.out.print(result);
        sc.close();
    }
}
