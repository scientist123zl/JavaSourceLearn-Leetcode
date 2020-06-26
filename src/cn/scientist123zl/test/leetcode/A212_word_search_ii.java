package cn.scientist123zl.test.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 212 单词搜索-ii
 *字典树+DFS
 */
public class A212_word_search_ii {
    int dx[] = new int []{-1, 1, 0, 0};
    int dy[] = new int []{0, 0, -1, 1};

    public List<String> findWords(char[][] board, String[] words) {
        List<String> res = new ArrayList<>();
        TrieNode root = buildTrie(words);
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                dfs (board, i, j, root, res);
            }
        }
        return res;
    }

    public void dfs(char[][] board, int i, int j, TrieNode p, List<String> res) {
        char c = board[i][j];
        if (c == '#' || p.next[c - 'a'] == null) return;
        p = p.next[c - 'a'];
        if (p.word != null) {   // found one
            res.add(p.word);
            p.word = null;     // de-duplicate
        }

        board[i][j] = '#';
//        if (i > 0) dfs(board, i - 1, j ,p, res);
//        if (j > 0) dfs(board, i, j - 1, p, res);
//        if (i < board.length - 1) dfs(board, i + 1, j, p, res);
//        if (j < board[0].length - 1) dfs(board, i, j + 1, p, res);
        for(int k = 0; k < dx.length; ++k) {
            int x = i + dx[k], y = j + dy[k];
            if(x >= 0 && x < board.length && y >= 0 && y <board[i].length) {
                dfs(board, x, y, p, res);
            }
        }
        board[i][j] = c;
    }

    public TrieNode buildTrie(String[] words) {
        TrieNode root = new TrieNode();
        for (String w : words) {
            TrieNode p = root;
            for (char c : w.toCharArray()) {
                int i = c - 'a';
                if (p.next[i] == null) p.next[i] = new TrieNode();
                p = p.next[i];
            }
            p.word = w;
        }
        return root;
    }

    class TrieNode {
        TrieNode[] next = new TrieNode[26];
        String word;
    }

    public static void main(String[] args) {
        A212_word_search_ii a = new A212_word_search_ii();
        char[][] board = new char[][]{
                {'o','a','a','n'},
                {'e','t','a','e'},
                {'i','h','k','r'},
                {'i','f','l','v'}

        };
        String[] words = new String[]{"oath","pea","eat","rain"};
        System.out.println(a.findWords(board,words));
    }
}
