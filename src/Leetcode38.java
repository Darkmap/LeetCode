/**
 * Created by qixuanwang on 15/9/2.
 */
public class Leetcode38 {

    public static void main(String[] args) {

        for(int i=1;i<10;i++)
            System.out.println(countAndSay(i));
    }

    public static String countAndSay(int n) {

        if(n<1){
            return "";
        }

        String state = "1";
        for(int i=2;i<=n;i++){
            String newState = "";
            int len = state.length();
            for(int idx=0;idx<len;idx++){

                int count = 1;
                String digit = state.substring(idx,idx+1);
                while(idx+1<len && state.substring(idx+1,idx+2).equals(digit)){
                    count++;
                    idx++;
                }
                newState = newState + count + digit;
            }
            state = newState;
        }

        return state;
    }
}
