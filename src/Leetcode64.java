/**
 * Created by qixuanwang on 15/9/15.
 */
public class Leetcode64 {

    public static void main(String[] args) {


        int[][] grid = {{1,2},{1,1}};

        System.out.println(minPathSum(grid));
    }

    public static int minPathSum(int[][] grid) {

        int m = grid.length;
        int n = 0;
        if(m>0)
            n = grid[0].length;
        else
            return n;

        int[][] resMatrix = new int[m][n];

        return minPathHelper(grid, resMatrix, m-1, n-1);

    }

    public static int minPathHelper(int[][] grid, int[][] resMatrix, int x, int y){

        if(x==0 && y==0)
            return grid[0][0];
        else if(resMatrix[x][y]!=0)
            return resMatrix[x][y];
        else if(x==0)
            return resMatrix[x][y] = minPathHelper(grid, resMatrix, x, y-1) + grid[x][y];
        else if(y==0)
            return resMatrix[x][y] = minPathHelper(grid, resMatrix, x-1, y) + grid[x][y];
        else
            return resMatrix[x][y] = Math.min(minPathHelper(grid, resMatrix, x, y-1),
                    minPathHelper(grid, resMatrix, x-1, y)) + grid[x][y];
    }
}
