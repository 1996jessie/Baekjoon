import java.util.*;

public class Main {
    static int N;
    static int[][] S;
    static boolean[] visited;
    static int minDiff = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        S = new int[N][N];
        visited = new boolean[N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                S[i][j] = sc.nextInt();
            }
        }

        makeTeams(0, 0);
        
        System.out.println(minDiff);
    }

    public static void makeTeams(int idx, int count) {
        if (count == N / 2) {
            calculateDifference();
            return;
        }

        for (int i = idx; i < N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                makeTeams(i + 1, count + 1);
                visited[i] = false;
            }
        }
    }

    public static void calculateDifference() {
        int startTeam = 0;
        int linkTeam = 0;

        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                if (visited[i] && visited[j]) {
                    startTeam += S[i][j] + S[j][i];
                } else if (!visited[i] && !visited[j]) {
                    linkTeam += S[i][j] + S[j][i];
                }
            }
        }

        minDiff = Math.min(minDiff, Math.abs(startTeam - linkTeam));
    }
}
