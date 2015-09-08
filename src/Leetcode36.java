import java.util.ArrayList;
import java.util.HashSet;

/**
 * Created by qixuanwang on 15/9/2.
 */
public class Leetcode36 {

    public static void main(String[] args) {

        char[][] board = {{'1','2','1'},{'.','1','3'},{'.','3','2'}};
        System.out.println(isValidSudoku(board));
    }

    public static boolean isValidSudoku(char[][] board) {
        int len = board.length;
        ArrayList<HashSet<Integer>> rows = new ArrayList<HashSet<Integer>>();
        ArrayList<HashSet<Integer>> columns = new ArrayList<HashSet<Integer>>();

        ArrayList<HashSet<Integer>> cubes = new ArrayList<HashSet<Integer>>();


        for(int i=0;i<len;i++){
            rows.add(new HashSet<Integer>());
            columns.add(new HashSet<Integer>());
            cubes.add(new HashSet<Integer>());
        }
        for(int x=0;x<len;x++){
            for(int y=0;y<len;y++){

                if(board[x][y]!='.'){
                    if(rows.get(x).contains(board[x][y]-'0'))
                        return false;
                    else
                        rows.get(x).add(board[x][y] - '0');

                    if(columns.get(y).contains(board[x][y]-'0'))
                        return false;
                    else
                        columns.get(y).add(board[x][y] - '0');

                    //不能/3*3合并,因为是取下确界的int运算!!!!
                    if(cubes.get((x/3)*3+y/3).contains(board[x][y] - '0'))
                        return false;
                    else
                        cubes.get((x/3)*3+y/3).add(board[x][y] - '0');
                }

            }

        }

        return true;
    }
}
