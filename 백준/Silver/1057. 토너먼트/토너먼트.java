import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");

        int N = Integer.parseInt(input[0]);
        int kim = Integer.parseInt(input[1]);
        int lim = Integer.parseInt(input[2]);

        int round = 1;
        
        while (N > 1) {
            if ((kim + 1) / 2 == (lim + 1) / 2) {
                System.out.println(round);
                return;
            }

            kim = (kim + 1) / 2;
            lim = (lim + 1) / 2;

            N = (N + 1) / 2; 
            round++;
        }

        System.out.println(-1);
    }
}
