import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;
        int groupNum = 1;
        StringBuilder result = new StringBuilder();

        while (!(line = br.readLine()).equals("0")) {
            int n = Integer.parseInt(line);
            String[] names = new String[n];
            List<String> nastyComments = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                names[i] = br.readLine();
            }

            for (int i = 0; i < n; i++) {
                String[] parts = names[i].split(" ");
                String currentName = parts[0];
                for (int j = 1; j < parts.length; j++) {
                    if (parts[j].equals("N")) {
                        int from = (i - j + n) % n;
                        nastyComments.add(names[from].split(" ")[0] + " was nasty about " + currentName);
                    }
                }
            }

            result.append("Group ").append(groupNum++).append("\n");
            if (nastyComments.isEmpty()) {
                result.append("Nobody was nasty\n");
            } else {
                for (String comment : nastyComments) {
                    result.append(comment).append("\n");
                }
            }
            result.append("\n");
        }

        System.out.print(result);
    }
}
