import java.util.HashMap;

/**
 * Created by qixuanwang on 16/2/26.
 */
public class Leetcode266 {

    public static void main(String[] args) {

        System.out.println(canPermutePalindrome("a"));
    }

    public static boolean canPermutePalindrome(String s) {

        HashMap<Character, Integer> map = new HashMap<>();
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if(map.containsKey(c)){
                map.put(c,map.get(c)+1);
            } else{
                map.put(c,1);
            }
        }

        int odd = 0;
        for(char key: map.keySet()){
            if(map.get(key) % 2==1){
                odd++;
                if(odd>1)
                    return false;
            }
        }

        return true;
    }
}
