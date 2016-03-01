/**
 * Created by qixuanwang on 16/3/1.
 */
public class Leetcode280 {

    public static void main(String[] args) {

        int[] nums = {2,4,3,1,5,4,6};
        wiggleSort(nums);
        for(int num: nums)
            System.out.println(num);
    }

    public static void wiggleSort(int[] nums) {

        if(nums==null || nums.length==0)
            return;

        int pivot = binarySearch(nums);

        int x = 0;
        int y = nums.length%2==0? nums.length-1 : nums.length-2;

        for(int i=0;i<nums.length;){
            int num = nums[i];
            if(num<pivot){
                if(i<x && i%2==0){
                    i++;
                } else if(i==x){
                    x+=2;
                    i++;
                } else{
                    int tmp = nums[x];
                    nums[x] = nums[i];
                    nums[i] = tmp;
                    x+=2;
                }
            } else if(num>pivot){
                if(i>y && i%2==1){
                    i++;
                } else if(i==y){
                    i++;
                    y-=2;
                } else{
                    int tmp = nums[y];
                    nums[y] = nums[i];
                    nums[i] = tmp;
                    y-=2;
                }
            } else{
                i++;
            }
        }
    }

    public static int binarySearch(int[] nums){
        int min = nums[0];
        int max = nums[0];
        for(int i=1;i<nums.length;i++){
            min = Math.min(min,nums[i]);
            max = Math.max(max,nums[i]);
        }

        int half = nums.length%2==0? nums.length/2 : nums.length/2+1;

        int b = min;
        int e = max;

        while(b<e){
            int mid = (b+e)/2;

            int left = 0;
            int in = 0;
            for(int num: nums){
                if(num<mid){
                    left++;
                } else if(num==mid){
                    in++;
                }
            }

            if(left<half && left+in>=half){
                return mid;
            } else if(left<half){
                b=mid+1;
            } else{
                e=mid-1;
            }
        }

        return b;
    }
}
