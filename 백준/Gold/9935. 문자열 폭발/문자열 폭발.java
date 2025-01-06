import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        String bomb = br.readLine();

        StringBuilder sb = new StringBuilder();
        int bombLen = bomb.length();

        for (int i = 0; i < str.length(); i++) {
            sb.append(str.charAt(i));

            if (sb.length() >= bombLen && sb.substring(sb.length() - bombLen).equals(bomb)) {
                sb.delete(sb.length() - bombLen, sb.length());
            }
        }

        if (sb.length() == 0) {
            System.out.println("FRULA");
        } else {
            System.out.println(sb.toString());
        }
    }
}
