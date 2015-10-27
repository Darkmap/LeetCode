import java.util.HashSet;
import java.util.Set;

/**
 * Created by qixuanwang on 15/10/22.
 */
public class Leetcode139 {

    public static void main(String[] args) {

        Set<String> wordDict = new HashSet<>();
        wordDict.add("go");
        wordDict.add("goal");
        wordDict.add("goals");
        wordDict.add("special");

        System.out.println(wordBreak("goalspecial", wordDict));
    }

    public static boolean wordBreak(String s, Set<String> wordDict) {

        int len = s.length();
        boolean[] dp = new boolean[len+1];

        dp[0] = true;

        for(int i=1;i<=len;i++){
            for(int j=0;j<i;j++){
                if(dp[j] && wordDict.contains(s.substring(j,i)))
                    dp[i] = true;
            }
        }
        return dp[len];
    }
}
