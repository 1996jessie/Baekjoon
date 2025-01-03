import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        sc.nextLine();

        Set<String> dancers = new HashSet<>();
        dancers.add("ChongChong");

        for (int i = 0; i < N; i++) {
            String[] record = sc.nextLine().split(" ");
            String personA = record[0];
            String personB = record[1];

            if (dancers.contains(personA) || dancers.contains(personB)) {
                dancers.add(personA);
                dancers.add(personB);
            }
        }

        System.out.println(dancers.size());
    }
}
