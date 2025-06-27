import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] names = new String[n];
        for (int i = 0; i < n; i++) {
            names[i] = br.readLine();
        }

        String[] inc = names.clone();
        String[] dec = names.clone();
        Arrays.sort(inc);
        Arrays.sort(dec, Collections.reverseOrder());

        boolean isInc = true;
        boolean isDec = true;

        for (int i = 0; i < n; i++) {
            if (!names[i].equals(inc[i])) {
                isInc = false;
            }
            if (!names[i].equals(dec[i])) {
                isDec = false;
            }
        }

        if (isInc) {
            System.out.println("INCREASING");
        } else if (isDec) {
            System.out.println("DECREASING");
        } else {
            System.out.println("NEITHER");
        }
    }
}
