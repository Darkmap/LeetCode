/**
 * Created by qixuanwang on 15/8/30.
 */
public class Leetcode29 {

    public static void main(String[] args) {

        System.out.println(divide(20, -2));
    }

    public static int divide(int dividend, int divisor) {

        /*
            特例处理
         */
        if(divisor==0)
            return Integer.MAX_VALUE;
        else if(dividend==Integer.MIN_VALUE){
            if(divisor==-1)
                return Integer.MAX_VALUE;
            else if(divisor==1)
                return dividend;
            /*
                被除数是 MIN_VALUE 时,如果取反就overflow了, 鉴于MIN_VALUE是偶数:
                    1) 当除数是奇数时, 因为除数绝对值大于1, 被除数+1不影响结果
                    2) 当除数是偶数是, 被除数和除数同时除2不影响结果
             */
            else
                return ((divisor&1)==1)? divide(dividend+1,divisor) : divide(dividend>>1,divisor>>1);
        }
        else if(divisor==Integer.MIN_VALUE)
            return 0;
        else if(dividend<0 && divisor<0)
            return divide(-dividend,-divisor);
        else if(dividend<0 || divisor<0)
            return -divide(-dividend,divisor);


        /*
            常规位运算
         */

        int res = 0;
        while(dividend>=divisor){
            int tmp = divisor, tmpres = 1;
            /*
                在循环条件里加上,(tmp<<1)) > divisor 是为了防止tmp溢出造成错误的判断:
                    1.因为 dividend 是没有溢出的, 当 tmp 移到溢出时, 实际数值大小 dividend < (tmp<<1),
                    2.仅右移一位时,溢出不可能大于divisor
             */
            while(dividend >= (tmp<<1) && ((tmp<<1)) > divisor){
                tmp <<= 1;
                tmpres <<= 1;
            }
            res += tmpres;
            dividend -= tmp;
        }
        return res;



    }


    /*
        该函数废弃,因为超时,位运算效率比较高
     */
    public static int divide2(int dividend, int divisor) {


        if(divisor==1)
            return dividend;
        else if(divisor==0)
            return Integer.MAX_VALUE;
        else if(dividend==0)
            return 0;
        else{

            if(dividend==Integer.MIN_VALUE){
                if(divisor==-1)
                    return Integer.MAX_VALUE;
                else if(divisor==Integer.MIN_VALUE)
                    return 1;
                else if(divisor<0){
                    int count = 0;
                    while(dividend<=0){
                        dividend-=divisor;
                        count++;
                    }
                    return count-1;
                }
                else{
                    int count = 0;
                    while(dividend<=0){
                        dividend+=divisor;
                        count++;
                    }
                    return -(count-1);
                }

            }
            else{
                if(divisor==Integer.MIN_VALUE)
                    return 0;
                else if(divisor<0){
                    int count = 0;
                    while(dividend>=0){
                        dividend+=divisor;
                        count++;
                    }
                    return -(count-1);
                }
                else{
                    int count = 0;
                    while(dividend>=0){
                        dividend-=divisor;
                        count++;
                    }
                    return count-1;

                }
            }



        }

    }
}
