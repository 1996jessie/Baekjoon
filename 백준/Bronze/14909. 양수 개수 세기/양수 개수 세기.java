import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] numbers = br.readLine().split(" ");
        int count = 0;

        for (String num : numbers) {
            if (Integer.parseInt(num) > 0) {
                count++;
            }
        }

        System.out.println(count);
    }
}
