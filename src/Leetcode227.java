import java.util.ArrayList;
import java.util.Stack;

/**
 * Created by qixuanwang on 15/11/9.
 */
public class Leetcode227 {

    public static void main(String[] args) {
        System.out.println(calculate("123* 24 + 56 * 78 + 9999"));
    }

    public static int calculate(String s) {
        Stack<String> stack = new Stack<>();
        ArrayList<String> list = new ArrayList<>();

        s.replaceAll("\\s","");
        int len = s.length();
        //StringBuilder sb = new StringBuilder();

        String high = "*/";
        String low = "+-";


        for(int i=0;i<len;i++){
            char bit = s.charAt(i);

            if(Character.isDigit(bit)){
                int begin = i;
                i++;
                while(i<len && Character.isDigit(s.charAt(i))){
                    i++;
                }
                list.add(s.substring(begin, i));
                i--;
            }
            else if(bit=='+' || bit=='-'){
                if(stack.isEmpty()){
                    stack.push(bit+"");
                }
                else if(high.contains(stack.peek())){
                    while(!stack.isEmpty() && high.contains(stack.peek())){
                        list.add(stack.pop());
                    }
                    i--;
                }
                else if(low.contains(stack.peek())){
                    list.add(stack.pop());
                    stack.push(bit + "");
                }
            }
            else if(bit=='*' || bit=='/'){
                if(stack.isEmpty()){
                    stack.push(bit+"");
                }
                else if(low.contains(stack.peek())){
                    stack.push(bit + "");
                }
                else if(high.contains(stack.peek())){
                    list.add(stack.pop());
                    stack.push(bit + "");
                }
            }

        }

        while(!stack.isEmpty()){
            list.add(stack.pop());
        }

        //System.out.println(sb);

        Stack<Integer> nums = new Stack<>();
        for(String token: list){

            if(token.matches("[0-9]+")){
                nums.push(Integer.valueOf(token));
            }
            else{
                if(token.equals("+")){
                    int b = nums.pop();
                    int a = nums.pop();
                    nums.push(a+b);
                }
                else if(token.equals("-")){
                    int b = nums.pop();
                    int a = nums.pop();
                    nums.push(a-b);
                }
                else if(token.equals("*")){
                    int b = nums.pop();
                    int a = nums.pop();
                    nums.push(a*b);
                }
                else if(token.equals("/")){
                    int b = nums.pop();
                    int a = nums.pop();
                    nums.push(a/b);
                }
            }
        }

        return nums.peek();

    }
}
