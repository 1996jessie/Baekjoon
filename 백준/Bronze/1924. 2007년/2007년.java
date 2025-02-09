import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());

        int[] daysInMonth = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
        String[] daysOfWeek = { "MON", "TUE", "WED", "THU", "FRI", "SAT", "SUN" };

        int totalDays = y - 1;
        for (int i = 0; i < x - 1; i++) {
            totalDays += daysInMonth[i];
        }

        System.out.println(daysOfWeek[totalDays % 7]);
    }
}
