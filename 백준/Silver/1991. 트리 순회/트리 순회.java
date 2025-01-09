import java.io.*;
import java.util.*;

public class Main {
    static Map<Character, Character[]> tree = new HashMap<>();
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        int n = Integer.parseInt(br.readLine());
        
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            char node = st.nextToken().charAt(0);
            char left = st.nextToken().charAt(0);
            char right = st.nextToken().charAt(0);
            
            tree.put(node, new Character[]{left, right});
        }
        
        preorder('A', sb);
        sb.append("\n");
        inorder('A', sb);
        sb.append("\n");
        postorder('A', sb);
        sb.append("\n");
        
        System.out.println(sb.toString());
    }
    
    public static void preorder(char node, StringBuilder sb) {
        if (node == '.') {
            return;
        }
        sb.append(node);
        preorder(tree.get(node)[0], sb);
        preorder(tree.get(node)[1], sb);
    }
    
    public static void inorder(char node, StringBuilder sb) {
        if (node == '.') {
            return;
        }
        inorder(tree.get(node)[0], sb);
        sb.append(node);
        inorder(tree.get(node)[1], sb);
    }
    
    public static void postorder(char node, StringBuilder sb) {
        if (node == '.') {
            return;
        }
        postorder(tree.get(node)[0], sb);
        postorder(tree.get(node)[1], sb);
        sb.append(node);
    }
}
