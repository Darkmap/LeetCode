import java.util.*;
import java.util.List;

/**
 * Created by qixuanwang on 15/12/15.
 */
public class Anagram {

    public static void main(String[] args) {
        List<String> res = anagram1("1234");
        for(String str: res)
            System.out.println(str);
    }

    public static List<String> anagram2(String name){
        HashSet<String> set = new HashSet<>();
        LinkedList<Character> list = new LinkedList<>();

        int len = name.length();
        for(int i=0;i<len;i++)
            list.add(name.charAt(i));

        anagram2Helper(set, list, "");
        return new ArrayList<>(set);
    }
    public static void anagram2Helper(HashSet<String> set, LinkedList<Character> list, String last){
        if(list.isEmpty()){
            set.add(last);
            return;
        }

        for(int i=0;i<list.size();i++){
            LinkedList<Character> newList = new LinkedList<>(list);
            char bit = newList.remove(i);
            anagram2Helper(set,newList,new String(last+bit));
        }

    }

    public static List<String> anagram1(String name){

        List<String> res = new ArrayList<>();
        if(name==null || name.length()<=0)
            return res;

        char[] ary = name.toCharArray();
        Arrays.sort(ary);
        String cur = new String(ary);
        while(cur!=null){
            res.add(cur);
            char[] curAry = cur.toCharArray();
            cur = nextAnagram(curAry);
        }
        return res;
    }

    public static String nextAnagram(char[] ary){
        int idx = ary.length-1;
        while(idx>0 && ary[idx]<ary[idx-1]){
            idx--;
        }
        if(idx==0)
            return null;
        int sign = idx;
        for(int i=idx+1;i<ary.length;i++){
            if(ary[sign]>ary[i] && ary[i]>ary[idx-1]){
                sign = i;
            }
        }
        char tmp = ary[sign];
        ary[sign] = ary[idx-1];
        ary[idx-1] = tmp;

        Arrays.sort(ary,idx,ary.length);

        return new String(ary);
    }
}
