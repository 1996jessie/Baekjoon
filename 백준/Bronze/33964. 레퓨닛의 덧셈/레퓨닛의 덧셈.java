import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int x = Integer.parseInt(input[0]);
        int y = Integer.parseInt(input[1]);

        int repunitX = Integer.parseInt("1".repeat(x));
        int repunitY = Integer.parseInt("1".repeat(y));

        System.out.println(repunitX + repunitY);
    }
}
