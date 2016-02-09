/**
 * Created by qixuanwang on 15/8/24.
 */
public class Leetcode8 {

    public static void main(String[] args) {

        System.out.println(myAtoi2("-2147483647"));

    }

    public static int myAtoi2(String str) {
        int max = Integer.MAX_VALUE;
        int min = Integer.MIN_VALUE;

        str = str.trim();

        int len =str.length();

        if(len==0 || (len==1 && (str.charAt(0)=='-' || str.charAt(0)=='+')))
            return 0;
        if(str.charAt(0)=='+' || str.charAt(0)=='-'){
            if(str.charAt(1)=='+' || str.charAt(1)=='-'){
                return 0;
            }
        }


        if(str.charAt(0)=='-'){
            int res = 0;
            for(int i=1;i<len;i++){

                if(!Character.isDigit(str.charAt(i)))
                    return -res;

                if(min/10>-res)
                    return min;
                res *= 10;
                if(min+res>=-(str.charAt(i)-'0'))
                    return min;
                res += str.charAt(i)-'0';
            }
            return -res;
        } else{
            int res = 0;
            int i=0;
            if(str.charAt(0)=='+')
                i++;
            for(;i<len;i++){
                if(!Character.isDigit(str.charAt(i)))
                    return res;
                if(max/10<res)
                    return max;
                res *= 10;
                if(max-res<=str.charAt(i)-'0')
                    return max;
                res += str.charAt(i)-'0';
            }
            return res;
        }
    }


    public static int myAtoi(String str) {
        if(str==null)
            return 0;


        int len = str.length();
        if(len==0)
            return 0;


        int idx = 0;
        int sign = 1;

        //Cut Whitespace
        while(str.charAt(idx)==' ')
            idx++;
        //If positive
        if(str.charAt(idx)=='+')
            idx++;
        //If negative
        else if(str.charAt(idx)=='-'){
            sign = -1;
            idx++;
        }
        //
        int sum = 0;

        if(sign>0){
            while(idx<len && str.charAt(idx)>='0' && str.charAt(idx)<='9'){

                if(sum/1000000000!=0)
                    return Integer.MAX_VALUE;
                sum*=10;
                sum += str.charAt(idx)-'0';
                if(sum<0)
                    return Integer.MAX_VALUE;
                idx++;
            }
        }
        else{
            while(idx<len && str.charAt(idx)>='0' && str.charAt(idx)<='9'){

                if(sum/1000000000!=0)
                    return Integer.MIN_VALUE;
                sum*=10;
                sum -= str.charAt(idx)-'0';
                if(sum>0)
                    return Integer.MIN_VALUE;
                idx++;
            }
        }

        return sum;

    }
}
