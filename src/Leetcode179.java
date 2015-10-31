import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * Created by qixuanwang on 15/10/31.
 */
public class Leetcode179 {

    public static void main(String[] args) {

        int[] nums = {121,12};

        System.out.println(largestNumber(nums));
    }

    public static String largestNumber(int[] nums) {
        ArrayList<String> strList = new ArrayList<>();

        int max = 0;

        for(int num: nums){
            if(max<num)
                max = num;
            strList.add(num+"");
        }

        if(max==0)
            return "0";

        Comparator<String> comp = new Comparator<String>() {
            public int compare(String s1, String s2){
                int len1 = s1.length();
                int len2 = s2.length();
                if(len1>len2){
                    if(s1.startsWith(s2))
                        return compare(s1.substring(len2),s2);
                }
                else if(len1<len2){
                    if(s2.startsWith(s1))
                        return compare(s1,s2.substring(len1));
                }
                return s1.compareTo(s2);
            }
        };

        Collections.sort(strList, comp);
        StringBuilder res = new StringBuilder();
        for(String str: strList){
            res.insert(0, str);
        }
        return res.toString();
    }
}
