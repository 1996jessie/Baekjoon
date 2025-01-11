import java.io.*;
import java.util.*;

public class Main {
    static class TrieNode {
        Map<Character, TrieNode> children;
        boolean isEndOfWord;

        TrieNode() {
            children = new HashMap<>();
            isEndOfWord = false;
        }
    }

    static class Trie {
        TrieNode root;

        Trie() {
            root = new TrieNode();
        }

        void insert(String word) {
            TrieNode current = root;
            for (char c : word.toCharArray()) {
                current.children.putIfAbsent(c, new TrieNode());
                current = current.children.get(c);
            }
            current.isEndOfWord = true;
        }

        int countKeyPresses(String word) {
            TrieNode current = root;
            int keyPresses = 0;
            for (int i = 0; i < word.length(); i++) {
                if (i == 0 || current.children.size() > 1 || current.isEndOfWord) {
                    keyPresses++;
                }
                current = current.children.get(word.charAt(i));
            }
            return keyPresses;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String input;

        while ((input = br.readLine()) != null) {
            int n = Integer.parseInt(input);
            String[] words = new String[n];
            Trie trie = new Trie();

            for (int i = 0; i < n; i++) {
                words[i] = br.readLine();
                trie.insert(words[i]);
            }

            int totalKeyPresses = 0;
            for (String word : words) {
                totalKeyPresses += trie.countKeyPresses(word);
            }

            double averageKeyPresses = (double) totalKeyPresses / n;
            sb.append(String.format("%.2f", averageKeyPresses)).append("\n");
        }

        System.out.print(sb.toString());
    }
}
