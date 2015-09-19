import java.util.LinkedList;
import java.util.List;

/**
 * Created by qixuanwang on 15/9/19.
 */
public class Leetcode77 {

    public static void main(String[] args) {

    }

    public static List<List<Integer>> combine(int n, int k) {


        List<List<Integer>> res = new LinkedList<>();

        combineHelper(res, k, 0, new LinkedList<Integer>(), n);

        return res;

    }

    public static void combineHelper(List<List<Integer>> res, int count, int head, List<Integer> list, int n){
        if(count==0)
            res.add(list);
        else{
            /**
             * 这里 i<=n-count+1 避免了搜索时无法expand的情况
             */
            for(int i = head+1;i <= n-count+1; i++){
                List<Integer> tmpList = new LinkedList<>(list);
                tmpList.add(i);

                combineHelper(res, count-1, i, tmpList, n);
            }
        }
    }
}
