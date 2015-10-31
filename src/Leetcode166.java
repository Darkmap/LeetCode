import java.util.HashMap;

/**
 * Created by qixuanwang on 15/10/29.
 */
public class Leetcode166 {

    public static void main(String[] args) {
        System.out.println(fractionToDecimal(30,11));
    }

    public static String fractionToDecimal(int numerator, int denominator) {

        boolean negative = (numerator>0 && denominator<0) || (numerator<0 && denominator>0);

        long numeratorL = Math.abs((long)numerator);
        long denominatorL = Math.abs((long)denominator);


        StringBuilder res = new StringBuilder();
        long p0 = numeratorL/denominatorL;
        numeratorL = numeratorL % denominatorL;

        HashMap<Long,Integer> map = new HashMap<>();

        if(numeratorL==0)
            res.append(p0);
        else{

            res.append(p0+".");

            int repeatIdx = 0;
            while(numeratorL!=0){

                numeratorL *= 10;
                long p = numeratorL/denominatorL;
                if(!map.containsKey(numeratorL)){
                    res.append(p);
                    map.put(numeratorL,repeatIdx++);
                }
                else{
                    int leftIdx = res.indexOf(".")+map.get(numeratorL)+1;
                    res.insert(leftIdx,"(");
                    res.append(")");
                    break;
                }
                numeratorL %= denominatorL;
            }

        }

        if(negative)
            res.insert(0,"-");
        return res.toString();
    }
}
