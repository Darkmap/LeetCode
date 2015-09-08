/**
 * Created by qixuanwang on 15/8/25.
 */
public class Leetcode14 {

    public static void main(String[] args){

        String[] strs = {"a","b"};
        System.out.println(longestCommonPrefix(strs));
    }
    public static String longestCommonPrefix(String[] strs) {

        if(strs.length==0)
            return "";

        int len = 0;

        do{
            if(strs[0].length()<len+1)
                break;
            char tmp = strs[0].charAt(len);
            boolean flag = true;
            for(int i=1;i<strs.length;i++){
                if(strs[i].length()<len+1){
                    flag = false;
                    break;
                }
                if(tmp!=strs[i].charAt(len)){
                    flag = false;
                    break;
                }
            }
            if(flag){
                len++;
            }
            else
                break;
        }while(true);

        return strs[0].substring(0,len);
    }
}
