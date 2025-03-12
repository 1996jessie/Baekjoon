import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        String[] firstList = sc.nextLine().split(" ");
        String[] secondList = sc.nextLine().split(" ");
        
        Map<String, String> partners = new HashMap<>();
        
        for (int i = 0; i < n; i++) {
            String a = firstList[i];
            String b = secondList[i];
            if (a.equals(b)) {
                System.out.println("bad");
                return;
            }
            if (partners.containsKey(a) && !partners.get(a).equals(b)) {
                System.out.println("bad");
                return;
            }
            if (partners.containsKey(b) && !partners.get(b).equals(a)) {
                System.out.println("bad");
                return;
            }
            partners.put(a, b);
            partners.put(b, a);
        }
        
        System.out.println("good");
    }
}
