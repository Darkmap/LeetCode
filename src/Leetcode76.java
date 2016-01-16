import java.util.HashMap;

/**
 * Created by qixuanwang on 16/1/16.
 */
public class Leetcode76 {

    public static void main(String[] args) {
        System.out.print(minWindow("ABC","ABC"));
    }

    public static String minWindow(String s, String t) {
        int len1 = s.length();
        int len2 = t.length();

        if(len1==0 || len2==0)
            return "";

        int begin = -1;
        int end = 0;

        HashMap<Character, Integer> srcmap = new HashMap<>();
        for(char c: t.toCharArray()){
            if(srcmap.containsKey(c))
                srcmap.put(c,srcmap.get(c)+1);
            else
                srcmap.put(c,1);
        }

        HashMap<Character, Integer> map = new HashMap<>();

        int match = 0;
        int start = 0;
        int minLen = len1+1;

        for(int i=0;i<len1;i++){

            char c = s.charAt(i);

            if(srcmap.containsKey(c)){
                if(map.containsKey(c))
                    map.put(c,map.get(c)+1);
                else
                    map.put(c,1);

                if(map.get(c)<=srcmap.get(c))
                    match++;
                if(match==len2){
                    while(start<i && (!srcmap.containsKey(s.charAt(start)) || map.get(s.charAt(start)) > srcmap.get(s.charAt(start)))){
                        if(map.containsKey(s.charAt(start)))
                            map.put(s.charAt(start),map.get(s.charAt(start))-1);
                        start++;
                    }

                    if(i-start+1 < minLen){
                        minLen = i-start+1;
                        begin = start;
                        end = i;
                    }

                    map.put(s.charAt(start),map.get(s.charAt(start))-1);
                    match--;
                    start++;
                }
            }

        }

        return begin == -1 ? "" : s.substring(begin,end + 1);
    }
}
