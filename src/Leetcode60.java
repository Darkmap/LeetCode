import java.util.Arrays;

/**
 * Created by qixuanwang on 15/9/13.
 */
public class Leetcode60 {

    public static void main(String[] args) {

        System.out.println(getPermutation(3,6));
    }

    public static String getPermutation(int n, int k) {


        int[] nums = new int[n];
        StringBuffer a = new StringBuffer("");

        if(n==0)
            return a.toString();
        if(n==1)
            return "1";


        for(int i=0;i<n;i++){
            nums[i] = i+1;
        }


        for(int i=1;i<k;i++){
            nextPermutation(nums,n);
        }




        for(int i=0;i<n;i++){
            a.append(nums[i]);
        }
        return a.toString();
    }

    public static void nextPermutation(int[] nums, int n){


        int i=n-1;
        for(;i>0;i--){
            if(nums[i]>nums[i-1])
                break;
        }

        int nextIdx = i;
        for(int idx = i+1;idx<n;idx++){
            if(nums[idx]<nums[i] && nums[idx]>nums[i-1])
                nextIdx = idx;
        }
        int tmp = nums[nextIdx];
        nums[nextIdx] = nums[i-1];
        nums[i-1] = tmp;

        Arrays.sort(nums, i, n);
    }

}
