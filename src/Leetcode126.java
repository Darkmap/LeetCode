import java.util.*;
import java.util.List;

/**
 * Created by qixuanwang on 16/1/19.
 */
public class Leetcode126 {

    public static void main(String[] args) {
        String[] ary = {"hot","dot","dog","lot","log"};
        HashSet<String> set = new HashSet<>();
        for(String str: ary)
            set.add(str);
        List<List<String>> res = findLadders("hit","cog",set);

        for(List<String> line: res){
            for(String str: line)
                System.out.print(str+" ");
            System.out.println();
        }
    }

    public static List<List<String>> findLadders(String beginWord, String endWord,
                                                 Set<String> wordList){

        HashMap<String, ArrayList<String>> map = new HashMap<>();
        wordList.add(beginWord);
        wordList.add(endWord);
//        for(String w1: wordList){
//            map.put(w1,new ArrayList<>());
//            for(String w2: wordList){
//                if(isNeighbor(w1,w2)){
//                    map.get(w1).add(w2);
//                }
//            }
//        }
        for(String w1: wordList){
            map.put(w1,new ArrayList<>());
            int len = w1.length();
            for(int i=0;i<len;i++){

                /**
                 * By using character change methods, the time complexity
                 * can be reduced to (string.length * 26), it's much smaller
                 * than (num of String)^2, because the TLE is because of wordlist
                 * is too large
                 */
                for(char c='a';c<='z';c++){
                    if(c!=w1.charAt(i)){
                        char[] l1 = w1.toCharArray();
                        l1[i] = c;
                        String w2 = new String(l1);
                        if(wordList.contains(w2)){
                            map.get(w1).add(w2);
                        }
                    }
                }
            }
        }

        List<List<String>> res = new ArrayList<>();

        HashSet<String> close = new HashSet<>();
        Queue<List<String>> open = new LinkedList<>();
        List<String> first = new ArrayList<>();
        first.add(beginWord);
        open.add(first);

        int minLevel = wordList.size();

        while(!open.isEmpty()){

            List<String> pre = open.poll();
            String cur = pre.get(pre.size() - 1);

            if(pre.size()>minLevel){
                break;
            }

            if(cur.equals(endWord)){
                minLevel = pre.size();
                res.add(pre);
            }
            else{
                close.add(cur);

                for(String next: map.get(cur)){
                    if(!close.contains(next)){
                        List<String> tmp = new ArrayList<>(pre);
                        tmp.add(next);
                        open.add(tmp);
                    }
                }
            }

        }




        return res;
    }

//    public static void helper(String cur, String target,
//                              List<String> pre, Set<String> close, HashMap<String, ArrayList<String>> map){
//
//        if(cur.equals(target)){
//
//        }
//    }

    public static boolean isNeighbor(String w1, String w2){
        int len = w1.length();
        if(len!=w2.length())
            return false;

        int count = 0;
        for(int i=0;i<len;i++){
            if(w1.charAt(i)!=w2.charAt(i))
                count++;
        }
        return count==1;
    }
}
