import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int registrationFeePerTeam = 4000;
        int totalCost = n * registrationFeePerTeam;
        System.out.println(totalCost);
    }
}
