/**
 * Created by qixuanwang on 15/8/23.
 */
public class Leetcode5 {

    public static void main(String[] args){

        System.out.println(longestPalindrome2("aaabba"));
    }



    public static String longestPalindrome2(String s) {

        String palindrome = "";
        int maxLen = 0;
        int len = s.length();
        for(int i=0;i<len;i++){
            if(i-maxLen-1>=0){
                String tmpStr = s.substring(i-maxLen-1,i+1);
                if(isPalindrome(tmpStr)) {
                    maxLen += 2;
                    palindrome = new String(tmpStr);
                }
            }
            if(i-maxLen>=0){
                String tmpStr = s.substring(i-maxLen,i+1);
                if(isPalindrome(tmpStr)) {
                    maxLen += 1;
                    palindrome = new String(tmpStr);
                }
            }
        }

        return palindrome;

    }

    public static boolean isPalindrome(String s){
        int len = s.length();
        int begin = 0, end = len-1;
        while(begin<end){
            if(s.charAt(begin)==s.charAt(end)){
                begin++;
                end--;
            }
            else
                return false;
        }
        return true;
    }


    public static String longestPalindrome(String s) {

        int maxLength = 0;
        int maxX = 0;

        int len = s.length();
        int[][] dp = new int[len][len];
        for(int x=0;x<len;x++){
            for(int j=0;j<len;j++){

                int y = len-1-j;

                if(s.charAt(x)==s.charAt(y)){
                    if(x>0&&j>0){
                        dp[x][j]=dp[x-1][j-1]+1;
                    }
                    else
                        dp[x][j]=1;
                }
                else
                    dp[x][j]=0;
                if(maxLength<dp[x][j]) {
                    maxLength = dp[x][j];
                    maxX = x;
                }
            }
        }

        if(maxLength==0)
            return "";
        else{
            return s.substring(maxX+1-maxLength, maxX+1);
        }

    }
}
