import java.util.HashMap;
import java.util.HashSet;

/**
 * Created by qixuanwang on 15/9/19.
 */
public class Leetcode79 {

    public static void main(String[] args) {

    }




    public static boolean exist2(char[][] board, String word) {

        int m = board.length;
        if(m==0)
            return false;
        int n = board[0].length;
        if(n==0)
            return false;

        boolean[][] flag = new boolean[m][n];

        int len = word.length();
        if(len==0)
            return true;

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){

                if(board[i][j]==word.charAt(0)){
                    if(existHelper(m, n, board, word, 0, i, j, flag))
                        return true;
//                    break; 这里本来想着break可以提高效率,事实上没有考虑到第一次找的符合的0不一定就是唯一可能的0位,因此不能加break
                }
            }
        }
        return false;
    }

    public static boolean existHelper(int m, int n, char[][] board, String word, int idx, int x, int y, boolean[][] flag){

        if(idx==word.length())
            return true;
        else if(x<0 || x>=m || y<0 || y>=n)
            return false;
        else if(board[x][y]!=word.charAt(idx) || flag[x][y])
            return false;
        else{

            //访问到此说明字符匹配成功且之前没有访问过,因此要置标记位
            flag[x][y] = true;

            if(existHelper(m, n, board, word, idx+1, x+1, y, flag) ||
                    existHelper(m, n, board, word, idx+1, x-1, y, flag) ||
                    existHelper(m, n, board, word, idx+1, x, y+1, flag) ||
                    existHelper(m, n, board, word, idx+1, x, y-1, flag))
                return true;
            else
                //访问到此说明字符匹配成功,但是后续不能成功因此这条路径失败,因此把标记位清除
                flag[x][y] = false;

            return false;
        }

    }




    /**
     * TLE的解法,而且理解错了题意!!!
     * @param board
     * @param word
     * @return
     */
    public static boolean exist(char[][] board, String word) {

        int m = board.length;
        if(m==0)
            return false;
        int n = board[0].length;
        if(n==0)
            return false;

        int len = word.length();

        HashMap<HashSet<String>,Integer> dic = new HashMap<>();
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){

                if(i<m-1){
                    HashSet<String> set = new HashSet<>();
                    set.add(board[i][j] + "");
                    set.add(board[i+1][j] + "");
                    if(dic.containsKey(set)){
                        dic.put(set, dic.get(set)+1);
                    }
                    else
                        dic.put(set, 1);
                }
                if(j<n-1){
                    HashSet<String> set = new HashSet<>();
                    set.add(board[i][j] + "");
                    set.add(board[i][j+1] + "");
                    if(dic.containsKey(set)){
                        dic.put(set, dic.get(set)+1);
                    }
                    else
                        dic.put(set, 1);
                }
            }
        }

        HashSet<String> searchKey = new HashSet<>();
        for(int i=0;i<len-1;i++){
            searchKey.clear();
            searchKey.add(word.substring(i, i + 1));
            searchKey.add(word.substring(i+1,i+2));
            if(dic.containsKey(searchKey) && dic.get(searchKey)>0)
                dic.put(searchKey, dic.get(searchKey)-1);
            else
                return false;
        }
        return true;
    }
}
