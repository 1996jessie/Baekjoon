import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String pattern = br.readLine();
        int star = pattern.indexOf('*');
        String left = pattern.substring(0, star);
        String right = pattern.substring(star + 1);
        for (int i = 0; i < n; i++) {
            String file = br.readLine();
            if (file.length() < left.length() + right.length()) {
                System.out.println("NE");
                continue;
            }
            if (file.startsWith(left) && file.endsWith(right)) {
                System.out.println("DA");
            } else {
                System.out.println("NE");
            }
        }
    }
}
