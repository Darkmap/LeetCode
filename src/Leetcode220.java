import java.util.TreeSet;

/**
 * Created by qixuanwang on 15/11/6.
 */
public class Leetcode220 {

    public static void main(String[] args) {
        int[] nums = {-1,-1};
        System.out.print(containsNearbyAlmostDuplicate(nums,1,2147483647 ));
    }

    public static boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {

        TreeSet<Integer> set = new TreeSet<>();


        for(int i=0;i<=k && i<nums.length;i++){
            if(overlap(set, nums[i], t)){
                return true;
            }
            else{
                set.add(nums[i]);
            }
        }

        int head=0;
        for(int i=k+1;i<nums.length;i++){
            set.remove(nums[head++]);
            if(overlap(set, nums[i], t)){
                return true;
            }
            else{
                set.add(nums[i]);
            }
        }

        return false;
    }

    public static boolean overlap(TreeSet<Integer> set, int n, int diff){
        diff = Math.abs(diff);
        int min = n-diff;
        int max = n+diff;

        if(n+diff<n){
            max = Integer.MAX_VALUE;
        }
        if(n-diff>n){
            min = Integer.MIN_VALUE;
        }

        if(!set.subSet(min,max).isEmpty() || set.contains(n+diff))
            return true;
        return false;
    }
}
