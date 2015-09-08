/**
 * Created by qixuanwang on 15/9/1.
 */
public class Leetcode35 {
    public static void main(String[] args) {
        int a = searchInsert(new int[]{1,3,5,6}, 1);
        System.out.print(a);
    }

    public static int searchInsert(int[] nums, int target) {
        int start = 0;
        int end = nums.length;

        if(nums[start]>target)
            return 0;
        else if(nums[end-1]<target)
            return end;

        while(start<end){
            int med = (start+end)/2;
            if(nums[med]==target){
                return med;
            }
            else if(nums[med]<target){
                start = med+1;
            }
            else{
                end = med;
            }
        }
        return end;
    }
}
