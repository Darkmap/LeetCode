/**
 * Created by qixuanwang on 15/11/18.
 */
public class Leetcode4 {

    public static void main(String[] args) {

        int[] nums1 = {4,5,6,7};
        int[] nums2 = {1,2,3};

        System.out.println(findMedianSortedArrays(nums1,nums2));
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {

        int len = (nums1.length+nums2.length);
        if(len%2==0){
            return (findK(nums1,nums2,0,nums1.length-1,0,nums2.length-1,len/2) +
                    findK(nums1,nums2,0,nums1.length-1,0,nums2.length-1,len/2+1))/2.0;
        } else{
            return findK(nums1,nums2,0,nums1.length-1,0,nums2.length-1,len/2+1);
        }
    }

    public static int findK(int[] nums1, int[] nums2, int b1, int e1, int b2, int e2, int k){

        int rk = k-(b1+b2);

        if(b1>e1){
            return nums2[rk-1+b2];
        }
        if(b2>e2){
            return nums1[rk-1+b1];
        }

        int i1 = (b1+e1)/2;
        int i2 = (b2+e2)/2;

        if(rk==1)
            return Math.min(nums1[b1],nums2[b2]);

        if(nums1[i1] >= nums2[i2]){
            if(i1+i2+1>=k){
                return findK(nums1,nums2,b1,i1-1,b2,e2,k);
            } else{
                return findK(nums1,nums2,b1,e1,i2+1,e2,k);
            }
        } else{
            if(i1+i2+1>=k){
                return findK(nums1,nums2,b1,e1,b2,i2-1,k);
            } else{
                return findK(nums1,nums2,i1+1,e1,b2,e2,k);
            }
        }
    }

    /*public static double findMedianSortedArrays(int[] nums1, int[] nums2) {

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
    }*/
}
