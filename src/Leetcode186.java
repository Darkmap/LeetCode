import java.util.Stack;

/**
 * Created by qixuanwang on 16/1/11.
 */
public class Leetcode186 {

    public static void main(String[] args) {

        char[] s = {'t','h','e',' ','s','k','y',' ','i','s',' ','b','l','u','e'};
        reverseWords(s);
        System.out.println(s);
    }

    public static void reverseWords(char[] s) {
        Stack<String> stack = new Stack<>();
        int len = s.length;

        if(len==0)
            return;

        for(int i=0;i<len;i++){
            StringBuilder sb = new StringBuilder();
            while(i<len && s[i]!=' '){
                sb.append(s[i]);
                i++;
            }
            if(sb.length()!=0){
                stack.push(sb.toString());
            }
        }

        StringBuilder sb = new StringBuilder();
        while(stack.size()>1){
            sb.append(stack.pop()+" ");
        }
        sb.append(stack.pop());
        char[] s2 = sb.toString().toCharArray();
        for(int i=0;i<len;i++){
            s[i] = s2[i];
        }
    }
}
