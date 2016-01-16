import java.util.ArrayList;
import java.util.List;

/**
 * Created by qixuanwang on 16/1/15.
 */
public class Leetcode68 {

    public static void main(String[] args) {

        String[] words = {"This", "is", "an", "example", "of", "text", "justification."};
        List<String> res = fullJustify(words,16);

        for(String line: res){
            System.out.println(line);
        }
    }

    public static List<String> fullJustify(String[] words, int maxWidth) {

        List<String> res = new ArrayList<>();
        int idx = 0;
        while(idx<words.length){

            int len = 0;
            int start = idx;
            while(idx<words.length && len<=maxWidth){
                len += words[idx++].length()+1;
            }

            len = len-1;
            if(len>maxWidth){
                len = len-words[idx-1].length()-1;
                idx--;
            }


            StringBuilder sb = new StringBuilder();

            int count = idx-start;
            int diff = maxWidth-len;

            if(idx==words.length || count==1){

                for(int i=0;i<count-1;i++){
                    sb.append(words[start+i]);
                    sb.append(" ");
                }
                sb.append(words[idx-1]);
                for(int i=0;i<diff;i++){
                    sb.append(" ");
                }
            }
            else{

                int time = diff/(count-1);
                int off = diff % (count-1);
                String space = " ";
                for(int i=0;i<time;i++){
                    space = space+" ";
                }

                for(int i=0;i<count-1;i++){
                    sb.append(words[start+i]);
                    sb.append(space);
                    if(i<off){
                        sb.append(" ");
                    }
                }
                sb.append(words[idx-1]);
            }

            res.add(sb.toString());
        }

        return res;
    }
}
