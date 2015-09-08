import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

/**
 * Created by qixuanwang on 15/8/26.
 */
public class Leetcode15 {



    public static void main(String[] args){

        int[] nums = {-4,-2,-2,-2,0,1,2,2,2,3,3,4,4,6,6};
        System.out.println(threeSum2(nums));
    }

    public static List<List<Integer>> threeSum(int[] nums) {

        ArrayList<Integer> numList = new ArrayList<Integer>();
        for(int num: nums){
            numList.add(num);
        }

        Collections.sort(numList);

        int begin = 0;
        int end = nums.length-1;

        List<List<Integer>> output = new ArrayList<List<Integer>>();
        HashSet<String> set = new HashSet<String>();


        while(begin+1<end){
            int sum = 0;
            sum += (numList.get(begin)+numList.get(end));
            int mid = begin+1;
            while(mid<end){
                sum += numList.get(mid);
                if(sum==0){
                    ArrayList<Integer> solution = new ArrayList<Integer>();
                    solution.add(numList.get(begin));
                    solution.add(numList.get(mid));
                    solution.add(numList.get(end));

                    if(!set.contains(solution.toString())){
                        set.add(solution.toString());
                        output.add(solution);
                    }
                    sum = sum - numList.get(mid) + numList.get(end-1);
                    break;
                }
                else if(sum<0){
                    sum -= numList.get(mid);
                    mid++;
                }
                else{
                    break;
                }
            }
            if(sum<=0){
                begin++;
            }
            else if(sum>0){
                end--;
            }
        }

        return output;

    }

    public static List<List<Integer>> threeSum2(int[] nums) {

        ArrayList<Integer> numList = new ArrayList<Integer>();
        for(int num: nums){
            numList.add(num);
        }

        Collections.sort(numList);


        List<List<Integer>> output = new ArrayList<List<Integer>>();


        for(int begin=0;begin<nums.length-2;begin++){
            int mid = begin+1;
            int end = nums.length-1;

            while(mid<end){
                if(numList.get(begin)+numList.get(mid)+numList.get(end) == 0){

                    ArrayList<Integer> solution = new ArrayList<Integer>();
                    solution.add(numList.get(begin));
                    solution.add(numList.get(mid));
                    solution.add(numList.get(end));

                    output.add(solution);

                    while(begin<nums.length-2 && numList.get(begin) == numList.get(begin+1))
                        begin++;
                    while(mid<nums.length-1 && numList.get(mid) == numList.get(mid+1))
                        mid++;
                    mid++;
                    while(end>1 && numList.get(end) == numList.get(end-1))
                        end--;
                    end--;

                }
                else if(numList.get(begin)+numList.get(mid)+numList.get(end) > 0){
                    end--;
                }
                else{
                    mid++;
                }
            }

        }


        return output;

    }
}

