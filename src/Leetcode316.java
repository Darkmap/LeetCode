import java.util.*;

/**
 * Created by qixuanwang on 16/1/28.
 */
public class Leetcode316 {

    public static void main(String[] args) {

        System.out.print(removeDuplicateLetters2("cbacdcbc"));
    }

    public static String removeDuplicateLetters2(String s) {
        HashMap<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.containsKey(c))
                map.put(c, map.get(c) + 1);
            else
                map.put(c, 1);
        }

        String ans = "";

        Deque<Character> deque = new LinkedList<>();
        HashSet<Character> set = new HashSet<>();

        for(int i=0;i<s.length();i++) {

            char c = s.charAt(i);
            map.put(c,map.get(c)-1);

            if(set.contains(c))
                continue;
            if(deque.isEmpty()){
                deque.offer(c);
                set.add(c);
            }
            else{
                while(!deque.isEmpty() && deque.getLast()>c && map.get(deque.getLast())>0){
                    set.remove(deque.removeLast());
                }
                deque.add(c);
                set.add(c);
            }
        }

        for(char c: deque)
            ans += c;
        return ans;
    }

    public static String removeDuplicateLetters(String s) {
        HashMap<Character,Integer> map = new HashMap<>();

        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if(map.containsKey(c))
                map.put(c,map.get(c)+1);
            else
                map.put(c,1);
        }

        int n = map.keySet().size();
        StringBuilder sb = new StringBuilder();

        for(int i=0;i<n;i++){
            char top = s.charAt(0);
            int idx = 0;
            for(int j=0;j<s.length();j++){
                char cur = s.charAt(j);
                if(top>cur){
                    top = cur;
                    idx = j;
                }
                if(map.get(cur)==1){
                    break;
                }
                map.put(cur,map.get(cur)-1);
            }

            sb.append(top+"");
            s = s.substring(idx+1).replaceAll(top+"","");

            map.clear();
            for(int x=0;x<s.length();x++){
                char c = s.charAt(x);
                if(map.containsKey(c))
                    map.put(c,map.get(c)+1);
                else
                    map.put(c,1);
            }
        }

        return sb.toString();
    }
}
