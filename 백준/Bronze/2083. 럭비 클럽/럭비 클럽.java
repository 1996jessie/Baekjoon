import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String line;

        while (!(line = br.readLine()).equals("# 0 0")) {
            String[] data = line.split(" ");
            String name = data[0];
            int age = Integer.parseInt(data[1]);
            int weight = Integer.parseInt(data[2]);

            sb.append(name).append(" ").append((age > 17 || weight >= 80) ? "Senior" : "Junior").append("\n");
        }

        System.out.print(sb);
    }
}
