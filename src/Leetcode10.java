/**
 * Created by qixuanwang on 16/2/7.
 */
public class Leetcode10 {

    public static void main(String[] args) {

        Leetcode10 lt = new Leetcode10();
        System.out.println(lt.isMatch2("aaa", "ab*a"));
    }

    public boolean isMatch2(String s, String p) {
        int ls = s.length();
        int lp = p.length();

        boolean[][] dp = new boolean[ls+1][lp+1];
        dp[0][0] = true;

        for(int i=0;i<=ls;i++){
            //When i!=0, j==0 can never be matched
            for(int j=1;j<=lp;j++){
                if(p.charAt(j-1)!='*'){
                    //When jth of p is not *, the ith and jth have to be matched, and i==0 is not acceptable
                    if(i>0 && (s.charAt(i-1)==p.charAt(j-1) || p.charAt(j-1)=='.') && dp[i-1][j-1]){
                        dp[i][j] = true;
                    }
                } else{
                    //when jth is *, j couldn't be 0
                    if(j>1){
                        if(dp[i][j-2] || dp[i][j-1]){
                            //When jth is *, j-1,j could be used to match 0 or 1 token
                            dp[i][j] = true;
                        } else{
                            //When jth is *, j-1,j could be used to match more than 1 tokens
                            if(i>0 && dp[i-1][j] && (s.charAt(i-1)==p.charAt(j-2) || p.charAt(j-2)=='.')){
                                dp[i][j] = true;
                            }
                        }
                    }
                }
            }
        }

        return dp[ls][lp];
    }


    public boolean isMatch(String s, String p) {
        return helper(s,0,p,0);
    }

    public boolean helper(String s, int is, String p, int ip){
        int ls = s.length();
        int lp = p.length();

        if(is==ls && ip==lp){
            return true;
        }

        if(is==ls){
            while(is<ls){
                if(is+1<ls){
                    is++;
                    if(s.charAt(is)=='*'){
                        is++;
                    } else{
                        return false;
                    }
                } else{
                    return false;
                }
            }
            return true;
        } else if(ip==lp){
            return false;
        } else{


            if(ip+1<lp && p.charAt(ip+1)=='*'){
                //When P can be zero or one or more than one
                //If dont want p be zero
                if(helper(s,is,p,ip+2))
                    return true;
            }

            if(p.charAt(ip)==s.charAt(is) || p.charAt(ip)=='.'){
                //If want match this s's bit
                if(ip+1<lp && p.charAt(ip+1)=='*'){
                    //When P can be zero or one or more than one
                    //If want p be more than one
                    if(helper(s,is+1,p,ip)){
                        return true;
                    }
                    //If want p be one
                    if(helper(s,is+1,p,ip+2)){
                        return true;
                    }
                } else{
                    //Usual case
                    if(helper(s,is+1,p,ip+1)){
                        return true;
                    }
                }
            }

        }

        return false;
    }
}
