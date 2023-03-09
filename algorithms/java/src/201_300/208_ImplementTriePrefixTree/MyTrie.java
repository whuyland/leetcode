// https://leetcode.com/problems/implement-trie-prefix-tree/
public class MyTrie {
    static class TrieNode {
        char c;
        boolean isWord;
        TrieNode[] children;

        TrieNode() {
            this.children = new TrieNode[26];
            isWord = false;
        }

        TrieNode getChild(char c) {
            return children[c - 'a'];
        }

        boolean hasChild(char c) {
            return getChild(c) != null;
        }

        void markIsWord() {
            this.isWord = true;
        }

        void generateChild(char c) {
            TrieNode child = new TrieNode();
            children[c - 'a'] = child;
        }

        boolean isWord() {
            return isWord;
        }
    }

    private final TrieNode root;

    public MyTrie() {
        root = new TrieNode();
    }

    public void insert(String word) {
        int n = word.length();
        TrieNode node = root;
        for (int i = 0; i < n; ++i) {
            char c = word.charAt(i);
            if (!node.hasChild(c)) {
                node.generateChild(c);
            }
            node = node.getChild(c);
        }
        node.markIsWord();
    }

    public boolean search(String word) {
        TrieNode node = moveDown(word);
        return node != null && node.isWord();
    }

    public boolean startsWith(String prefix) {
        return moveDown(prefix) != null;
    }

    private TrieNode moveDown(String s) {
        TrieNode node = root;
        for (int i = 0; i < s.length() && node != null; ++i) {
            node = node.getChild(s.charAt(i));
        }
        return node;
    }
}
