import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String bowls = br.readLine();
        int height = 10;

        for (int i = 1; i < bowls.length(); i++) {
            if (bowls.charAt(i) == bowls.charAt(i - 1)) {
                height += 5;
            } else {
                height += 10;
            }
        }

        System.out.println(height);
    }
}
