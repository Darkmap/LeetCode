import java.util.LinkedList;

/**
 * Created by qixuanwang on 15/10/4.
 */
public class Leetcode130 {

    public static void main(String[] args) {


    }

    public void solve(char[][] board) {

        int xLen = board.length;
        if(xLen<=1)
            return;
        int yLen = board[0].length;
        if(yLen<=1)
            return;

        for(int i=0;i<yLen;i++){
            fill(board,0,i,xLen,yLen);
            fill(board,xLen-1,i,xLen,yLen);
        }
        for(int i=0;i<xLen;i++){
            fill(board,i,0,xLen,yLen);
            fill(board,i,yLen-1,xLen,yLen);
        }

        for(int x=0;x<xLen;x++){
            for(int y=0;y<yLen;y++){

                if(board[x][y]=='O')
                    board[x][y]='X';
                else if(board[x][y]=='*')
                    board[x][y]='O';
            }
        }
    }

    public static void fill(char[][] board, int x, int y, int xLen, int yLen){

        if(board[x][y]!='O')
            return;

        board[x][y]='*';
        LinkedList<Integer> open = new LinkedList<>();
        open.offer(x*yLen+y);
        while(!open.isEmpty()){
            int cur = open.poll();
            int i=cur/yLen;
            int j=cur%yLen;
            if(i-1>=0 && board[i-1][j]=='O'){
                open.offer((i-1)*yLen+j);
                board[i-1][j]='*';
            }
            if(i+1<xLen && board[i+1][j]=='O'){
                open.offer((i+1)*yLen+j);
                board[i+1][j]='*';
            }
            if(j-1>=0 && board[i][j-1]=='O'){
                open.offer(i*yLen+j-1);
                board[i][j-1]='*';
            }
            if(j+1<yLen && board[i][j+1]=='O'){
                open.offer(i*yLen+j+1);
                board[i][j+1]='*';
            }
        }
    }
}
