import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String S = br.readLine();
        int q = Integer.parseInt(br.readLine());

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
            String[] query = br.readLine().split(" ");
            char alpha = query[0].charAt(0);
            int l = Integer.parseInt(query[1]);
            int r = Integer.parseInt(query[2]);

            int charIndex = alpha - 'a';
            int count = prefixSum[charIndex][r + 1] - prefixSum[charIndex][l];
            result.append(count).append("\n");
        }

        System.out.print(result);
    }
}
