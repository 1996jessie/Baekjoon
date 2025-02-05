import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String[] time = br.readLine().split(" ");
        int A = Integer.parseInt(time[0]);
        int B = Integer.parseInt(time[1]);
        int C = Integer.parseInt(time[2]);
        int D = Integer.parseInt(br.readLine());
        
        int currentTimeInSeconds = A * 3600 + B * 60 + C;
        int finishTimeInSeconds = currentTimeInSeconds + D;
        
        finishTimeInSeconds %= 86400;
        
        int finalHour = finishTimeInSeconds / 3600;
        int finalMinute = (finishTimeInSeconds % 3600) / 60;
        int finalSecond = finishTimeInSeconds % 60;
        
        System.out.println(finalHour + " " + finalMinute + " " + finalSecond);
    }
}
