import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        char[][] friends = new char[N][N];
        
        for (int i = 0; i < N; i++) {
            friends[i] = br.readLine().toCharArray();
        }

        int maxFriends = 0;

        for (int i = 0; i < N; i++) {
            boolean[] is2Friend = new boolean[N];
            for (int j = 0; j < N; j++) {
                if (friends[i][j] == 'Y') {
                    is2Friend[j] = true;
                    for (int k = 0; k < N; k++) {
                        if (friends[j][k] == 'Y' && k != i) {
                            is2Friend[k] = true;
                        }
                    }
                }
            }
            int count = 0;
            for (boolean f : is2Friend) {
                if (f) {
                    count++;
                }
            }
            maxFriends = Math.max(maxFriends, count);
        }

        System.out.println(maxFriends);
    }
}
