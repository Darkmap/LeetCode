import java.util.ArrayList;
import java.util.List;

/**
 * Created by qixuanwang on 15/10/4.
 */
public class Leetcode131 {


    public static void main(String[] args) {

        List<List<String>> res = partition("aab");
        for(List<String> list: res) {
            for (String str : list)
                System.out.print(str + " ");
            System.out.println();
        }
    }

    public static List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();

        helper(res, new ArrayList<>(), s);
        return res;
    }

    public static void helper(List<List<String>> res, List<String> last, String s){
        int len = s.length();
        if(len==0){
            res.add(last);
        }

        for(int i=1;i<=len;i++){
            List<String> tmp = new ArrayList<>(last);
            String part = s.substring(0, 0 + i);
            if(isPalindrome(part)){
                tmp.add(part);
                helper(res, tmp, s.substring(i));
            }
        }
    }

    public static boolean isPalindrome(String s){
        int len = s.length();
        if(len==1)
            return true;
        int i=0,j=len-1;
        while(i<=j){
            if(s.charAt(i)==s.charAt(j)){
                i++;
                j--;
            }
            else
                return false;
        }
        return true;
    }
}
