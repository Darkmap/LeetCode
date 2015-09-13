/**
 * Created by qixuanwang on 15/9/13.
 */
public class Leetcode58 {

    public static void main(String[] args) {

        String a= "hello world ";
        String[] as = a.split(" ");

        System.out.println(as.length);

        for(String str: as){
            System.out.println(str);
        }
    }

    public static int lengthOfLastWord(String s) {

        String[] tokens = s.split(" ");
        int len = tokens.length;
        if(len<=0)
            return 0;
        else{
            return tokens[len-1].length();
        }
    }
}
