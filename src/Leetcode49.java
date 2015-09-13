import java.util.*;
import java.util.List;

/**
 * Created by qixuanwang on 15/9/10.
 */
public class Leetcode49 {

    public static void main(String[] args) {

        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};

        List<List<String>> ans = groupAnagrams(strs);
        for(List<String> list: ans){
            for(String str : list){
                System.out.print(str+" ");
            }
            System.out.println();
        }

    }

    public static List<List<String>> groupAnagrams(String[] strs) {

        HashMap<String, List<String>> map = new HashMap<>();

        for(String str: strs){
            char[] tmp = str.toCharArray();
            Arrays.sort(tmp);
            String key = new String(tmp);
            if(map.containsKey(key))
                map.get(key).add(str);
            else {
                List<String> tmpList = new ArrayList<>();
                tmpList.add(str);
                map.put(key, tmpList);
            }

        }


        List<List<String>> outList = new ArrayList<>();
        for(List<String> list: map.values()){

            Collections.sort(list);
            outList.add(list);
        }


        return outList;
    }
}
