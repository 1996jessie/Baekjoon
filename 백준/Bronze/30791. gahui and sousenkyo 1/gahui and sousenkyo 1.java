import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int tier16Votes = Integer.parseInt(input[0]);
        int count = 0;

        for (int i = 1; i < 5; i++) {
            if (tier16Votes - Integer.parseInt(input[i]) <= 1000) {
                count++;
            }
        }
        
        System.out.println(count);
    }
}
