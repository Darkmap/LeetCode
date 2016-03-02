import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

/**
 * Created by qixuanwang on 16/3/1.
 */
public class Permutations {

    public static void main(String[] args) {

        char[] chars = {'a','m','r','y','r'};
        for(String str: permutations(chars)){
            System.out.println(str);
        }
    }

    public static List<String> permutations(char[] chars){

        List<String> res = new ArrayList<>();

        HashMap<Character, Integer> map = new HashMap<>();
        for(char c: chars){
            if(map.containsKey(c)){
                map.put(c,map.get(c)+1);
            } else{
                map.put(c,1);
            }
        }

        List<Character> keys = new ArrayList<>();
        keys.addAll(map.keySet());
        Collections.sort(keys);

        helper(res,map,keys,"");

        return res;
    }

    public static void helper(List<String> res, HashMap<Character, Integer> map,
                       List<Character> keys, String pre){
        if(map.isEmpty()){
            res.add(pre);
            return;
        }

        for(char c: keys){
            if(map.containsKey(c)){
                HashMap<Character, Integer> newMap = new HashMap<>(map);
                int count = newMap.get(c);
                count--;
                if(count==0){
                    newMap.remove(c);
                } else{
                    newMap.put(c,count);
                }
                helper(res,newMap,keys,pre+c);
            }
        }
    }
}
