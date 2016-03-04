import java.util.HashMap;
import java.util.HashSet;

/**
 * Created by qixuanwang on 16/3/2.
 */
public class Leetcode291 {

    boolean find = false;


    public static void main(String[] args) {

        Leetcode291 lt = new Leetcode291();
        System.out.println(lt.wordPatternMatch("abab","redblueredblue"));
    }


    public boolean wordPatternMatch(String pattern, String str) {

        int plen = pattern.length();
        int slen = str.length();

        if(plen==0 && slen==0)
            return true;

        HashMap<Character,String> map = new HashMap<>();
        HashSet<String> set = new HashSet<>();

        helper(pattern,0,str,0,map,set);

        return find;
    }

    public void helper(String pattern, int p, String str, int s, HashMap<Character,String> map,HashSet<String> set){

        if(find)
            return;

        int plen = pattern.length();
        int slen = str.length();

        if(p==plen && s==slen){
            find = true;
            return;
        } else if(p>=plen || s>=slen){
            return;
        }

        char pc = pattern.charAt(p);
        if(map.containsKey(pc)){
            String decode = map.get(pc);
            int dlen = decode.length();
            if(s+dlen>slen)
                return;
            if(str.substring(s,s+dlen).equals(decode)){
                helper(pattern,p+1,str,s+dlen,map,set);
            } else{
                return;
            }
        } else{
            for(int l=1;l+s<=slen;l++){
                String decode = str.substring(s,s+l);
                if(!set.contains(decode)){
                    HashMap<Character,String> newMap = new HashMap<>(map);
                    HashSet<String> newSet = new HashSet<>(set);
                    newMap.put(pc,decode);
                    newSet.add(decode);
                    helper(pattern,p+1,str,s+l,newMap,newSet);
                }
            }
        }
    }
}
