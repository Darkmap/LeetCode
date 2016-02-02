import java.util.Stack;

/**
 * Created by qixuanwang on 16/2/1.
 */
public class Leetcode331 {

    public static void main(String[] args) {

        System.out.println(isValidSerialization("9,3,4,#,#,1,#,#,2,#,6,#,#"));
    }

    public static boolean isValidSerialization(String preorder) {


        int len = preorder.length();
        if(len==0)
            return false;

        String[] tokens = preorder.split(",");
        Stack<String> stack = new Stack<>();

        int i = 0;

        while(i<tokens.length){

            String tk = tokens[i];

            if(tk.equals("#")){
                if(stack.isEmpty()){
                    return false;
                }
                else if(stack.peek().equals("#")){
                    stack.pop();
                    if(stack.peek().equals("#")){
                        return false;
                    }
                    else{
                        stack.pop();
                        if(stack.isEmpty() && i==tokens.length-1){
                            return true;
                        }
                        else
                            i--;
                    }
                }
                else{
                    stack.push(tk);
                }
            }
            else{
                stack.push(tk);
            }
            i++;
        }

        return stack.isEmpty();
    }
}
