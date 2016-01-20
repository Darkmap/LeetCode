/**
 * Created by qixuanwang on 16/1/19.
 */
public class Leetcode132 {

    public static void main(String[] args) {
        System.out.println(minCut("bbe"));
    }

    public static int minCut(String s) {
        int len = s.length();
        if(len<=1)
            return 0;

        boolean[][] isPal = new boolean[len][len];

        for(int i=len-1;i>=0;i--){
            for(int j=i;j<len;j++){
                if(j-i<=1){
                    isPal[i][j] = (s.charAt(i)==s.charAt(j));
                }
                if(i+1<len && j-1>=0 && isPal[i+1][j-1] && s.charAt(i)==s.charAt(j))
                    isPal[i][j]=true;
            }
        }

        int[] dp = new int[len];
        for(int i=0;i<dp.length;i++)
            dp[i]=i;

        for(int i=0;i<len;i++){
            for(int j=i;j>=0;j--){
                if(isPal[j][i]){
                    if(j-1<0)
                        dp[i] = 0;
                    else
                        dp[i] = Math.min(dp[i],dp[j-1]+1);
                }
            }
        }

        return dp[len-1];
    }
}
