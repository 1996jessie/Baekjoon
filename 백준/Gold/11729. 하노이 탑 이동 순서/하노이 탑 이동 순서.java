import java.io.*;

public class Main {
    static StringBuilder sb = new StringBuilder();

    static void hanoi(int N, int from, int to, int aux) {
        if (N == 1) {
            sb.append(from).append(" ").append(to).append("\n");
            return;
        }

        hanoi(N - 1, from, aux, to);
        sb.append(from).append(" ").append(to).append("\n");
        hanoi(N - 1, aux, to, from);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        int moves = (1 << N) - 1;
        sb.append(moves).append("\n");
        
        hanoi(N, 1, 3, 2);

        System.out.print(sb.toString());
    }
}
