import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int A = scanner.nextInt();
        int B = scanner.nextInt();

        int C = scanner.nextInt();

        int startTimeInMinutes = A * 60 + B;

        int endTimeInMinutes = startTimeInMinutes + C;

        int endHour = (endTimeInMinutes / 60) % 24;
        int endMinute = endTimeInMinutes % 60;

        System.out.println(endHour + " " + endMinute);
    }
}
