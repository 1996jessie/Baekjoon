import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] firstLine = br.readLine().split(" ");
        int N = Integer.parseInt(firstLine[0]);
        int M = Integer.parseInt(firstLine[1]);
        int J = Integer.parseInt(br.readLine());

        int left = 1;
        int right = M;
        int move = 0;

        for (int i = 0; i < J; i++) {
            int apple = Integer.parseInt(br.readLine());
            if (apple < left) {
                move += left - apple;
                right -= left - apple;
                left = apple;
            } else if (apple > right) {
                move += apple - right;
                left += apple - right;
                right = apple;
            }
        }

        System.out.println(move);
    }
}
