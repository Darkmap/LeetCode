/**
 * Created by qixuanwang on 15/11/3.
 */
public class Leetcode191 {

    public static void main(String[] args) {
        System.out.println(hammingWeight(1));
    }

    public static int hammingWeight(int n) {
        int count = 0;
        for (int i = 0; i < 32; i++) {
            count += (n & 1);
            n = n >>> 1;
        }
        return count;
    }
}
