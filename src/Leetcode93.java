import java.util.LinkedList;
import java.util.List;

/**
 * Created by qixuanwang on 15/9/22.
 */
public class Leetcode93 {

    public static void main(String[] args) {

        List<String> res = restoreIpAddresses("010010");

        for(String s: res){
            System.out.println(s);
        }

    }

    public static List<String> restoreIpAddresses(String s) {

        List<String> res = new LinkedList<>();

        int len = s.length();
        if(len<4){
            return res;
        }

        ipParserHelper(res, 0, s, "", 4);

        return res;
    }

    public static void ipParserHelper(List<String> res, int offSet, String s, String preStr, int count){

        int len = s.length();
        int validLen = len-offSet;

        if(validLen==0 && count==0){
            res.add(preStr);
            return;
        }
        else if(validLen <count || validLen >3*count){
            return;
        }
        else if(validLen == count){
            String newPre = preStr + s.substring(offSet, offSet+1);
            if(count>1)
                newPre = newPre + ".";
            ipParserHelper(res, offSet+1, s,newPre, count-1);
        }
        else if(validLen == count+1){

            String newPre = preStr + s.substring(offSet, offSet+1);
            if(count>1)
                newPre = newPre + ".";
            ipParserHelper(res, offSet+1, s,newPre, count-1);


            if(!s.substring(offSet,offSet+1).equals("0")) {
                newPre = preStr + s.substring(offSet, offSet + 2);
                if (count > 1)
                    newPre = newPre + ".";
                ipParserHelper(res, offSet + 2, s, newPre, count - 1);
            }
        }
        else if(validLen >= count+2){

            String newPre = preStr + s.substring(offSet, offSet+1);
            if(count>1)
                newPre = newPre + ".";
            ipParserHelper(res, offSet+1, s,newPre, count-1);


            if(!s.substring(offSet,offSet+1).equals("0")){

                newPre = preStr + s.substring(offSet, offSet+2);
                if(count>1)
                    newPre = newPre + ".";
                ipParserHelper(res, offSet + 2, s, newPre, count - 1);

                String threeDig = s.substring(offSet, offSet+3);
                if(Integer.valueOf(threeDig)<=255){
                    newPre = preStr + threeDig;
                    if(count>1)
                        newPre = newPre + ".";
                    ipParserHelper(res, offSet+3, s,newPre, count-1);
                }
            }

        }
    }
}
