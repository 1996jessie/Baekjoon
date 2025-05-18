import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        String K = input[1];
        int count = 0;
        for (int h = 0; h <= N; h++) {
            for (int m = 0; m < 60; m++) {
                for (int s = 0; s < 60; s++) {
                    String time = String.format("%02d%02d%02d", h, m, s);
                    if (time.contains(K)) {
                        count++;
                    }
                }
            }
        }
        System.out.println(count);
    }
}
