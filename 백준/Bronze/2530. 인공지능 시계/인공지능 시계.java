import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int A = sc.nextInt();
        int B = sc.nextInt();
        int C = sc.nextInt();
        int D = sc.nextInt();
        
        int currentTimeInSeconds = A * 3600 + B * 60 + C;
        int finishTimeInSeconds = currentTimeInSeconds + D;
        
        finishTimeInSeconds %= 86400;
        
        int finalHour = finishTimeInSeconds / 3600;
        int finalMinute = (finishTimeInSeconds % 3600) / 60;
        int finalSecond = finishTimeInSeconds % 60;
        
        System.out.println(finalHour + " " + finalMinute + " " + finalSecond);
    }
}
