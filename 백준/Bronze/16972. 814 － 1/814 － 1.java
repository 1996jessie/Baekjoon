import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = 814;
        int limit = 8140;
        Set<String> points = new HashSet<>();
        Random rand = new Random();

        while (points.size() < n) {
            int x = rand.nextInt(limit * 2 + 1) - limit;
            int y = rand.nextInt(limit * 2 + 1) - limit;
            String point = x + " " + y;
            if (!points.contains(point)) {
                points.add(point);
                bw.write(point);
                bw.newLine();
            }
        }
        bw.flush();
    }
}
