import java.util.LinkedList;

/**
 * Created by qixuanwang on 15/8/27.
 */
public class Leetcode20 {

    public static void main(String[] args) {

        System.out.println(isValid("(("));
    }

    public static boolean isValid(String s) {

        LinkedList<String> stack = new LinkedList<String>();
        int len = s.length();
        if(len==0 || (len%2!=0)){
            return false;
        }

        for(int i=0;i<len;i++){

            String curChar = s.substring(i,i+1);
            if(curChar.equals("(") || curChar.equals("[") || curChar.equals("{"))
                stack.add(curChar);
            else if(curChar.equals(")")){
                if(stack.isEmpty())
                    return false;
                if(!stack.removeLast().equals("("))
                    return false;
            }
            else if(curChar.equals("]")){
                if(stack.isEmpty())
                    return false;
                if(!stack.removeLast().equals("["))
                    return false;
            }
            else if(curChar.equals("}")){
                if(stack.isEmpty())
                    return false;
                if(!stack.removeLast().equals("{"))
                    return false;
            }
        }

        if(stack.isEmpty())
            return true;
        else
            return false;

    }
}
