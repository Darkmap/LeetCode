import java.util.Stack;

/**
 * Created by qixuanwang on 15/9/16.
 */
public class Leetcode71 {

    public static void main(String[] args) {

        System.out.println(simplifyPath("/.."));
    }

    public static String simplifyPath(String path) {

        String[] tokens = path.split("/");
        if(tokens.length>0){

            Stack<String> fileStack = new Stack<>();
            for(String token: tokens){
                if(token.equals(".") || token.equals(""));
                else if(token.equals("..") && !fileStack.isEmpty())
                    fileStack.pop();
                else if(token.equals("..") && fileStack.isEmpty());
                else{
                    fileStack.push(token);
                }
            }

            String res = "";

            if(fileStack.isEmpty())
                return "/";

            while(!fileStack.isEmpty()){
                res = "/" + fileStack.pop()+res;
            }

            return res;
        }
        else
            return "/";
    }
}
