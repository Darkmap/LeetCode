/**
 * Created by qixuanwang on 16/1/31.
 */
public class Leetcode324 {

    public static void main(String[] args) {

        int[] nums = {1,2,2,1,2,1,1,1,1,2,2,2};
//        int[] nums = {1,3,2,2,3,1};
        wiggleSort(nums);
        for(int num: nums){
            System.out.println(num);
        }
    }

    public static void wiggleSort(int[] nums) {

        int n = nums.length;
        if(n<=1)
            return;

        int median = bs(nums);

        int s = (n%2==0? n-2:n-1), b = 1;
        for(int i=0;i<n;){
            if (nums[i] < median){
                if(i>s && i%2==0){
                    i++;
                }
                else if(i==s){
                    i++;
                    s-=2;
                }
                else{
                    int tmp = nums[s];
                    nums[s] = nums[i];
                    nums[i] = tmp;
                    s-=2;
                }
            }
            else if (nums[i] > median) {
                if(i<b && i%2==1){
                    i++;
                }
                else if(i==b){
                    i++;
                    b+=2;
                }
                else{
                    int tmp = nums[b];
                    nums[b] = nums[i];
                    nums[i] = tmp;
                    b+=2;
                }
            }
            else
                i++;
        }

    }

    public static int bs(int[] nums){

        int min = nums[0];
        int max = nums[0];
        for(int num: nums){
            min = Math.min(min,num);
            max = Math.max(max, num);
        }

        int median = nums.length % 2==0? nums.length/2 : nums.length/2+1;

        int b = min;
        int e = max;
        while(b<e){
            int mid = b + (e-b)/2;
            int smaller = 0;
            int bigger = 0;
            int equal = 0;
            for(int num: nums){
                if(num<mid)
                    smaller++;
                else if(num>mid)
                    bigger++;
                else
                    equal++;
            }
            if(smaller < median && smaller+equal>= median){
                return mid;
            }
            else if(smaller>=median){
                e = mid-1;
            }
            else{
                b = mid+1;
            }
        }
        return b;
    }

    public static int tran(int i, int n){
        return (1+2*(i)) % (n|1);
    }
}
