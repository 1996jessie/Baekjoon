import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        for (int t = 1; t <= N; t++) {
            String line = br.readLine();
            String[] words = line.split(" ");

            System.out.print("Case #" + t + ": ");
            for (int i = words.length - 1; i >= 0; i--) {
                System.out.print(words[i]);
                if (i != 0) {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
}
