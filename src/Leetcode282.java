import java.util.ArrayList;
import java.util.List;

/**
 * Created by qixuanwang on 16/1/24.
 */
public class Leetcode282 {

    public static void main(String[] args) {
        for(String str: addOperators("000",0)){
            System.out.println(str);
        }
    }

    public static List<String> addOperators(String num, long target) {

        int len = num.length();

        long divisor = 1;
        List<String> res = new ArrayList<>();

        if(len==0)
            return res;

        long start = Long.valueOf(num);

        int bit = 1;
        while(bit<=len){

            String ansstr = num.substring(0, bit);

            if(!ansstr.matches("0[0-9]+")){
                long ans = Long.valueOf(ansstr);
                String next = bit==len? "" : num.substring(bit);
                helper(target, 0, ans, ans+"", next, res);
            }
            bit++;
        }

        return res;
    }

    public static void helper(long target, long pr, long cv, String pre, String remain, List<String> res){

        int rlen = remain.length();

        if(pr+cv==target && rlen==0){
            res.add(pre);
            return;
        }
        if(rlen==0){
            return;
        }

        int bit = 1;
        while(bit<=rlen){

            String ansstr = remain.substring(0, bit);

            if(!ansstr.matches("0[0-9]+")){
                long ans = Long.valueOf(ansstr);
                String next = bit==rlen? "" : remain.substring(bit);

                helper(target, pr+cv, ans, pre+"+"+ans, next, res);
                helper(target, pr+cv, -ans, pre+"-"+ans, next, res);
                helper(target, pr, cv*ans, pre+"*"+ans, next, res);
            }
            bit++;
        }
    }
}
