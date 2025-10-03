import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        s = s.replaceAll("pi", " ")
             .replaceAll("ka", " ")
             .replaceAll("chu", " ")
             .replaceAll(" ", "");
        if(s.isEmpty()) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}
