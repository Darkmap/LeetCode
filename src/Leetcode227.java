/**
 * Created by qixuanwang on 15/11/9.
 */
public class Leetcode227 {

    public static void main(String[] args) {

        Leetcode227 lt = new Leetcode227();

        System.out.println(lt.calculate("3 + 2 *  2"));
        System.out.println(lt.calculate("123* 24 + 56 * 78 + 9999"));
    }


    public int calculate(String s) {

        s = s.replaceAll(" ","");

        int len = s.length();

        int a = 0;
        int b = 0;
        int c = 0;
        char op1 = '+';
        char op2 = '+';

        int idx = 0;

        while(idx<len){

            char ch = s.charAt(idx);
            if(Character.isDigit(ch)){
                //If ch is digit
                int cur = 0;
                while(idx<len && Character.isDigit(s.charAt(idx))){
                    cur *= 10;
                    cur += s.charAt(idx)-'0';
                    idx++;
                }
                c = cur;

                if(op2=='*' || op2=='/'){
                    b = count(b,c,op2);
                    op2 = '+';
                    c = 0;
                } else{
                    a = count(a,b,op1);
                    b = c;
                    op1 = op2;
                    op2 = '+';
                    c = 0;
                }
            } else{
                // If ch is operator
                op2 = ch;
                idx++;
            }
        }

        if(priority(op1)>=priority(op2)){
            return count(count(a,b,op1),c,op2);
        } else{
            return count(a,count(b,c,op2),op1);
        }
    }

    int priority(char op){
        if(op=='+' || op=='-')
            return 1;
        else
            return 2;
    }

    int count(int a, int b, char c){
        if(c=='+'){
            return a+b;
        } else if(c=='-'){
            return a-b;
        } else if(c=='*'){
            return a*b;
        } else{
            return a/b;
        }
    }


//    public static int calculate(String s) {
//        Stack<String> stack = new Stack<>();
//        ArrayList<String> list = new ArrayList<>();
//
//        s.replaceAll("\\s","");
//        int len = s.length();
//        //StringBuilder sb = new StringBuilder();
//
//        String high = "*/";
//        String low = "+-";
//
//
//        for(int i=0;i<len;i++){
//            char bit = s.charAt(i);
//
//            if(Character.isDigit(bit)){
//                int begin = i;
//                i++;
//                while(i<len && Character.isDigit(s.charAt(i))){
//                    i++;
//                }
//                list.add(s.substring(begin, i));
//                i--;
//            }
//            else if(bit=='+' || bit=='-'){
//                if(stack.isEmpty()){
//                    stack.push(bit+"");
//                }
//                else if(high.contains(stack.peek())){
//                    while(!stack.isEmpty() && high.contains(stack.peek())){
//                        list.add(stack.pop());
//                    }
//                    i--;
//                }
//                else if(low.contains(stack.peek())){
//                    list.add(stack.pop());
//                    stack.push(bit + "");
//                }
//            }
//            else if(bit=='*' || bit=='/'){
//                if(stack.isEmpty()){
//                    stack.push(bit+"");
//                }
//                else if(low.contains(stack.peek())){
//                    stack.push(bit + "");
//                }
//                else if(high.contains(stack.peek())){
//                    list.add(stack.pop());
//                    stack.push(bit + "");
//                }
//            }
//
//        }
//
//        while(!stack.isEmpty()){
//            list.add(stack.pop());
//        }
//
//        //System.out.println(sb);
//
//        Stack<Integer> nums = new Stack<>();
//        for(String token: list){
//
//            if(token.matches("[0-9]+")){
//                nums.push(Integer.valueOf(token));
//            }
//            else{
//                if(token.equals("+")){
//                    int b = nums.pop();
//                    int a = nums.pop();
//                    nums.push(a+b);
//                }
//                else if(token.equals("-")){
//                    int b = nums.pop();
//                    int a = nums.pop();
//                    nums.push(a-b);
//                }
//                else if(token.equals("*")){
//                    int b = nums.pop();
//                    int a = nums.pop();
//                    nums.push(a*b);
//                }
//                else if(token.equals("/")){
//                    int b = nums.pop();
//                    int a = nums.pop();
//                    nums.push(a/b);
//                }
//            }
//        }
//
//        return nums.peek();
//
//    }
}
