import java.util.*;

/**
 * Created by qixuanwang on 16/2/28.
 */
public class Leetcode269 {


    public static void main(String[] args) {

        String[] words = {"za","zb","ca","cb"};

        System.out.println(alienOrder(words));

    }



    public static String alienOrder(String[] words) {


        HashSet<Character> keys = new HashSet<>();
        HashMap<Character,Set<Character>> out = new HashMap<>();
        HashMap<Character,Set<Character>> in = new HashMap<>();

        int size = words.length;
        for(int i=0;i<size;i++){
            String curstr = words[i];
            for(char c: curstr.toCharArray()){
                keys.add(c);
            }
            if(i<size-1){
                String nxtstr = words[i+1];

                int x = 0;
                int len = Math.min(curstr.length(), nxtstr.length());

                while(x < len){
                    char cur = curstr.charAt(x);
                    char nxt = nxtstr.charAt(x);
                    if(cur!=nxt){
                        if(out.containsKey(cur)){
                            out.get(cur).add(nxt);
                        } else{
                            Set<Character> set = new HashSet<>();
                            set.add(nxt);
                            out.put(cur,set);
                        }

                        if(in.containsKey(nxt)){
                            in.get(nxt).add(cur);
                        } else{
                            Set<Character> set = new HashSet<>();
                            set.add(cur);
                            in.put(nxt,set);
                        }
                        break;
                    }
                    x++;
                }
            }
        }

        Stack<Character> s = new Stack<>();
        String res = "";


        for(char n: keys){
            if(!in.containsKey(n) || in.get(n).size()==0)
                s.push(n);
        }

        while(!s.isEmpty()){

            char n = s.pop();
            res = res+n;
            keys.remove(n);

            if(out.containsKey(n))
                for(char m: out.get(n)){
                    in.get(m).remove(n);
                    if(in.get(m).size()==0){
                        in.remove(m);
                        s.push(m);
                    }
                }
        }

        if(in.size()>0)
            return "";
        else {
            for(char remain: keys)
                res = res + remain;
            return res;
        }
    }
}
