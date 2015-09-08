import java.util.HashMap;

/**
 * Created by qixuanwang on 15/8/23.
 */
public class LeetCode3 {
    public int lengthOfLongestSubstring(String s) {

        int length = s.length();
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();


        int left=-1, right=0;
        int maxLength = 0;

        for(int i=0;i<length;i++){
            char pointChar = s.charAt(i);
            if(map.containsKey(pointChar)){
                if(right-left>maxLength)
                    maxLength = right-left;
                left = map.get(pointChar);
            }
            
            map.put(pointChar,i);
            right = i;
        }

        return maxLength;
    }
}
