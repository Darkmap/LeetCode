import java.util.ArrayList;
import java.util.List;

/**
 * Created by qixuanwang on 16/1/26.
 */
public class Leetcode301 {

    public static void main(String[] args) {
        for(String str: removeInvalidParentheses("(((k()((")){
            System.out.println(str);
        }
    }

    public static List<String> removeInvalidParentheses(String s) {
        List<String> res = new ArrayList<>();
        helper(res,s,0,0,new char[]{'(',')'});
        return res;
    }

    public static void helper(List<String> res, String s, int pre_i, int pre_j, char[] par){
        int count = 0;

        int len = s.length();
        for(int i=pre_i;i<len;i++){
            if(s.charAt(i)==par[0]) count++;
            if(s.charAt(i)==par[1]) count--;
            if(count<0){
                for(int j=pre_j;j<=i;j++){
                    if(s.charAt(j)==par[1] && (j==pre_j || s.charAt(j-1)!=par[1])){
                        helper(res,s.substring(0,j)+s.substring(j+1,len),i,j,par);
                    }
                }
                return;
            }
        }

        String reversed = new StringBuilder(s).reverse().toString();
        if(par[0]=='(')
            helper(res,reversed,0,0,new char[]{')','('});
        else
            res.add(reversed);
    }

}
