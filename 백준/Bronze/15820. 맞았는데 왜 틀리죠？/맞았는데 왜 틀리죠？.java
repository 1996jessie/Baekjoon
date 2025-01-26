import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int S1 = Integer.parseInt(st.nextToken());
        int S2 = Integer.parseInt(st.nextToken());
        
        boolean sampleWrong = false;
        boolean systemWrong = false;

        for (int i = 0; i < S1; i++) {
            st = new StringTokenizer(br.readLine());
            int correct = Integer.parseInt(st.nextToken());
            int answer = Integer.parseInt(st.nextToken());
            if (correct != answer) {
                sampleWrong = true;
            }
        }
        
        for (int i = 0; i < S2; i++) {
            st = new StringTokenizer(br.readLine());
            int correct = Integer.parseInt(st.nextToken());
            int answer = Integer.parseInt(st.nextToken());
            if (correct != answer) {
                systemWrong = true;
            }
        }

        if (sampleWrong) {
            System.out.println("Wrong Answer");
        } else if (systemWrong) {
            System.out.println("Why Wrong!!!");
        } else {
            System.out.println("Accepted");
        }
    }
}
