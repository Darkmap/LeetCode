/**
 * Created by qixuanwang on 16/1/26.
 */
public class Leetcode319 {

    public static void main(String[] args) {
        System.out.println(bulbSwitch(100));
    }

    public static int bulbSwitch(int n) {
        int count = 1;
        for(int i=2;i<=n;i++){
            boolean on = false;
            for(int j=2;j<i;j++){
                if(i%j==0)
                    on = !on;
            }
            count += on? 1:0;
        }
        return count;
    }
}
