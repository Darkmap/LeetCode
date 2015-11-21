/**
 * Created by qixuanwang on 15/11/21.
 */
public class Leetcode37 {

    public static void main(String[] args) {

    }

    public void solveSudoku(char[][] board) {

        int[][] rows = new int[9][9];
        int[][] cols = new int[9][9];
        int[][] grids = new int[9][9];

        //We have to do it here, because we cannot deal it in the search process.
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                if(board[i][j]!='.'){
                    int gridIdx = (i/3)*3+j/3;
                    int val = board[i][j]-'1';
                    rows[i][val]=1;
                    cols[j][val]=1;
                    grids[gridIdx][val]=1;
                }
            }
        }

        sudokuHelper(board, rows, cols, grids, 0, 0);

    }

    public boolean sudokuHelper(char[][] board, int[][] rows, int[][] cols, int[][] grids, int x, int y){

        for(int i=x;i<9;i++){
            //We should start from 0, because nextline will start at j2 when we use j2=j+1 to initialize the y
            //and if we do the if(i==x) y start from j2, else y start from 0, it will cost more time to check it.
            for(int j=0;j<9;j++){

                if(board[i][j]=='.'){
                    for(int v=0;v<9;v++){
                        if(sudoKuCheck(v, board, rows, cols, grids, i, j)){
                            board[i][j] = (char)('1'+v);
                            int gridIdx = (i/3)*3+j/3;
                            rows[i][v]=1;
                            cols[j][v]=1;
                            grids[gridIdx][v]=1;
                            int i2 = i;
                            if(j==8){
                                i2++;
                            }
                            if(sudokuHelper(board, rows, cols, grids, i2, 0)){
                                return true;
                            }
                            else{
                                board[i][j] = '.';
                                rows[i][v]=0;
                                cols[j][v]=0;
                                grids[gridIdx][v]=0;
                            }
                        }
                    }
                    //if 1-9 all cannot match, its false. And because we don't set anything, so no need reset any '.'.
                    return false;
                }
            }
        }

        return true;
    }

    public boolean sudoKuCheck(int val ,char[][] board, int[][] rows, int[][] cols, int[][] grids, int x, int y){

        int gridIdx = (x/3)*3+y/3;

        if(rows[x][val]==1 || cols[y][val]==1 || grids[gridIdx][val]==1)
            return false;
        else
            return true;
    }
}
