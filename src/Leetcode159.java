import java.util.HashMap;

/**
 * Created by qixuanwang on 16/3/8.
 */
public class Leetcode159 {

    public static void main(String[] args) {

        System.out.println(lengthOfLongestSubstringTwoDistinct("asdadasads"));
    }


    public static int lengthOfLongestSubstringTwoDistinct(String s) {

        int len = s.length();
        if(len<=2)
            return len;

        HashMap<Character,Integer> map = new HashMap<>();

        int max = 0;

        int start = 0;

        for(int end=start;end<len;end++){
            char c = s.charAt(end);
            if(map.containsKey(c)){
                map.put(c,map.get(c)+1);
            } else{
                map.put(c,1);
                if(map.size()>2){
                    while(start<end){
                        char rc = s.charAt(start++);
                        int count = map.get(rc);
                        count--;
                        if(count==0){
                            map.remove(rc);
                            break;
                        } else{
                            map.put(rc,count);
                        }
                    }
                }
            }

            max = Math.max(max,end-start+1);
        }

        return max;
    }
}
