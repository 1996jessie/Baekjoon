import java.io.*;
import java.util.HashSet;

public class Main {
    static int[] values = {1, 5, 10, 50};
    static HashSet<Integer> uniqueNumbers = new HashSet<>();
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        generateNumbers(0, 0, 0);
        System.out.println(uniqueNumbers.size());
    }

    static void generateNumbers(int count, int sum, int index) {
        if (count == N) {
            uniqueNumbers.add(sum);
            return;
        }

        for (int i = index; i < 4; i++) {
            generateNumbers(count + 1, sum + values[i], i);
        }
    }
}
