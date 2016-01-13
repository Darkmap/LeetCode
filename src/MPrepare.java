/**
 * Created by qixuanwang on 16/1/12.
 */
public class MPrepare {

    public static void main(String[] args) {

        String str = "I believe I can fly";
        char[] text = str.toCharArray();
        reverseWords(text);

        System.out.println(new String(text));
    }

    public static int findKthLargest(int[] nums, int k) {

        return KLEHelper(nums, k, 0, nums.length - 1);
    }

    public static int KLEHelper(int[] nums, int k, int begin, int end){

        if(begin==end){
            if(k==1)
                return nums[begin];
            else
                return -1;
        }

        if(begin==end-1){
            if(k==1){
                return Math.max(nums[begin],nums[end]);
            }
            else if(k==2)
                return Math.min(nums[begin],nums[end]);
            else
                return -1;
        }

        int pivot = begin;
        int i = begin+1;
        int j = end;

        while(i<=j){
            while(i<=end && nums[i]>nums[pivot])
                i++;
            while(j>=begin && nums[j]<nums[pivot])
                j--;

            if(i<j){
                int tmp = nums[i];
                nums[i] = nums[j];
                nums[j] = tmp;

                i++;
                j--;
            }
            else
                break;
        }

        int tmp = nums[pivot];
        nums[pivot] = nums[j];
        nums[j] = tmp;

        int pre = j-pivot;
        if(pre>=k){
            return KLEHelper(nums, k, begin, j - 1);
        }
        else if(pre==k-1)
            return nums[j];
        else
            return KLEHelper(nums,k-pre-1,j+1,end);
    }

    public static int kSmallestElement(int[] nums, int k){

        return KSEHelper(nums,k,0,nums.length-1);
    }

    public static int KSEHelper(int[] nums, int k, int begin, int end){

        if(begin==end){
            if(k==1)
                return nums[begin];
            else
                return -1;
        }

        if(begin==end-1){
            if(k==1){
                return Math.min(nums[begin],nums[end]);
            }
            else if(k==2)
                return Math.max(nums[begin],nums[end]);
            else
                return -1;
        }

        int pivot = begin;
        int i = begin+1;
        int j = end;

        while(i<j){
            while(i<=end && nums[i]<nums[pivot])
                i++;
            while(j>=begin && nums[j]>nums[pivot])
                j--;

            if(i<j){
                int tmp = nums[i];
                nums[i] = nums[j];
                nums[j] = tmp;

                i++;
                j--;
            }
        }

        int tmp = nums[pivot];
        nums[pivot] = nums[j];
        nums[j] = tmp;

        int pre = j-pivot;
        if(pre>=k){
            return KSEHelper(nums,k,begin,j-1);
        }
        else if(pre==k-1)
            return nums[j];
        else
            return KSEHelper(nums,k-pre-1,j+1,end);
    }

    public static void reverseWords(char[] text){

        reverseWord(text,0,text.length-1);
        int i=0;
        while(i<text.length){
            int begin = i;
            while(i<text.length && text[i]!=' '){
                i++;
            }
            reverseWord(text,begin,i-1);
            if(i<text.length && text[i]==' ')
                i++;
        }
    }
    public static void reverseWord(char[] text, int i, int j){
        while(i<j){
            char tmp = text[i];
            text[i] = text[j];
            text[j] = tmp;
            i++;
            j--;
        }
    }
}
