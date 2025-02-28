import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int sum = 0, min = Integer.MAX_VALUE, num;

        for (int i = 0; i < 7; i++) {
            num = Integer.parseInt(br.readLine());
            if (num % 2 == 1) {
                sum += num;
                min = Math.min(min, num);
            }
        }

        if (sum == 0) {
            System.out.println(-1);
        } else {
            System.out.println(sum);
            System.out.println(min);
        }
    }
}
