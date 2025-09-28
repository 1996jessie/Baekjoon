import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int P = Integer.parseInt(br.readLine());
        int sw = 0, embedded = 0, ai = 0, firstGrade = 0;
        for(int i = 0; i < P; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int G = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());
            int N = Integer.parseInt(st.nextToken());
            if(G == 1) {
                firstGrade++;
            } else {
                if(C == 1 || C == 2) {
                    sw++;
                } else if(C == 3) {
                    embedded++;
                } else if(C == 4) {
                    ai++;
                }
            }
        }
        System.out.println(sw);
        System.out.println(embedded);
        System.out.println(ai);
        System.out.println(firstGrade);
    }
}
