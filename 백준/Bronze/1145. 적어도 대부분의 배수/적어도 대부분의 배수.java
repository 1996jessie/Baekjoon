import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] nums = new int[5];
        for (int i = 0; i < 5; i++) nums[i] = sc.nextInt();
        int ans = 1;
        while (true) {
            int cnt = 0;
            for (int num : nums) if (ans % num == 0) cnt++;
            if (cnt >= 3) {
                System.out.println(ans);
                break;
            }
            ans++;
        }
    }
}
