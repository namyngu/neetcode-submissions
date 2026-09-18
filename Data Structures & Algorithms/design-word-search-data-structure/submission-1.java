class WordDictionary {
    TrieNode root;

    public WordDictionary() {
        this.root = new TrieNode();
    }

    public void addWord(String word) {
        TrieNode curr = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (!curr.children.containsKey(c)) {
                curr.children.put(c, new TrieNode());
            }
            curr = curr.children.get(c);
        }
        curr.isWord = true;
    }

    public boolean search(String word) {
        return searchHelper(word, root);
    }

    public boolean searchHelper(String word, TrieNode root) {
        TrieNode curr = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (c == '.') {
                if (curr.children.size() > 0) {
                    if (i == word.length() - 1) {
                        for (Map.Entry<Character, TrieNode> entry : curr.children.entrySet()) {
                            if (entry.getValue().isWord){
                                return true;
                            }
                        }
                    }
                    for (Map.Entry<Character, TrieNode> entry : curr.children.entrySet()) {
                        if (searchHelper(word.substring(i + 1), entry.getValue())) {
                            return true;
                        }
                    }
                }
                
                return false;
            }
            if (!curr.children.containsKey(c)) {
                return false;
            }
            curr = curr.children.get(c);
        }
        return curr.isWord;
    }
}

class TrieNode {
    public Map<Character, TrieNode> children;
    public boolean isWord;

    public TrieNode() {
        this.children = new HashMap<>();
        this.isWord = false;
    }
}
