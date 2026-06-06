class WordDictionary {

    TrieNode root;
    public WordDictionary() {
        this.root = new TrieNode();
    }

    public void addWord(String word) {
        TrieNode cur = root;
        for (char c : word.toCharArray()) {
            int index = c - 'a';
            if (cur.children[index] == null) {
                cur.children[index] = new TrieNode();
            }
            cur = cur.children[index];
        }
        cur.end = true;
    }

    public boolean search(String word) {
        return dfs(word.toCharArray(),0,root);
    }

    static boolean dfs(char[] word, int index, TrieNode node) {
        if (node == null) {
            return false;
        }

        if (index == word.length) {
            return node.end;
        }

        char c = word[index];
        if (c == '.') {
            for (int i = 0; i < 26; i++) {
                if (node.children[i] != null && dfs(word,index+1,node.children[i])) {
                    return true;
                }
            }
            return false;

        }else {
            int i = c - 'a';
            return dfs(word,index + 1, node.children[i]);
        }
    }

}

class TrieNode {
    TrieNode[] children = new TrieNode[26];
    boolean end = false;
}
