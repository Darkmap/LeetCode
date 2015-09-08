/**
 * Created by qixuanwang on 15/8/24.
 */
public class Leetcode7 {


    public static void main(String[] args){
        System.out.println(Integer.MAX_VALUE);
        System.out.println(Integer.MIN_VALUE);
        System.out.println(reverse(-2147483648));
    }

    public static int reverse(int x) {
        if(x<0){
            long sum = 0;
            while(x!=0){
                sum *= 10;
                sum += x%10;
                x /= 10;
            }
            int output;
            if((sum) < (long)Integer.MIN_VALUE)
                output=0;
            else
                output = (int)sum;
            return output;
        }
        else if(x>0){
            long sum = 0;
            while(x!=0){
                sum *= 10;
                sum += x%10;
                x /= 10;
            }
            int output;
            if(sum>(long)Integer.MAX_VALUE)
                output=0;
            else
                output = (int)sum;
            return output;
        }
        else{
            return 0;
        }
    }
}
