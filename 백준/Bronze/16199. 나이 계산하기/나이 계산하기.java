import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int birthYear = Integer.parseInt(st.nextToken());
        int birthMonth = Integer.parseInt(st.nextToken());
        int birthDay = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int currYear = Integer.parseInt(st.nextToken());
        int currMonth = Integer.parseInt(st.nextToken());
        int currDay = Integer.parseInt(st.nextToken());

        int manAge = currYear - birthYear;
        if (currMonth < birthMonth || (currMonth == birthMonth && currDay < birthDay)) {
            manAge--;
        }

        int countingAge = currYear - birthYear + 1;
        int yearAge = currYear - birthYear;

        System.out.println(manAge);
        System.out.println(countingAge);
        System.out.println(yearAge);
    }
}
