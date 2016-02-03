/**
 * Created by qixuanwang on 16/2/2.
 */
public class Leetcode321 {

    public static void main(String[] args) {

        int[] nums1 = {2,0,2,1,2,2,2,2,0,1,0,0,2,0,2,0,2,1,0,1,1,0,1,0,1,2,1,1,1,0,1,2,2,1,0,0,1,2,1,2,2,1,1,0,1,2,0,2,0,1,2,0,2,1,1,1,2,0,0,1,0,2,1,2,0,1,0,0,0,1,2,1,0,1,1,2,0,2,2,0,0,1,1,2,2,1,1,2,2,1,0,1,2,0,1,2,2,0,0,0,2,0,2,0,2,2,0,1,1,1,1,2,2,2,2,0,0,2,2,2,2,0,2,0,1,0,0,2,1,0,0,2,0,2,1,1,1,1,0,1,2,0,2,1,0,1,1,1,0,0,2,2,2,0,2,1,1,1,2,2,0,0,2,2,2,2,2,0,2,0,2,0,2,0,0,1,0,1,1,0,0,2,1,1,2,2,2,1,2,2,0,0,2,1,0,2,1,2,1,1,1,0,2,0,1,1,2,1,1,0,0,1,0,1,2,2,2,0,2,2,1,0,1,2,1,2,0,2,2,0,1,2,2,1,2,2,1,1,2,2,2,2,2,1,2,0,1,1,1,2,2,2,0,2,0,2,0,2,1,1,0,2,2,2,1,0,2,1,2,2,2,0,1,1,1,1,1,1,0,0,0,2,2,0,1,2,1,0,0,2,2,2,2,1,0,2,0,1,2,0};
        int[] nums2 = {1,1,1,0,0,1,1,0,2,1,0,1,2,1,0,2,2,1,0,2,0,1,1,0,0,2,2,0,1,0,2,0,2,2,2,2,1,1,1,1,0,0,0,0,2,1,0,2,1,1,2,1,2,2,0,2,1,0,2,0,0,2,0,2,2,1,0,1,0,0,2,1,1,1,2,2,0,0,0,1,1,2,0,2,2,0,1,0,2,1,0,2,1,1,1,0,1,1,2,0,2,0,1,1,2,0,2,0,1,2,1,0,2,0,1,0,0,0,1,2,1,2,0,1,2,2,1,1,0,1,2,1,0,0,1,0,2,2,1,2,2,0,0,0,2,0,0,0,1,0,2,0,2,1,0,0,1,2,0,1,1,0,1,0,2,2,2,1,1,0,1,1,2,1,0,2,2,2,1,2,2,2,2,0,1,1,0,1,2,1,2,2,0,0,0,0,0,1,1,1,2,1,2,1,1,0,1,2,0,1,2,1,2,2,2,2,0,0,0,0,2,0,1,2,0,1,1,1,1,0,1,2,2,1,0,1,2,2,1,2,2,2,0,2,0,1,1,2,0,0,2,2,0,1,0,2,1,0,0,1,1,1,1,0,0,2,2,2,2,0,0,1,2,1,1,2,0,1,2,1,0,2,0,0,2,1,1,0,2,1,1,2,2,0,1,0,2,0,1,0};

        for(int num: maxNumber(nums1,nums2,600))
            System.out.print(num+" ");
    }

    public static int[] maxNumber(int[] nums1, int[] nums2, int k) {

        int[] res = null;

        for(int m=0;m<=k;m++){
            int n = k-m;
            if(m<=nums1.length && n<=nums2.length){
                int[] numary = new int[k];
                int i = 0;
                int l1 = 0;
                int l2 = 0;

                int[] list1 = selectLargestX(nums1,m);
                int[] list2 = selectLargestX(nums2,n);


                while(i<k){
                    if(l1>=list1.length){
                        numary[i]=list2[l2];
                        l2++;
                        i++;
                    } else if(l2>=list2.length){
                        numary[i]=list1[l1];
                        l1++;
                        i++;
                    } else{
                        if(list1[l1]>list2[l2]){
                            numary[i]=list1[l1];
                            l1++;
                            i++;
                        } else if(list1[l1]<list2[l2]){
                            numary[i]=list2[l2];
                            l2++;
                            i++;
                        }
                        else{
                            int add = 1;
                            while(l1+add<list1.length || l2+add<list2.length){

                                if(l1+add<list1.length && l2+add>=list2.length){
                                    numary[i]=list1[l1];
                                    l1++;
                                    i++;
                                    break;
                                }
                                else if(l1+add>=list1.length && l2+add<list2.length){
                                    numary[i]=list2[l2];
                                    l2++;
                                    i++;
                                    break;
                                }
                                else{
                                    if(list1[l1 + add] == list2[l2 + add]){
                                        add++;
                                    } else if(list1[l1 + add] > list2[l2 + add]){
                                        numary[i]=list1[l1];
                                        l1++;
                                        i++;
                                        break;
                                    }
                                    else{
                                        numary[i]=list2[l2];
                                        l2++;
                                        i++;
                                        break;
                                    }
                                }
                            }
                            if(l1+add>=list1.length && l2+add>=list2.length){
                                numary[i]=list1[l1];
                                l1++;
                                i++;
                            }
                        }
                    }
                }
                if(res==null || needUpdate(res,numary)){
                    res = numary;
                }
            }
        }

        return res;
    }

    public static boolean needUpdate(int[] ans1, int[] ans2){

        int i = 0;
        while(i<ans1.length){
            if(ans1[i]>ans2[i]){
                return false;
            }
            else if(ans1[i]<ans2[i]){
                return true;
            }
            i++;
        }
        return false;
    }


    public static int[] selectLargestX(int[] nums, int x){

        if(x==0)
            return new int[0];

        int idx = 1;
        int len = nums.length;

        int[] res = new int[x];

        int start = 0;

        while(idx<=x && start<len){

            int i = start;
            int maxIdx = i;
            while(i<(len-(x-idx))){
                if(nums[maxIdx]<nums[i]){
                    maxIdx = i;
                }
                i++;
            }
            res[idx-1] = nums[maxIdx];
            start = maxIdx+1;
            idx++;
        }
        return res;
    }
}
