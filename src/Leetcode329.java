import java.util.Arrays;

/**
 * Created by qixuanwang on 16/1/31.
 */
public class Leetcode329 {

    public static void main(String[] args) {

        int[][] matrix = {{9,9,4},{6,6,8},{2,1,1}};
        System.out.println(longestIncreasingPath(matrix));
    }

    public static int longestIncreasingPath(int[][] matrix) {

        int xlen = matrix.length;
        if(xlen==0)
            return 0;
        int ylen = matrix[0].length;
        if(ylen==0)
            return 0;

        int[] memo = new int[xlen*ylen];
        Arrays.fill(memo, -1);

        int res = 1;
        for(int i=0;i<xlen;i++){
            for(int j=0;j<ylen;j++){
                int ans = dfs(memo, matrix, i, j, Integer.MIN_VALUE);
                res = Math.max(res, ans);
            }
        }
        return res;
    }

    public static int dfs(int[] memo, int[][] matrix, int x, int y, int pre){

        int m = matrix.length;
        int n = matrix[0].length;

        if(x<0 || x>=m || y<0 || y>=n){
            return 0;
        }
        else if(matrix[x][y] <= pre){
            return 0;
        }
        else if(memo[x*n+y]!=-1)
            return memo[x*n+y];
        else{
            int up = dfs(memo, matrix, x-1, y, matrix[x][y]);
            int down = dfs(memo, matrix, x+1, y, matrix[x][y]);
            int left = dfs(memo, matrix, x, y-1, matrix[x][y]);
            int right = dfs(memo, matrix, x, y+1, matrix[x][y]);
            memo[x*n+y] = 1 + Math.max(Math.max(up,down),Math.max(left,right));
            return memo[x*n+y];
        }
    }
}
