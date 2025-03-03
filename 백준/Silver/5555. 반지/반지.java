import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String target = br.readLine();
        int N = Integer.parseInt(br.readLine());
        int count = 0;

        for (int i = 0; i < N; i++) {
            String ring = br.readLine();
            String doubledRing = ring + ring;
            if (doubledRing.contains(target)) {
                count++;
            }
        }

        System.out.println(count);
    }
}
