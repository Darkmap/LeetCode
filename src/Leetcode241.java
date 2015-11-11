import java.util.ArrayList;
import java.util.List;

/**
 * Created by qixuanwang on 15/11/10.
 */
public class Leetcode241 {




    public List<Integer> diffWaysToCompute(String input) {
        ArrayList<Integer> nums = new ArrayList<>();
        ArrayList<Character> ops = new ArrayList<>();

        int len  = input.length();
        for(int i=0;i<len;i++){
            if(Character.isDigit(input.charAt(i))){
                int begin = i;
                while(i<len && Character.isDigit(input.charAt(i))){
                    i++;
                }
                nums.add(Integer.valueOf(input.substring(begin,i)));
                i--;
            }
            else{
                ops.add(input.charAt(i));
            }
        }

        List<Integer> res = new ArrayList<>();
        helper(res, nums, ops);
        return res;

    }

    public void helper(List<Integer> res, ArrayList<Integer> nums, ArrayList<Character> ops){
        if(nums.size()==2){
            res.add(compute(nums.get(0), nums.get(1), ops.get(0)));
        }
        else{
            for(int i=0;i<ops.size();i++){
                ArrayList<Integer> newnums = new ArrayList<>(nums);
                ArrayList<Character> newops = new ArrayList<>(ops);
                newnums.set(i,compute(nums.get(0), nums.get(1), ops.get(0)));
                newnums.remove(i+1);
                newops.remove(i);
                helper(res, newnums, newops);
            }
        }
    }

    public int compute(int num1, int num2, char op){
        int ans = 0;
        switch(op){
            case '+':
                ans = num1+num2;
                break;
            case '-':
                ans = num1-num2;
                break;
            case '*':
                ans = num1*num2;
                break;
        }
        return ans;
    }
}
