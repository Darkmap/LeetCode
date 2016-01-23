import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.List;

/**
 * Created by qixuanwang on 16/1/22.
 */
public class Leetcode212 {

    public static void main(String[] args) {
//        char[][] board = {{'o','a','a','n'},{'e','t','a','e'},{'i','h','k','r'},{'i','f','l','v'}};
//        String[] words = {"oath","pea","eat","rain"};
        char[][] board = {{'a','a','a','a'},{'a','a','a','a'},{'a','a','a','a'}};
        String[] words = {"aaaaaaaaaaaa"};

        for(String str: findWords2(board, words)){
            System.out.println(str);
        }
    }

    public static List<String> findWords(char[][] board, String[] words) {

        List<String> res = new ArrayList<>();

        if(board.length==0 || board[0].length==0)
            return res;

        HashSet<String> set = new HashSet<>();

        for(String str: words){
            if(!set.contains(str) && search(board,str)){
                res.add(str);
            }
            set.add(str);
        }

        return res;
    }

    public static List<String> findWords2(char[][] board, String[] words) {

        Set<String> res = new HashSet<>();

        Trie trie = new Trie();
        for (String word : words) {
            trie.insert(word);
        }

        Set<Integer> set = new HashSet<>();

        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                dfs(board,i,j,"",set,res,trie);
            }
        }

        return new ArrayList<>(res);
    }

    public static void dfs(char[][] board, int x, int y, String pre, Set<Integer> set, Set<String> res, Trie trie){

        int yl = board[0].length;

        if (x < 0 || x >= board.length || y < 0 || y >= board[0].length) return;

        if(set.contains(x*yl+y))
            return;

        String cur = pre+board[x][y];

        if(!trie.startsWith(cur))
            return;

        if(trie.search(cur))
            res.add(cur);

        int flag = x*yl+y;
        set.add(flag);
        dfs(board, x - 1, y, cur, set, res,trie);
        dfs(board,x+1,y,cur,set,res,trie);
        dfs(board,x,y-1,cur,set,res,trie);
        dfs(board,x,y+1,cur,set,res,trie);
        set.remove(flag);

    }



    public static boolean search(char[][] board, String word){

        char[] wordary = word.toCharArray();

        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(board[i][j]==wordary[0]){
                    Set<Integer> set = new HashSet<>();
                    set.add(i*board[0].length + j);
                    if(helper(board,i,j,wordary,1,set)){
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static boolean helper(char[][] board, int x, int y, char[] word, int idx, Set<Integer> set){

        if(idx==word.length){
            return true;
        }

        int xl = board.length;
        int yl = board[0].length;



        if(x>0){
            int up = (x-1)*yl + y;
            if(!set.contains(up) && board[x-1][y]==word[idx]){
                set.add(up);
                if(helper(board,x-1,y,word,idx+1,set)){
                    return true;
                }
                set.remove(up);
            }
        }
        if(x<xl-1){
            int down = (x+1)*yl + y;
            if(!set.contains(down) && board[x+1][y]==word[idx]){
                set.add(down);
                if(helper(board,x+1,y,word,idx+1,set)){
                    return true;
                }
                set.remove(down);
            }
        }

        if(y>0){
            int left = x*yl + y-1;
            if(!set.contains(left) && board[x][y-1]==word[idx]){
                set.add(left);
                if(helper(board,x,y-1,word,idx+1,set)){
                    return true;
                }
                set.remove(left);
            }
        }
        if(y<yl-1){
            int right = x*yl + y+1;
            if(!set.contains(right) && board[x][y+1]==word[idx]){
                set.add(right);
                if(helper(board,x,y+1,word,idx+1,set)){
                    return true;
                }
                set.remove(right);
            }
        }

        return false;
    }
}

class TrieNode2 {
    public TrieNode2[] children = new TrieNode2[26];
    public String item = "";

    // Initialize your data structure here.
    public TrieNode2() {
    }
}

class Trie {
    private TrieNode2 root;

    public Trie() {
        root = new TrieNode2();
    }

    // Inserts a word into the trie.
    public void insert(String word) {
        TrieNode2 node = root;
        for (char c : word.toCharArray()) {
            if (node.children[c - 'a'] == null) {
                node.children[c - 'a'] = new TrieNode2();
            }
            node = node.children[c - 'a'];
        }
        node.item = word;
    }

    // Returns if the word is in the trie.
    public boolean search(String word) {
        TrieNode2 node = root;
        for (char c : word.toCharArray()) {
            if (node.children[c - 'a'] == null) return false;
            node = node.children[c - 'a'];
        }
        return node.item.equals(word);
    }

    // Returns if there is any word in the trie
    // that starts with the given prefix.
    public boolean startsWith(String prefix) {
        TrieNode2 node = root;
        for (char c : prefix.toCharArray()) {
            if (node.children[c - 'a'] == null) return false;
            node = node.children[c - 'a'];
        }
        return true;
    }
}
