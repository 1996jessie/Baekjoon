import java.io.*;

public class Main {
    static int score(char a, char b) {
        if (a == b) {
            return 1;
        }
        if ((a == 'R' && b == 'S') || (a == 'S' && b == 'P') || (a == 'P' && b == 'R')) {
            return 2;
        }
        return 0;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int R = Integer.parseInt(br.readLine());
        String sang = br.readLine();
        int N = Integer.parseInt(br.readLine());
        String[] friends = new String[N];
        for (int i = 0; i < N; i++) {
            friends[i] = br.readLine();
        }
        int real = 0;
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < N; j++) {
                real += score(sang.charAt(i), friends[j].charAt(i));
            }
        }
        int max = 0;
        for (int i = 0; i < R; i++) {
            int r = 0, s = 0, p = 0;
            for (int j = 0; j < N; j++) {
                r += score('R', friends[j].charAt(i));
                s += score('S', friends[j].charAt(i));
                p += score('P', friends[j].charAt(i));
            }
            max += Math.max(r, Math.max(s, p));
        }
        System.out.println(real);
        System.out.println(max);
    }
}
