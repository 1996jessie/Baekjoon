import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int N = sc.nextInt();
        long[] fileSizes = new long[N];
        
        for (int i = 0; i < N; i++) {
            fileSizes[i] = sc.nextLong();
        }
        
        long clusterSize = sc.nextLong();
        long totalDiskSpace = 0;
        
        for (long fileSize : fileSizes) {
            totalDiskSpace += (fileSize + clusterSize - 1) / clusterSize * clusterSize;
        }
        
        System.out.println(totalDiskSpace);
    }
}
