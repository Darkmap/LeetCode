/**
 * Created by qixuanwang on 15/8/25.
 */
public class Leetcode9 {

    public static void main(String[] args){

        System.out.println(isPalindrome(123321));
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
