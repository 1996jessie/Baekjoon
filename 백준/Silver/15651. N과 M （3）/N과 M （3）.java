import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static BufferedWriter bw;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);

        List<Integer> temp = new ArrayList<>();
        backTracking(temp);

        br.close();
        bw.flush();
        bw.close();
    }

    public static void backTracking(List<Integer> temp) throws IOException {
        if (temp.size() == M) {
            for (int num : temp) {
                bw.write(num + " ");
            }
            bw.newLine();
            return;
        }

        for (int i = 1; i <= N; i++) {
            temp.add(i);
            backTracking(temp);
            temp.remove(temp.size() - 1);
        }
    }
}
