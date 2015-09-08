/**
 * Created by qixuanwang on 15/8/24.
 */
public class Leetcode8 {

    public static void main(String[] args) {

        System.out.println(myAtoi("    10522545459"));

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
