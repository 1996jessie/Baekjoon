import java.io.*;
import java.util.regex.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        String regex = "^(100+1+|01)+$";
        Pattern pattern = Pattern.compile(regex);

        for (int i = 0; i < T; i++) {
            String signal = br.readLine();
            Matcher matcher = pattern.matcher(signal);

            if (matcher.matches()) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }
}
