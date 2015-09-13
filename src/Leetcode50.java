import java.util.HashMap;

/**
 * Created by qixuanwang on 15/9/10.
 */
public class Leetcode50 {

    public static void main(String[] args) {

        System.out.println(myPow(4, 100));
    }

    public static double myPow(double x, int n) {

        if(x==1)
            return 1;


        if(n==0)
            return 1;
        else if(n<0)
            return 1/myPow(x, -n);
        else{
            HashMap<Integer, Double> powRecord = new HashMap<>();

            return powHelper(x,n,powRecord);
        }

    }

    public static double powHelper(double x, int n, HashMap<Integer, Double> powRecord){


        if(n==1)
            return x;
        else if(n%2==0){
            if(powRecord.containsKey(n-1))
                return powRecord.get(n-1);
            else{
                powRecord.put(n-1,powHelper(x,n/2,powRecord) * powHelper(x,n/2,powRecord));
                return powRecord.get(n-1);
            }
        }
        else{
            if(powRecord.containsKey(n-1))
                return powRecord.get(n-1);
            else{
                powRecord.put(n-1, powHelper(x, n / 2, powRecord) * powHelper(x, n / 2, powRecord) * x);
                return powRecord.get(n-1);
            }
        }
    }
}
