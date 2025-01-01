import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Map<String, Integer> nameToNumber = new HashMap<>();
        Map<Integer, String> numberToName = new HashMap<>();

        for (int i = 1; i <= N; i++) {
            String pokemonName = br.readLine();
            nameToNumber.put(pokemonName, i);
            numberToName.put(i, pokemonName);
        }

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < M; i++) {
            String query = br.readLine();
            if (Character.isDigit(query.charAt(0))) {
                int number = Integer.parseInt(query);
                result.append(numberToName.get(number)).append("\n");
            } else {
                result.append(nameToNumber.get(query)).append("\n");
            }
        }

        System.out.print(result);
        br.close();
    }
}
