import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int i = 1; i <= T; i++) {
            String first = br.readLine();
            String last = br.readLine();
            System.out.println("Case " + i + ": " + last + ", " + first);
        }
    }
}
