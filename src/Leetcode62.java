/**
 * Created by qixuanwang on 15/9/15.
 */
public class Leetcode62 {

    public static void main(String[] args) {


    }

    public static int uniquePaths(int m, int n) {

        int[][] resMatrix = new int[m][n];
        return uniquePathHelper(resMatrix, m-1, n-1);
    }

    public static int uniquePathHelper(int[][] resMatrix, int x, int y){

        if(x==0 && y==0)
            return 1;
        else if(resMatrix[x][y]!=0)
            return resMatrix[x][y];
        else if(x==0)
            return resMatrix[x][y] = uniquePathHelper(resMatrix, x, y-1);
        else if(y==0)
            return resMatrix[x][y] = uniquePathHelper(resMatrix, x-1, y);
        else
            return resMatrix[x][y] = uniquePathHelper(resMatrix, x, y-1) +
                    uniquePathHelper(resMatrix, x-1, y);
    }
}
