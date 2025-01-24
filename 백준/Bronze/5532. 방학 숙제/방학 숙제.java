import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int L = Integer.parseInt(br.readLine());
        int A = Integer.parseInt(br.readLine());
        int B = Integer.parseInt(br.readLine());
        int C = Integer.parseInt(br.readLine());
        int D = Integer.parseInt(br.readLine());
        
        int mathDays = (int) Math.ceil((double) B / D);
        int koreanDays = (int) Math.ceil((double) A / C);
        int maxStudyDays = Math.max(mathDays, koreanDays);
        
        System.out.println(L - maxStudyDays);
    }
}
