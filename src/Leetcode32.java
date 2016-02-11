/**
 * Created by qixuanwang on 16/2/10.
 */
public class Leetcode32 {


    public static void main(String[] args) {

        Leetcode32 lt = new Leetcode32();
        System.out.println(lt.longestValidParentheses("))))((()(("));
    }

    public int longestValidParentheses(String s) {

        int len = s.length();

        if(len<=1)
            return 0;

        int[] dp = new int[len+1];

        int max = 0;

        for(int i=1;i<len;i++){
            int j = i-dp[i]-1;
            if(j>=0)
                dp[i+1] = (s.charAt(i)==')'&&s.charAt(j)=='(')? dp[i]+2+dp[j] : 0;
            max = Math.max(max,dp[i+1]);
        }
        return max;
    }
}
