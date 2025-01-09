import java.io.*;
import java.util.*;

public class Main {
    static int[] preorder;
    static int idx = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        ArrayList<Integer> preOrderList = new ArrayList<>();
        
        String line;
        while ((line = br.readLine()) != null && !line.isEmpty()) {
            preOrderList.add(Integer.parseInt(line));
        }
        
        preorder = preOrderList.stream().mapToInt(i -> i).toArray();
        
        postOrder(0, Integer.MAX_VALUE, sb);
        
        System.out.println(sb.toString());
    }

    public static void postOrder(int start, int end, StringBuilder sb) {
        if (start >= preorder.length) {
            return;
        }
        
        int rootValue = preorder[start];
        
        if (rootValue > end) {
            return;
        }
        
        int splitIndex = start + 1;
        
        while (splitIndex < preorder.length && preorder[splitIndex] < rootValue) {
            splitIndex++;
        }
        
        postOrder(start + 1, rootValue, sb);
        postOrder(splitIndex, end, sb);
        sb.append(rootValue).append("\n");
    }
}
