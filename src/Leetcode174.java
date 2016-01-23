/**
 * Created by qixuanwang on 16/1/21.
 */
public class Leetcode174 {

    public static void main(String[] args) {

        int[][] dungeon = {{1,-3,3},{0,-2,0},{-3,-3,-3}};
        System.out.println(calculateMinimumHP(dungeon));

    }

    public static int calculateMinimumHP(int[][] dungeon) {

        int xlen = dungeon.length;
        if(xlen==0)
            return 0;
        int ylen = dungeon[0].length;
        if(ylen==0)
            return 0;

        int[][] dp = new int[xlen][ylen];
        dp[xlen-1][ylen-1] = Math.max(1, 1-dungeon[xlen-1][ylen-1]);

        for(int i=xlen-2;i>=0;i--){
            dp[i][ylen-1] = Math.max(dp[i+1][ylen-1]-dungeon[i][ylen-1],1);
        }
        for(int i=ylen-2;i>=0;i--){
            dp[xlen-1][i] = Math.max(dp[xlen-1][i+1]-dungeon[xlen-1][i],1);
        }

        for(int i=xlen-2;i>=0;i--){
            for(int j=ylen-2;j>=0;j--){
                int val = Math.min(dp[i+1][j],dp[i][j+1]);
                dp[i][j] = Math.max(val-dungeon[i][j],1);
            }
        }

        return dp[0][0];

    }
}
