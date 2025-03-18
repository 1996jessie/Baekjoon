import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int U = Integer.parseInt(input[1]);
        int L = Integer.parseInt(input[2]);

        if (N >= 1000 && (U >= 8000 || L >= 260)) {
            System.out.println("Very Good");
        } else if (N >= 1000) {
            System.out.println("Good");
        } else {
            System.out.println("Bad");
        }
    }
}
