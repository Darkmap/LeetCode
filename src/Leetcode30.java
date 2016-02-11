import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

/**
 * Created by qixuanwang on 15/11/19.
 */
public class Leetcode30 {

    public static void main(String[] args) {

        String s = "barfoofoobarthefoobarman";
        String[] words = {"bar", "foo","the"};
        List<Integer> res = findSubstring4(s, words);
        for (int ans: res){
            System.out.println(ans);
        }
    }

    public static List<Integer> findSubstring4(String s, String[] words) {

        List<Integer> res = new ArrayList<>();
        if(s.length()==0 || words.length==0)
            return res;


        HashMap<String,Integer> map = new HashMap<>();

        for(String str: words){
            if(map.containsKey(str)){
                map.put(str,map.get(str)+1);
            } else{
                map.put(str,1);
            }
        }

        int k = words[0].length();
        int wordNum = words.length;
        int len = s.length();
        int max = len-k;

        for(int i=0;i<k;i++){

            HashMap<String,Integer> tmpMap = new HashMap<>();
            int count = 0;

            int start = i;
            for(int end=start;end<=max;end+=k){
                String cur = s.substring(end,end+k);

                if(!map.containsKey(cur)){
                    tmpMap.clear();
                    count = 0;
                    start = end+k;
                    continue;
                }

                if(tmpMap.containsKey(cur)){
                    int time = tmpMap.get(cur)+1;
                    tmpMap.put(cur, time);
                } else{
                    tmpMap.put(cur, 1);
                }

                count++;


                if(tmpMap.get(cur)>map.get(cur)){
                    while(tmpMap.get(cur)>map.get(cur)){
                        String rmv = s.substring(start,start+k);
                        tmpMap.put(rmv, tmpMap.get(rmv)-1);
                        start += k;
                        count--;
                    }
                }

                if(count==wordNum){
                    res.add(start);
                    String rmv = s.substring(start,start+k);
                    tmpMap.put(rmv, tmpMap.get(rmv)-1);
                    count--;
                    start += k;
                }
            }
        }

        return res;
    }


    public static List<Integer> findSubstring(String s, String[] words){

        List<Integer> res = new ArrayList<>();
        if(s.length()==0 || words.length==0)
            return res;


        HashMap<String,Integer> map = new HashMap<>();

        for(String str: words){
            if(map.containsKey(str)){
                map.put(str,map.get(str)+1);
            }
            else{
                map.put(str,1);
            }
        }

        int singleLen = words[0].length();
        int wordNum = words.length;
        int sLen = s.length();
        int max = sLen-singleLen;

        for(int idx=0;idx<singleLen;idx++){
            HashMap<String,Integer> tmpMap = new HashMap<>();
            int count= 0;
            int start = idx;
            for(int end=start;end<=max;end+=singleLen){

                String cur = s.substring(end,end+singleLen);

                if(!map.containsKey(cur)){
                    tmpMap.clear();
                    count = 0;
                    start = end+singleLen;
                    continue;
                }

                if(tmpMap.containsKey(cur)){
                    int time = tmpMap.get(cur)+1;
                    tmpMap.put(cur, time);
                }
                else{
                    tmpMap.put(cur, 1);
                }

                if(tmpMap.get(cur)>map.get(cur)){
                    while(tmpMap.get(cur)>map.get(cur)){
                        String tmpCur = s.substring(start,start+singleLen);
                        tmpMap.put(tmpCur, tmpMap.get(tmpCur)-1);
                        if(tmpMap.get(tmpCur)<map.get(tmpCur)){
                            count--;
                        }
                        start += singleLen;
                    }
                }
                else{
                    count++;
                }

                if(count == wordNum){
                    res.add(start);
                    String tmpCur = s.substring(start,start+singleLen);
                    tmpMap.put(tmpCur, tmpMap.get(tmpCur)-1);
                    count--;
                    start += singleLen;
                }
            }
        }


        return res;
    }


    /**
     * AC answer, but not efficiently enough.
     * @param s
     * @param words
     * @return
     */
    public static List<Integer> findSubstring3(String s, String[] words) {

        List<Integer> res = new ArrayList<>();
        if(/*s==null || */s.length()==0 || words.length==0)
            return res;


        HashMap<String,Integer> map = new HashMap<>();

        for(String str: words){
            if(map.containsKey(str)){
                map.put(str,map.get(str)+1);
            }
            else{
                map.put(str,1);
            }
        }

        int singleLen = words[0].length();
        int wordNum = words.length;
        int sLen = s.length();

        for(int idx=0;idx<=sLen-wordNum*singleLen;idx++){
            HashMap<String,Integer> tmpMap = new HashMap<>();
            int i= 0;
            for(;i<wordNum;i++){
                int curIdx = idx+i*singleLen;
                String cur = s.substring(curIdx,curIdx+singleLen);

                if(!map.containsKey(cur)){
                    break;
                }

                if(tmpMap.containsKey(cur)){
                    int time = tmpMap.get(cur)+1;
                    if(time>map.get(cur)){
                        break;
                    }
                    tmpMap.put(cur, time);
                }
                else{
                    tmpMap.put(cur, 1);
                }
            }
            if(i==wordNum){
                res.add(idx);
            }
        }


        return res;
    }



    /**
     * TLE answer, should be ignored
     * @param s
     * @param words
     * @return
     */
    public static List<Integer> findSubstring2(String s, String[] words) {

        List<Integer> res = new ArrayList<>();
        if(s==null || s.length()==0 || words.length==0)
            return res;

        int singleLen = words[0].length();
        int i=0;
        HashMap<String, Integer> map = new HashMap<>();
        ArrayList<String> values = new ArrayList<>();
        for(String str: words){
            if(map.containsKey(str)){
                values.add(map.get(str)+"");
            }
            else{
                s = s.replaceAll(str,i+"");
                values.add(i+"");
                map.put(str,i++);
            }
        }

        HashSet<String> set = new HashSet<>();
        getSet2(set, "", values);
        int valNum = values.size();

        int sLen = s.length();
        int realIdx = 0;
        for(int idx=0;idx<=sLen-valNum;idx++){
            if(set.contains(s.substring(idx,idx+valNum))){
                res.add(realIdx);
            }
            if(values.contains(s.substring(idx, idx + 1))){
                realIdx += singleLen;
            }
            else
                realIdx++;
        }


        return res;
    }

    public static void getSet2(HashSet<String> set, String last, ArrayList<String> values){
        if(values.size()==0)
            set.add(new String(last));

        for(String str: values){
            String tmpStr = new String(last+str);
            ArrayList<String> newValues = new ArrayList<>(values);
            newValues.remove(str);
            getSet2(set, tmpStr, newValues);
        }
    }
}
