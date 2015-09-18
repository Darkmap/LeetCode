/**
 * Created by qixuanwang on 15/9/16.
 */
public class Leetcode69 {

    public static void main(String[] args) {

        System.out.println(mySqrt(2147395599));
    }

    public static int mySqrt(int x) {

        if(x==0)
            return 0;
        else if(x<4)
            return 1;
        else{

            int begin = 1;
            int end = x/2;

            while(begin<end){
                long mid = (begin+end) / 2;
                if(mid*mid > Integer.MAX_VALUE)
                    end = (int)mid;
                else if(mid*mid==x)
                    return (int)mid;
                else if(mid*mid >x || mid*mid < mid){
                    end = (int)mid;
                }
                else{
                    begin = (int)mid+1;
                }
            }

            //利用 X/res 和 res比较的方法,可以避免overflow问题!!!
            if(begin>x/begin)
                return begin-1;
            else
                return end;

        }

    }
}
