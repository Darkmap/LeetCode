/**
 * Created by qixuanwang on 16/6/18.
 */
public class Leetcode334 {

    public static void main(String[] args) {
        int[] nums = {5,2,1,6,3,8};
        System.out.print(increasingTriplet(nums));
    }

    public static boolean increasingTriplet(int[] nums) {
        int len = nums.length;
        int[] rec = new int[4];
        int max = 1;
        rec[0] = Integer.MIN_VALUE;
        rec[1] = nums[0];
        for(int i=1;i<len;i++){
            int cur = nums[i];
            int newMax = max;
            for(int j=0;j<=max;j++){
                if(cur>rec[j]){
                    if(j+1>max){
                        newMax = j+1;
                        rec[newMax] = cur;
                    } else if(cur<rec[j+1]){
                        rec[j+1] = cur;
                    }
                }
            }
            if(newMax==3)
                return true;
            max = newMax;
        }
        return false;
    }
}
