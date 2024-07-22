import java.util.*;

class Solution {
    public int solution(String[] words) {

        Trie trie = new Trie();
        for (String word : words)
            trie.insert(word);

        int answer = 0;
        for (String word : words)
            answer += trie.findLength(word);

        return answer;
    }
}

class TrieNode {
    Map<Character, TrieNode> child = new HashMap<>();
    int count = 0;
}

class Trie {

    TrieNode root = new TrieNode();

    public void insert(String word) {
        TrieNode node = root;

        for (char ch : word.toCharArray()) {
            node.child.putIfAbsent(ch, new TrieNode());
            node = node.child.get(ch);
            node.count++;
        }
    }

    public int findLength(String word) {
        TrieNode node = root;
        int length = 0;

        for (char ch : word.toCharArray()) {
            node = node.child.get(ch);
            length++;
            if (node.count == 1) break;
        }

        return length;
    }
}