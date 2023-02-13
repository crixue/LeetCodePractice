package leetcode.others;

public class Trie {
    class TrieNode {

        private boolean isEnd;
        private TrieNode[] next;

        public TrieNode() {
            this.isEnd = false;
            this.next = new TrieNode[26];
        }
    }

    private TrieNode root;

    public Trie() {
        this.root = new TrieNode();
    }

    public void insert(String word) {
        int sz = word.length();
        if(sz == 0) return;
        word = word.toLowerCase();
        TrieNode node = root;
        for (char c: word.toCharArray()) {
            TrieNode[] nxtNodes = node.next;
            int idx = c-'a';
            if(nxtNodes[idx] == null) {
                node = new TrieNode();
                nxtNodes[idx] = node;
            }
            node = nxtNodes[idx];
        }
        node.isEnd = true;
    }

    public boolean search(String word) {
        int sz = word.length();
        if(sz == 0) return false;
        word = word.toLowerCase();
        TrieNode node = root;
        for (char c: word.toCharArray()) {
            TrieNode[] nxtNodes = node.next;
            int idx = c-'a';
            if(nxtNodes[idx] == null) {
                return false;
            }
            node = nxtNodes[idx];
        }
        return node.isEnd;
    }

    public boolean startsWith(String word) {
        int sz = word.length();
        if(sz == 0) return false;
        word = word.toLowerCase();
        TrieNode node = root;
        for (char c: word.toCharArray()) {
            TrieNode[] nxtNodes = node.next;
            int idx = c-'a';
            if(nxtNodes[idx] == null) {
                return false;
            }
            node = nxtNodes[idx];
        }
        return true;
    }

    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("apple");
        boolean search = trie.search("apple");   // 返回 True
        System.out.println(search);
        search = trie.search("app");// 返回 False
        System.out.println(search);

        boolean startsWith = trie.startsWith("app");// 返回 True
        System.out.println(startsWith);
        trie.insert("app");
        search = trie.search("app");     // 返回 True
        System.out.println(search);
    }
}
