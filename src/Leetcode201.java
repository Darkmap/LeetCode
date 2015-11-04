/**
 * Created by qixuanwang on 15/11/3.
 */
public class Leetcode201 {

    public static void main(String[] args) {
        System.out.println(rangeBitwiseAnd(3,5));

//        System.out.println(5 & 3);
    }

    public static int rangeBitwiseAnd(int m, int n) {
        int res = m;
        for(int i=m+1;i<n;i++){
            res &= i;
        }
        return res;
    }
}