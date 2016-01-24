import java.util.ArrayList;

/**
 * Created by qixuanwang on 16/1/24.
 */
public class Leetcode264 {

    public static void main(String[] args) {
        System.out.println(nthUglyNumber(10));
    }

    public static int nthUglyNumber(int n) {

        ArrayList<Integer> res = new ArrayList<>();
        res.add(1);

        int i1 = 0;
        int i2 = 0;
        int i3 = 0;

        while(res.size()<n){
            int e1 = res.get(i1)*2;
            int e2 = res.get(i2)*3;
            int e3 = res.get(i3)*5;

            int min = Math.min(e1,Math.min(e2,e3));
            if(min==e1) i1++;
            else if(min==e2) i2++;
            else i3++;

            if(min!=res.get(res.size()-1)){
                res.add(min);
            }
        }

        return res.get(n-1);

    }
}
