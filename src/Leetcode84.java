import java.util.Stack;

/**
 * Created by qixuanwang on 16/1/16.
 */
public class Leetcode84 {

    public static void main(String[] args) {

        int[] heights = {2,1,5,6,2,3};
        System.out.println(largestRectangleArea(heights));
    }

    public static int largestRectangleArea(int[] heights) {

        Stack<Integer> stack = new Stack<>();
        int[] hs = new int[heights.length+1];
        for(int i=0;i<heights.length;i++){
            hs[i]=heights[i];
        }
        hs[heights.length]=0;

        int area = 0;

        for(int i=0;i<hs.length;i++){
            if(stack.isEmpty() || hs[stack.peek()]<=hs[i]){
                stack.push(i);
            }
            else{
                int tmp = stack.pop();
                area = Math.max(area, hs[tmp]*(stack.isEmpty()? i : i-stack.peek()-1));
                i--;
            }
        }
        return area;
    }



    /**
     * ignored, because of TLE
     * @param heights
     * @return
     */
    public static int largestRectangleArea2(int[] heights) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        int area = 0;

        for(int h: heights){
            min = Math.min(min,h);
            max = Math.max(max, h);
        }


        min = max / heights.length;
        min = Math.max(1,min);

        for(int h=max;h>=min;h--){
            int tmpmax = 0;
            int b = -1;
            int e = -1;
            for(int i=0;i<heights.length;i++){
                if(heights[i]>=h){
                    e=i;
                }
                else{
                    b = i;
                    e = i;
                }
                tmpmax = Math.max(tmpmax,e-b);

            }
            area = Math.max(area,tmpmax*h);

        }

        return area;
    }
}
