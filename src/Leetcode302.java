/**
 * Created by qixuanwang on 16/3/5.
 */
public class Leetcode302 {

    final int val;

    public Leetcode302(int val) {
        this.val = val;
    }

    public static void main(String[] args) {

        Leetcode302 lt = new Leetcode302(1);
        char[][] image = {
                {'0','0','1','0'},
                {'0','1','1','0'},
                {'0','1','0','0'}
        };

        System.out.println(lt.minArea(image,1,2));
    }

    public int minArea(char[][] image, int x, int y) {

        int m = image.length;
        if(m==0)
            return 0;
        int n = image[0].length;
        if(n==0)
            return 0;

        int left = bound(image, 0, y, true, true);
        int right = bound(image, n-1, y, true, false);
        int up = bound(image, 0, x, false, true);
        int bottom = bound(image, m-1, x, false, false);

        return (right-left+1) * (bottom-up+1);
    }

    public int bound(char[][] image, int begin, int end, boolean x, boolean asc){
        int m = image.length;
        int n = image[0].length;

        int len = x? m:n;

        while(asc?begin<end : end<begin){
            int mid = begin + (end-begin)/2;
            boolean find = false;
            for(int i=0;i<len;i++){
                char val = x? image[i][mid]: image[mid][i];
                if(val=='1'){
                    find=true;
                    break;
                }
            }
            if(find){
                end = mid;
            } else{
                if(asc)
                    begin = mid+1;
                else
                    begin = mid-1;
            }
        }

        return end;
    }
}
