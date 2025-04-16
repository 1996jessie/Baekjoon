import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String sound = br.readLine();
        char[] seq = {'q', 'u', 'a', 'c', 'k'};
        int[] count = new int[5];
        int ducks = 0, maxDucks = 0;

        for (char ch : sound.toCharArray()) {
            int index = -1;
            for (int i = 0; i < 5; i++) {
                if (seq[i] == ch) {
                    index = i;
                    break;
                }
            }

            if (index == 0) {
                count[0]++;
                ducks++;
                if (ducks > maxDucks) {
                    maxDucks = ducks;
                }
            } else {
                if (count[index - 1] == 0) {
                    System.out.println(-1);
                    return;
                }
                count[index - 1]--;
                count[index]++;
                if (index == 4) {
                    count[4]--;
                    ducks--;
                }
            }
        }

        for (int i = 0; i < 4; i++) {
            if (count[i] != 0) {
                System.out.println(-1);
                return;
            }
        }

        System.out.println(maxDucks);
    }
}
