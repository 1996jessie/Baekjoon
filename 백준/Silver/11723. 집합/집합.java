import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int M = Integer.parseInt(br.readLine());
        int[] set = new int[21];

        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String command = st.nextToken();

            if (command.equals("add")) {
                int x = Integer.parseInt(st.nextToken());
                set[x] = 1;
            } else if (command.equals("remove")) {
                int x = Integer.parseInt(st.nextToken());
                set[x] = 0;
            } else if (command.equals("check")) {
                int x = Integer.parseInt(st.nextToken());
                bw.write(set[x] + "\n");
            } else if (command.equals("toggle")) {
                int x = Integer.parseInt(st.nextToken());
                set[x] = 1 - set[x];
            } else if (command.equals("all")) {
                Arrays.fill(set, 1);
            } else if (command.equals("empty")) {
                Arrays.fill(set, 0);
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
