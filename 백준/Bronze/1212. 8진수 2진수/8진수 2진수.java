import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String octal = br.readLine();
        StringBuilder binary = new StringBuilder();

        for (char digit : octal.toCharArray()) {
            int num = digit - '0';
            String bin = Integer.toBinaryString(num);
            
            if (binary.length() == 0) {
                binary.append(bin);
            } else {
                while (bin.length() < 3) {
                    bin = "0" + bin;
                }
                binary.append(bin);
            }
        }

        System.out.println(binary);
    }
}
