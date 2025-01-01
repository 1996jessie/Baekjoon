import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        
        Set<String> peopleInCompany = new HashSet<>();

        for (int i = 0; i < n; i++) {
            String[] log = br.readLine().split(" ");
            String name = log[0];
            String action = log[1];
            
            if (action.equals("enter")) {
                peopleInCompany.add(name);
            } else {
                peopleInCompany.remove(name);
            }
        }

        List<String> peopleList = new ArrayList<>(peopleInCompany);
        Collections.sort(peopleList, Collections.reverseOrder());

        for (String person : peopleList) {
            System.out.println(person);
        }

        br.close();
    }
}
