import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] before = new int[4];
        int[] after = new int[4];

        for (int i = 0; i < 4; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            before[i] = Integer.parseInt(st.nextToken());
            after[i] = Integer.parseInt(st.nextToken());
        }

        int bronzeToSilver = after[1] - before[1] + after[2] - before[2] + after[3] - before[3];
        int silverToGold = after[2] - before[2] + after[3] - before[3];
        int goldToPlatinum = after[3] - before[3];

        System.out.println(bronzeToSilver);
        System.out.println(silverToGold);
        System.out.println(goldToPlatinum);
    }
}
