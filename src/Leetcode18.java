import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by qixuanwang on 15/8/26.
 */
public class Leetcode18 {


    public static void main(String[] args) {
        int[] nums = {333,387,387,470,492};
        System.out.println(fourSum(nums,1682));
    }
    public static List<List<Integer>> fourSum(int[] nums, int target) {
        ArrayList<Integer> numList = new ArrayList<Integer>();
        for(int num: nums){
            numList.add(num);
        }

        Collections.sort(numList);


        List<List<Integer>> output = new ArrayList<List<Integer>>();

        for(int i=0;i<nums.length-3;i++){

            for(int begin=i+1;begin<nums.length-2;begin++){
                int mid = begin+1;
                int end = nums.length-1;

                while(mid<end){
                    if(numList.get(i)+numList.get(begin)+numList.get(mid)+numList.get(end) == target){

                        ArrayList<Integer> solution = new ArrayList<Integer>();
                        solution.add(numList.get(i));
                        solution.add(numList.get(begin));
                        solution.add(numList.get(mid));
                        solution.add(numList.get(end));

                        output.add(solution);


                        //equals才是正确的作法,Integer使用==不是比较数值本身
                        while(i< (nums.length-3) && numList.get(i).equals(numList.get(i+1)))
                            i++;
                        while(begin<nums.length-2 && numList.get(begin).equals(numList.get(begin + 1)))
                            begin++;
                        while(mid<nums.length-1 && numList.get(mid).equals(numList.get(mid+1)))
                            mid++;
                        mid++;
                        while(end>1 && numList.get(end).equals(numList.get(end-1)))
                            end--;
                        end--;

                    }
                    else if(numList.get(i)+numList.get(begin)+numList.get(mid)+numList.get(end) > target){
                        end--;
                    }
                    else{
                        mid++;
                    }
                }

            }

        }




        return output;
    }
}
