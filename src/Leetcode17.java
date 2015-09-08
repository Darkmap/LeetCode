import java.util.ArrayList;
import java.util.List;

/**
 * Created by qixuanwang on 15/8/26.
 */
public class Leetcode17 {

    public static void main(String[] args){

        System.out.println(letterCombinations("23"));
    }

    public static List<String> letterCombinations(String digits) {


        List<String> outRange = new ArrayList<String>();

        //边界情况又没考虑!!!
        if(digits.length()==0){
            return outRange;
        }

        String[][] dic = {{},{},{"a","b","c"},{"d","e","f"},
                {"g","h","i"},{"j","k","l"},{"m","n","o"},{"p","q","r","s"},{"t","u","v"},
                {"w","x","y","z"}};
        outRange.add("");

        for(int i=0;i<digits.length();i++){
            int buttonIdx = Integer.valueOf(digits.substring(i,i+1));
            
            List<String> tmpStorage = new ArrayList<String>();
            
            for(String it: outRange){
                for(String character: dic[buttonIdx]){
                    tmpStorage.add(new String(it+character));
                }
            }

            outRange.clear();
            outRange.addAll(tmpStorage);
        }

        return outRange;

    }
}
