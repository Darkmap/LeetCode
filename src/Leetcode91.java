/**
 * Created by qixuanwang on 15/9/21.
 */
public class Leetcode91 {

    public static void main(String[] args) {

        System.out.println(numDecodings("1100"));
    }

    public static int numDecodings(String s) {

        int len = s.length();
        if(len==0)
            return 0;
        if(s.charAt(0)=='0')
            return 0;
        if(s.equals("0"))
            return 0;
        if(len==1)
            return 1;
        //这里+1的理由是:下面的处理中DP需要记录终结状态,终结状态的shift是第len+1的
        int[] resMatrix = new int[len+1];

        return numDecHelper(s, 0, resMatrix);
    }

    public static int numDecHelper(String s, int shift, int[] resMatrix){
        int len = s.length();
        if(len<shift+2){
            return 1;
        }
        else if(resMatrix[shift]!=0){
            return resMatrix[shift];
        }
        else{
            if(s.substring(shift,shift+1).equals("0")){
                return 0;
            }
            else if(len>shift+2 && s.substring(shift+2,shift+3).equals("0")){
                int dig = Integer.valueOf(s.substring(shift+1,shift+2));
                if(dig==1 || dig==2)
                    return resMatrix[shift+1] = numDecHelper(s, shift+1, resMatrix);
                else
                    return 0;
            }
            if(s.substring(shift+1,shift+2).equals("0")){
                int dig = Integer.valueOf(s.substring(shift,shift+1));
                if(dig==1 || dig==2)
                    return resMatrix[shift+2] = numDecHelper(s, shift+2, resMatrix);
                else
                    return 0;
            }
            else if (Integer.valueOf(s.substring(shift, shift + 2))>26){
                return resMatrix[shift+1] = numDecHelper(s, shift+1, resMatrix);
            }
            else{
                resMatrix[shift+1] = numDecHelper(s, shift+1, resMatrix);
                resMatrix[shift+2] = numDecHelper(s, shift+2, resMatrix);
                return resMatrix[shift+1] + resMatrix[shift+2];
            }
        }
    }
}
