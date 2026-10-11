import java.util.ArrayList;
import java.util.List;

/**
 * 212. Word Search II
 * Time: O(cells * 4 * 3^(L-1)) worst case, plus O(total word length) to build
 * Space: O(total word length)
 */
class Solution {
    private static class TrieNode {
        TrieNode[] children = new TrieNode[26];
        String word;
        int childCount;  // kept so pruning is O(1) instead of scanning 26
    }

    private char[][] board;
    private int rows, cols;
    private List<String> found;

    public List<String> findWords(char[][] board, String[] words) {
        this.board = board;
        this.rows = board.length;
        this.cols = board[0].length;
        this.found = new ArrayList<>();

        // a word needing more of a letter than the board holds can never match
        int[] available = new int[26];
        for (char[] row : board) {
            for (char ch : row) {
                available[ch - 'a']++;
            }
        }

        TrieNode root = new TrieNode();
        int[] need = new int[26];
        for (String word : words) {
            java.util.Arrays.fill(need, 0);
            boolean possible = true;
            for (int i = 0; i < word.length(); i++) {
                int idx = word.charAt(i) - 'a';
                if (++need[idx] > available[idx]) {
                    possible = false;
                    break;
                }
            }
            if (possible) {
                insert(root, word);
            }
        }

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (root.children[board[r][c] - 'a'] != null) {
                    dfs(r, c, root);
                }
            }
        }
        return found;
    }

    private void insert(TrieNode root, String word) {
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            int idx = word.charAt(i) - 'a';
            if (node.children[idx] == null) {
                node.children[idx] = new TrieNode();
                node.childCount++;
            }
            node = node.children[idx];
        }
        node.word = word;
    }

    private void dfs(int r, int c, TrieNode parent) {
        char ch = board[r][c];
        int idx = ch - 'a';
        TrieNode node = parent.children[idx];

        if (node.word != null) {
            found.add(node.word);
            node.word = null;
        }

        board[r][c] = '#';  // mark visited in place
        final int[][] steps = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        for (int[] step : steps) {
            int nr = r + step[0], nc = c + step[1];
            if (nr < 0 || nr >= rows || nc < 0 || nc >= cols) {
                continue;
            }
            char next = board[nr][nc];
            if (next != '#' && node.children[next - 'a'] != null) {
                dfs(nr, nc, node);
            }
        }
        board[r][c] = ch;

        // drop exhausted branches so later starts never revisit them
        if (node.childCount == 0 && node.word == null) {
            parent.children[idx] = null;
            parent.childCount--;
        }
    }
}
