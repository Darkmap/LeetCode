/**
 * Created by qixuanwang on 15/11/3.
 */
public class Leetcode190 {

    public static void main(String[] args) {

        System.out.println(reverseBits(43261596));
    }

    public static int reverseBits(int n) {

        int result = 0;

        for(int i=0;i<32;i++){

            int digit = n%2;
            result<<=1;
            result |= digit;
            n>>>=1;
        }

        return result;
    }
}
