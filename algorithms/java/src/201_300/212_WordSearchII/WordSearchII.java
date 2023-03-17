import java.util.LinkedList;
import java.util.List;

// https://leetcode.com/problems/word-search-ii/
public class WordSearchII {
    static class Node {
        private String word;
        private final Node[] children;
        private boolean seen;

        public Node() {
            children = new Node[26];
            word = null;
            seen = false;
        }

        public Node getChild(char c) {
            return children[c - 'a'];
        }

        public boolean hasChild(char c) {
            return getChild(c) != null;
        }

        public Node getOrAdd(char c) {
            int ind = c - 'a';
            if (children[ind] == null) {
                children[ind] = new Node();
            }
            return children[ind];
        }

        public void setWord(String word) {
            this.word = word;
        }

        public boolean isFreshWord() {
            return word != null && !seen;
        }

        public String getWord() {
            seen = true;
            return word;
        }
    }


    public List<String> findWords(char[][] board, String[] words) {
        List<String> ret = new LinkedList<>();
        Node root = buildTrie(words);
        int m = board.length;
        int n = board[0].length;
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                traverse(board, i, j, root, ret);
            }
        }
        return ret;
    }

    private void traverse(char[][] board, int i, int j, Node root, List<String> ret) {
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length
                || board[i][j] == '.' || !root.hasChild(board[i][j])) {
            return;
        }
        char c = board[i][j];
        Node node = root.getChild(c);
        if (node.isFreshWord()) {
            ret.add(node.getWord());
        }
        board[i][j] = '.';

        int[][] jobs = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        for (int[] job : jobs) {
            traverse(board, i + job[0], j + job[1], node, ret);
        }
        board[i][j] = c;
    }

    private Node buildTrie(String[] words) {
        Node root = new Node();
        for (String s : words) {
            Node node = root;
            for (int i = 0; i < s.length(); ++i) {
                node = node.getOrAdd(s.charAt(i));
            }
            node.setWord(s);
        }
        return root;
    }
}
