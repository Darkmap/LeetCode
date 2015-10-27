/**
 * Created by qixuanwang on 15/9/23.
 */
public class MSFT3C {

    public static void main(String[] args) {

        String line = "265 105 678 655 108 731 491 128 713 319 830 793 916 991 529 906 714 437 950 303 743 181 291 733 365 912";

        String[] tokens = line.split(" ");
        int len = tokens.length;
        int[] nums = new int[len];

        for(int i=0;i<nums.length;i++)
            nums[i] = Integer.valueOf(tokens[i]);

        int count = fun1(nums);

        System.out.println(count);
        for(int token: nums)
            System.out.print(token+" ");

    }

    public static int fun1(int[] nums){

        int len = nums.length;
        int count = 0;
        for(int i=len-1;i>0;i--){
            for(int j=0;j<i;j++){
                if(nums[j]>nums[j+1]){
                    int tmp = nums[j];
                    nums[j] = nums[j+1];
                    nums[j+1] = tmp;
                    count++;
                }
            }
        }

        return count;
    }
}
