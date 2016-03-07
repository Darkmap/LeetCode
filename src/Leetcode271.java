import java.util.ArrayList;
import java.util.List;

/**
 * Created by qixuanwang on 16/3/6.
 */
public class Leetcode271 {

    public static void main(String[] args) {

        List<String> strs = new ArrayList<>();
        strs.add("");

        System.out.println(decode(encode(strs)));
    }

    // Encodes a list of strings to a single string.
    public static String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder("");
        for(String str: strs){
            int len = str.length();
            sb.append("_"+len+"_");
            sb.append(str);
        }
        return sb.toString();
    }

    // Decodes a single string to a list of strings.
    public static List<String> decode(String s) {

        List<String> res = new ArrayList<>();

        int idx = 0;
        int len = s.length();

        while(idx<len){
            idx++;
            int clen = 0;
            while(Character.isDigit(s.charAt(idx))){
                clen *= 10;
                clen += s.charAt(idx)-'0';
                idx++;
            }
            idx++;

            if(clen==0){
                res.add("");
            } else{
                res.add(s.substring(idx,idx+clen));
                idx = idx+clen;
            }
        }

        return res;
    }
}
