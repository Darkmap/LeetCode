/**
 * Created by qixuanwang on 15/8/23.
 */
public class Leetcode5 {

    public static void main(String[] args){

        System.out.println(longestPalindrome4("ccc"));
    }


    public static String longestPalindrome4(String s) {

        int len = s.length();

        if(len==0)
            return "";

        if(len==1)
            return s;


        boolean[][] dp = new boolean[len][len];
        int max = 0;
        int b = 0;
        int e = 0;

        for(int i=0;i<len;i++){
            for(int j=0;j<=i;j++){
                if((i-j<2 || dp[j+1][i-1]) && s.charAt(i)==s.charAt(j)){
                    dp[j][i] = true;
                    if(i-j+1>max){
                        max = i-j+1;
                        b = j;
                        e = i+1;
                    }
                }
            }
        }

        return s.substring(b,e);
    }

    public static String longestPalindrome3(String s) {

        int len = s.length();

        if(len==0)
            return "";

        if(len==1)
            return s;

        int[][] dp = new int[len][len];
        int max = 0;
        int b = 0;
        int e = 0;
        for(int i=0;i<len;i++){
            if(s.charAt(0)==s.charAt(len-i-1)){
                dp[0][i] = 1;
            }
            if(s.charAt(i)==s.charAt(len-1)){
                dp[i][0] = 1;
            }
        }

        for(int i=1;i<len;i++){
            for(int j=1;j<len;j++){
                if(s.charAt(i)==s.charAt(len-j-1)){
                    dp[i][j] = 1+dp[i-1][j-1];
                    if(dp[i][j]>max){
                        max = dp[i][j];
                        b = i-max+1;
                        e = i+1;
                    }
                }
            }
        }

        return s.substring(b,e);
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
