import java.io.*;
import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.Locale;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");
        int D = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);

        LocalDate date = LocalDate.of(2009, M, D);
        String dayOfWeek = date.getDayOfWeek().getDisplayName(TextStyle.FULL, Locale.ENGLISH);

        bw.write(dayOfWeek + "\n");
        bw.flush();
        br.close();
        bw.close();
    }
}
