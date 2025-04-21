import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] count = new int[5];

        for (int i = 0; i < n; i++) {
            String availability = br.readLine();
            for (int j = 0; j < 5; j++) {
                if (availability.charAt(j) == 'Y') {
                    count[j]++;
                }
            }
        }

        int max = 0;
        for (int i = 0; i < 5; i++) {
            if (count[i] > max) {
                max = count[i];
            }
        }

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < 5; i++) {
            if (count[i] == max) {
                if (result.length() > 0) {
                    result.append(",");
                }
                result.append(i + 1);
            }
        }

        System.out.println(result.toString());
    }
}
