/**
 * Created by qixuanwang on 15/11/6.
 */

public class WordDictionary {

    private TrieNode root;

    public WordDictionary() {
        root = new TrieNode();
    }

    // Inserts a word into the trie.
    public void insert(String word) {
        if(word==null)
            return;
        int len = word.length();
        if(len>0){
            TrieNode cur = root;
            for(int i=0;i<len;i++){
                char bit = word.charAt(i);
                int charIdx = (bit-'a');
                if(cur.childs[charIdx]==null)
                    cur.childs[charIdx] = new TrieNode();
                if(i==len-1){
                    cur = cur.childs[charIdx];
                    cur.isKey = true;
                }
                else{
                    cur = cur.childs[charIdx];
                }
            }
        }
    }

    // Returns if the word is in the trie.
    public boolean search2(String word) {
        int len = word.length();
        if(len==0)
            return true;
        TrieNode cur = root;
        for(int i=0;i<len;i++){
            char bit = word.charAt(i);
            int charIdx = (bit-'a');
            if(cur.childs[charIdx]!=null){
                cur = cur.childs[charIdx];
                if(i==len-1){
                    if(cur.isKey==true)
                        return true;
                    else
                        return false;
                }
            }
            else
                return false;
        }
        return true;
    }

    // Adds a word into the data structure.
    public void addWord(String word) {
        insert(word);
    }

    // Returns if the word is in the data structure. A word could
    // contain the dot character '.' to represent any one letter.
    public boolean search(String word) {
        int len = word.length();
        if(len==0)
            return true;
        return searchHelper(word, root);
    }

    public boolean searchHelper(String word, TrieNode root){

        int len = word.length();

        char bit = word.charAt(0);
        boolean ans = false;
        if(bit=='.'){
            for(int i=0;i<26;i++){
                if(root.childs[i]!=null){
                    TrieNode cur = root.childs[i];
                    if(len==1){
                        if(cur.isKey==true)
                            return true;
                    }
                    else{
                        ans |= searchHelper(word.substring(1), cur);
                        if(ans==true)
                            return true;
                    }
                }
            }
        }
        else{
            int charIdx = (bit-'a');
            if(root.childs[charIdx]!=null){
                TrieNode cur = root.childs[charIdx];
                if(len==1){
                    if(cur.isKey==true)
                        return true;
                    else
                        return false;
                }
                else{
                    ans |= searchHelper(word.substring(1), cur);
                    if(ans==true)
                        return true;
                }
            }
            else
                return false;
        }

        return ans;
    }
}

class TrieNode {

    boolean isKey;
    TrieNode[] childs;

    // Initialize your data structure here.
    public TrieNode() {
        isKey = false;
        childs = new TrieNode[26];
    }
}
