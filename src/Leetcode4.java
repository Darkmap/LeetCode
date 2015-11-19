/**
 * Created by qixuanwang on 15/11/18.
 */
public class Leetcode4 {

    public static void main(String[] args) {

        int[] nums1 = {1};
        int[] nums2 = {1};

        System.out.println(findMedianSortedArrays(nums1,nums2));
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {

        int n = nums1.length;
        int m = nums2.length;

        int k = (m+n)/2;

        if((n+m)%2==0){
            return (findKth(nums1, nums2, 0, n, 0, m, k) + findKth(nums1, nums2, 0, n, 0, m, k+1))/2.0;
        }
        else{
            return (double)findKth(nums1, nums2, 0, n, 0, m, k+1);
        }
    }

    public static int findKth(int[] nums1, int[] nums2, int x1, int x2, int y1, int y2, int k){

        if(x2>y2){
            return findKth(nums2, nums1, y1, y2, x1, x2, k);
        }

        if(x2==0)
            return nums2[k-1];
        if(k==1){
            return Math.min(nums1[x1],nums2[y1]);
        }
        int x = Math.min(k/2,x2);
        int y = k-x;

        if(nums1[x1+x-1]>=nums2[y1+y-1]){
            return findKth(nums1, nums2, x1, x1+x, y1+y, y2-y, k-y);
        }
        else
            return findKth(nums1, nums2, x1+x, x2-x, y1, y1+y, k-x);
    }
}
