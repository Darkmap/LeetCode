/**
 * Created by qixuanwang on 16/1/23.
 */
public class Leetcode214 {

    public static void main(String[] args) {

        System.out.println(shortestPalindrome("aacecaaa"));
    }

    public static String shortestPalindrome(String s) {

        StringBuilder sb = new StringBuilder(s);
        String comb = s+" "+sb.reverse().toString();

        int sl = s.length();
        int cl = comb.length();

        int[] next = new int[cl];

        for(int i=1;i<cl;i++){

            int k = next[i-1];
            while(k>0 && comb.charAt(k)!=comb.charAt(i)){
                k = next[k-1];
            }
            if(comb.charAt(k)==comb.charAt(i)){
                next[i] = k+1;
            }
            else
                next[i] = 0;
        }

        int start = next[cl-1];
        System.out.println(start);
        String res = new String(s);
        for(int i=start;i<sl;i++){
            res = s.charAt(i)+res;
        }

        return res;
    }
}
