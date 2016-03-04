/**
 * Created by qixuanwang on 16/3/2.
 */
class SegmentTreeNode{

    int start;
    int end;
    int sum;
    SegmentTreeNode left;
    SegmentTreeNode right;

    public SegmentTreeNode(int start, int end){
        this.start = start;
        this.end = end;
        this.sum = 0;
    }
}

public class SegmentTree{

    SegmentTreeNode root;

    public SegmentTree(int[] nums){
        int start = 0;
        int end = nums.length-1;
        root = buildSegmentTree(nums, start, end);
    }

    public SegmentTreeNode buildSegmentTree(int[] nums, int start, int end){
        if(start>end){
            return null;
        } else if(start==end){
            SegmentTreeNode root = new SegmentTreeNode(start,end);
            root.sum = nums[start];
            return root;
        }

        SegmentTreeNode root = new SegmentTreeNode(start,end);
        int mid = start + (end-start)/2;
        root.left = buildSegmentTree(nums,start,mid);
        root.right = buildSegmentTree(nums,mid+1,end);

        root.sum = root.left.sum + root.right.sum;

        return root;
    }

    public void update(int idx, int value){
        update(root,idx,value);
    }

    public void update(SegmentTreeNode root, int idx, int value){
        if(root.start==root.end && root.start==idx){
            root.sum = value;
        } else{

            int mid = root.start + (root.end-root.start)/2;
            if(idx<=mid){
                update(root.left, idx, value);
            } else{
                update(root.right, idx,value);
            }
            //Remember to update the root sum
            root.sum = root.left.sum + root.right.sum;
        }
    }

    public int querySum(int start, int end){
        return querySum(root,start,end);
    }

    public int querySum(SegmentTreeNode root, int start, int end){
        if(root.start==start && root.end==end){
            return root.sum;
        }

        int mid = root.start + (root.end-root.start)/2;
        if(end<=mid){
            return querySum(root.left, start, end);
        } else if(start>mid){
            return querySum(root.right, start, end);
        } else{
            return querySum(root.left, start, mid) + querySum(root.right, mid+1, end);
        }
    }

    public static void main(String[] args) {

        int[] nums = {1,2,3,4,5,6,7,8};
        SegmentTree tree = new SegmentTree(nums);

        System.out.println(tree.querySum(2,4));
    }
}
