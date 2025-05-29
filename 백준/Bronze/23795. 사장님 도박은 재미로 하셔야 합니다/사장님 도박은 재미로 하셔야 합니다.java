import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long sum = 0;
        while (true) {
            String line = br.readLine();
            int bet = Integer.parseInt(line);
            if (bet == -1) {
                break;
            }
            sum += bet;
        }
        System.out.println(sum);
    }
}
