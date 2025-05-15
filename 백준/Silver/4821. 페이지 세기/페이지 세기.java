import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            String line = br.readLine();
            if (line.equals("0")) {
                break;
            }

            int totalPages = Integer.parseInt(line);
            String input = br.readLine();
            boolean[] printed = new boolean[totalPages + 1];
            String[] parts = input.split(",");

            for (String part : parts) {
                if (part.contains("-")) {
                    String[] range = part.split("-");
                    int start = Integer.parseInt(range[0]);
                    int end = Integer.parseInt(range[1]);
                    if (start > end) {
                        continue;
                    }
                    for (int i = start; i <= end; i++) {
                        if (i >= 1 && i <= totalPages) {
                            printed[i] = true;
                        }
                    }
                } else {
                    int page = Integer.parseInt(part);
                    if (page >= 1 && page <= totalPages) {
                        printed[page] = true;
                    }
                }
            }

            int count = 0;
            for (int i = 1; i <= totalPages; i++) {
                if (printed[i]) {
                    count++;
                }
            }
            System.out.println(count);
        }
    }
}
