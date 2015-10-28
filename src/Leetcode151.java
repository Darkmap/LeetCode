/**
 * Created by qixuanwang on 15/10/28.
 */
public class Leetcode151 {

    public static void main(String[] args) {

        String a = " ";

        System.out.println(reverseWords(a));
    }

    public static String reverseWords(String s) {
        s = trim(s);

        StringBuffer res = new StringBuffer("");
        String[] tokens = s.split(" ");

        for(int i=tokens.length-1;i>=0;i--){
            if(tokens[i].length()>0){
                res.append(tokens[i]);
                if(i!=0)
                    res.append(" ");
            }
        }
        return res.toString();
    }

    public static String trim(String s){
        if(s.length()<1)
            return s;

        while(s.length()>0 && s.charAt(0)==' '){
            s = s.substring(1);
        }
        while(s.length()>0 && s.charAt(s.length()-1)==' '){
            s = s.substring(0, s.length()-1);
        }
        return s;
    }
}
