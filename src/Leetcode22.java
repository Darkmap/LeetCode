import java.util.ArrayList;
import java.util.List;

/**
 * Created by qixuanwang on 15/8/28.
 */
public class Leetcode22 {

    public static void main(String[] args) {

        System.out.println(generateParenthesis(2));
    }

    public static List<String> generateParenthesis(int n) {

        return generateRecursively("",n,n);
    }

    public static List<String> generateRecursively(String prefix, int p1, int p2){
        List<String> list = new ArrayList<String>();
        if(p1==0 && p2==0){
            list.add(prefix);
            return list;
        }
        else if(p1==0 && p2!=0){
            while(p2!=0){
                prefix = prefix+")";
                p2--;
            }
            list.add(prefix);
            return list;
        }
        else{
            if(p1<p2){
                String tmp = prefix+"(";
                list.addAll(generateRecursively(tmp, p1-1, p2));

                tmp = prefix+")";
                list.addAll(generateRecursively(tmp,p1,p2-1));
            }
            else{
                prefix = prefix+"(";
                list.addAll(generateRecursively(prefix,p1-1,p2));
            }
        }

        return list;
    }
}
