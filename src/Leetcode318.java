import java.util.ArrayList;

/**
 * Created by qixuanwang on 16/1/28.
 */
public class Leetcode318 {

    public static void main(String[] args) {

        String[] words = {"abcw", "baz", "foo", "bar", "xtfn", "abcdef"};
        System.out.println(maxProduct(words));
    }


    public static int maxProduct(String[] words) {
        ArrayList<Unit> list = new ArrayList<>();
        for(String word: words){
            list.add(new Unit(word));
        }

        int len = words.length;
        int max = 0;

        for(int i=0;i<len-1;i++){
            Unit u1 = list.get(i);

            for(int j=i+1;j<len;j++){
                Unit u2 = list.get(j);
                max = Math.max(max, u1.product(u2));
            }
        }

        return max;
    }

}

class Unit{

    int bits;
    int length;

    public Unit(String word){
        this.length = word.length();
        this.bits = 0;
        for(int i=0;i<this.length;i++){
            char cur = word.charAt(i);
            this.bits |= 1<<(cur-'a');
        }
//        System.out.println(Integer.toBinaryString(bits));
    }

    public int product(Unit b){
        if((this.bits & b.bits) ==0)
            return this.length * b.length;
        else
            return 0;
    }
}