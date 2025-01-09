import java.io.*;
import java.util.*;

public class Main {
    static int[] inorder, postorder;
    static Map<Integer, Integer> inorderIndexMap = new HashMap<>();
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        int n = Integer.parseInt(br.readLine());
        
        inorder = new int[n];
        postorder = new int[n];
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            inorder[i] = Integer.parseInt(st.nextToken());
            inorderIndexMap.put(inorder[i], i);
        }
        
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            postorder[i] = Integer.parseInt(st.nextToken());
        }
        
        findPreorder(0, n - 1, 0, n - 1, sb);
        
        System.out.println(sb.toString());
    }
    
    public static void findPreorder(int inStart, int inEnd, int postStart, int postEnd, StringBuilder sb) {
        if (inStart > inEnd || postStart > postEnd) {
            return;
        }
        
        int root = postorder[postEnd];
        sb.append(root).append(" ");
        
        int rootIndexInInorder = inorderIndexMap.get(root);
        
        int leftSubtreeSize = rootIndexInInorder - inStart;
        
        findPreorder(inStart, rootIndexInInorder - 1, postStart, postStart + leftSubtreeSize - 1, sb);
        findPreorder(rootIndexInInorder + 1, inEnd, postStart + leftSubtreeSize, postEnd - 1, sb);
    }
}
