import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder result = new StringBuilder();
        String line;

        while (!(line = br.readLine()).equals("0 0")) {
            String[] parts = line.split(" ");
            int M = Integer.parseInt(parts[0]);
            int F = Integer.parseInt(parts[1]);
            result.append(M + F).append("\n");
        }

        System.out.print(result);
    }
}
