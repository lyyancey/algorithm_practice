class Trie{
    private Trie[] children;
    private boolean isEnd;
    /** Initialize your data structure here. */
    public Trie() {
        this.children = new Trie[26];
        this.isEnd = false;
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        Trie node = this;
        for(int i = 0;i<word.length();i++){
           char ch = word.charAt(i);
           int index = ch - 'a';
           if(node.children[index]==null){
               node.children[index] = new Trie();
           }
           node = node.children[index];
        }
        node.isEnd = true;
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        Trie node = searchNode(word);
        return node!=null&&node.isEnd;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        Trie node = searchNode(prefix);
        return node!=null;
    }
    private Trie searchNode(String word){
        Trie node = this;
        for(int i=0;i<word.length();i++){
            char ch = word.charAt(i);
            int index = ch - 'a';
            if(node.children[index]==null){
                return null;
            }
            node = node.children[index];
        }
        return node;
    }

}
