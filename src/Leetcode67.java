/**
 * Created by qixuanwang on 15/9/15.
 */
public class Leetcode67 {

    public static void main(String[] args) {

        System.out.println(addBinary("0","0"));
    }

    public static String addBinary(String a, String b) {

        int aLen = a.length();
        int bLen = b.length();

        int len = Math.max(aLen, bLen);

        StringBuffer res = new StringBuffer("");
        int flow = 0;
        for(int i=0;i<len;i++){
            int digitA = 0;
            int digitB = 0;
            if(i<aLen){
                digitA = a.charAt(aLen-1-i) - '0';
            }
            if(i<bLen){
                digitB = b.charAt(bLen-1-i) - '0';
            }
            int sum = digitA + digitB + flow;
            flow = sum / 2;
            res.append(sum%2+"");
        }

        if(flow!=0)
            res.append(flow+"");

        return res.reverse().toString();
    }
}
