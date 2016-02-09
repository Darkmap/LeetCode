/**
 * Created by qixuanwang on 15/8/25.
 */
public class Leetcode9 {

    public static void main(String[] args){

        System.out.println(isPalindrome2(1000021));
    }

    public static boolean isPalindrome2(int x) {

        if(x<0)
            return false;

        if(x/10==0)
            return true;

        int high = 1;

        while(x/high>=10){
            high*=10;
        }

        while(high>0){

            if(x/high!=x%10)
                return false;
            x%=high;
            x/=10;
            high/=100;
        }
        return true;
    }


    public static boolean isPalindrome(int x) {
        if(x<0)
            return false;
        else{

            int sum=0;
            int ori = x;
            while(x!=0){
                sum*=10;
                sum+=(x%10);
                x/=10;
            }
            if(sum==ori)
                return true;
            else
                return false;
        }

    }
}
