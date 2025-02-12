import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split(" ");
        int[] target = new int[N];
        int[] state = new int[N];
        int count = 0;

        for (int i = 0; i < N; i++) {
            target[i] = Integer.parseInt(input[i]);
        }

        for (int i = 0; i < N; i++) {
            if (state[i] != target[i]) {
                count++;
                state[i] = 1 - state[i];
                if (i + 1 < N) {
                    state[i + 1] = 1 - state[i + 1];
                }
                if (i + 2 < N) {
                    state[i + 2] = 1 - state[i + 2];
                }
            }
        }

        bw.write(count + "\n");
        bw.flush();
        br.close();
        bw.close();
    }
}
