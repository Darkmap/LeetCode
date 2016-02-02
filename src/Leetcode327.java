import java.util.HashMap;
import java.util.Iterator;
import java.util.TreeSet;

/**
 * Created by qixuanwang on 16/2/1.
 */
public class Leetcode327 {

    public static void main(String[] args) {

        int[] nums = {2147483647,-2147483648,-1,0};
        System.out.println(countRangeSum(nums, -1, 0));
    }

    public static int countRangeSum(int[] nums, int lower, int upper) {
        if(nums.length==0)
            return 0;

        TreeSet<Long> sums = new TreeSet<>();
        long sum = 0;

        for(int num:nums){
            sum += num;
            sums.add(sum);
            sums.add(sum+lower-1);
            sums.add(sum+upper);
        }
        sums.add((long)upper);
        sums.add((long)lower-1);

        HashMap<Long,Integer> index = new HashMap<>();
        Iterator<Long> it = sums.iterator();
        for(int i=1;it.hasNext();i++){
            index.put(it.next(),i);
        }

        FenwickTree tree = new FenwickTree(index.size());

        int ans = 0;

        for(int i=nums.length-1;i>=0;i--){
            tree.add(index.get(sum),1);
            sum -= nums[i];
            ans += tree.sum(index.get(upper+sum))-tree.sum(index.get(lower + sum-1));
        }
        return ans;
    }

}

class FenwickTree{

    int[] sum_array;
    int n;

    public FenwickTree(int n){
        this.sum_array = new int[n+1];
        this.n = n;
    }

    public void add(int x, int val){

        while(x<=n){
            sum_array[x] += val;
            x += (x&-x);
        }
    }

    public int sum(int x){
        int res = 0;
        while(x>0){
            res+=sum_array[x];
            x-=(x&-x);
        }
        return res;
    }
}