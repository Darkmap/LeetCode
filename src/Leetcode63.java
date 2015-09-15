/**
 * Created by qixuanwang on 15/9/15.
 */
public class Leetcode63 {

    public static void main(String[] args) {

        int[][] nums = {{0,0,0},{0,1,0},{0,0,0}};

        System.out.println(uniquePathsWithObstacles(nums));
    }

    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {

        int m = obstacleGrid.length;
        int n = 0;
        if(m<=0)
            return 0;
        else
            n = obstacleGrid[0].length;

        int[][] resMatrix = new int[m][n];

        for(int i=0;i<m;i++)
            for(int j=0;j<n;j++){
                if(obstacleGrid[i][j]==1)
                    resMatrix[i][j]=-1;
                else
                    resMatrix[i][j]=0;
            }

        return solutionHelper(resMatrix, m-1, n-1);
    }

    public static int solutionHelper(int[][] resMatrix, int x, int y) {

        if(resMatrix[x][y] == -1)
            return 0;
        //这里因为可能有"{{1}}, 0"的输入输出case,所以这样安排顺序,私以为其实意义不大
        else if(x==0 && y==0)
            return 1;
        else if(resMatrix[x][y]>0)
            return resMatrix[x][y];
        else if(x==0)
            return resMatrix[x][y] = solutionHelper(resMatrix, x, y-1);
        else if(y==0)
            return resMatrix[x][y] = solutionHelper(resMatrix, x-1, y);
        else
            return resMatrix[x][y] = solutionHelper(resMatrix, x, y-1) + solutionHelper(resMatrix, x-1, y);
    }

}
