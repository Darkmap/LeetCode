import java.util.*;
import java.util.List;

/**
 * Created by qixuanwang on 16/1/20.
 */
public class Leetcode140 {

    public static void main(String[] args) {

        Set<String> set = new HashSet<>();
        set.add("cat");
        set.add("cats");
        set.add("and");
        set.add("sand");
        set.add("dog");
        List<String> res = wordBreak("catsanddog",set);

        for(String line: res)
            System.out.println(line);
    }

    public static List<String> wordBreak(String s, Set<String> wordDict) {

        List<String> res = new ArrayList<>();
        HashMap<Integer,List<String>> map = new HashMap<>();

        helper(s,0,"",res,wordDict,map);

        return res;
    }

    public static void helper(String s, int idx, String pre, List<String> res, Set<String> wordDict,
                       HashMap<Integer,List<String>> map) {
        int len = s.length();
        if(idx==len){
            res.add(pre.substring(1));
            return;
        }

        if(map.containsKey(idx)){
            for(String sol: map.get(idx)){
                String next = pre+sol;
                res.add(next.substring(1));
            }
        }
        else{
            for(int i=idx;i<len;i++){
                String tmp = s.substring(idx,i+1);
                if(wordDict.contains(tmp)){
                    String next = new String(pre+" "+tmp);
                    helper(s,i+1,next,res,wordDict,map);
                }
            }
            if(idx!=0){
                List<String> tmpres = new ArrayList<>();
                int prelen = pre.length();
                for(String sol: res){
                    if(sol.startsWith(pre.substring(1))){
                        tmpres.add(sol.substring(prelen-1));
                    }
                }
                map.put(idx,tmpres);
            }
        }
    }
}
