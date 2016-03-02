import java.util.ArrayList;
import java.util.List;

/**
 * Created by qixuanwang on 16/3/1.
 */
public class TopK {

    public static void main(String[] args) {

        int[] arrays = {8,2,2,3,4,5,4,1,6,9};

        for(int num: topK(arrays,2))
            System.out.println(num);
    }

    public static List<Integer> topK(int[] arrays, int k){

        List<Integer> res = new ArrayList<>();

        //Use this two begin and end sign implement the non-recursion quick sort
        int b = 0;
        int e = arrays.length-1;

        int less = 0;
        int equal = 0;
        //The kth max num in the array
        int kth = 0;

        do{
            int pivot = b;
            less = 0;
            equal = 1;

            int i = b+1;
            int j = e;

            while(i<j){
                //log the number of elements which is less to and equal to the pivot
                while(i<e && arrays[i]<=arrays[pivot]){
                    if(arrays[i]<arrays[pivot])
                        less++;
                    else
                        equal++;
                    i++;
                }
                while(j>b && arrays[j]>arrays[pivot]){
                    j--;
                }

                if(i<j){
                    int tmp = arrays[i];
                    arrays[i] = arrays[j];
                    arrays[j] = tmp;
                }
            }
            //pivot swap with the last smaller
            int tmp = arrays[j];
            arrays[j] = arrays[pivot];
            arrays[pivot] = tmp;

            if(less<k && equal+less>=k){
                kth = arrays[j];
                break;
            } else if(less<k){
                k -= (j-b)+1;
                b = j+1;
            } else{
                e = j-1;
            }

        } while(b<e);

        if(b==e){
            for(int i=0;i<=b;i++){
                res.add(arrays[i]);
            }
        } else{
            for(int i=0;i<e;i++){
                if(arrays[i]<kth)
                    res.add(arrays[i]);
            }
            for(int i=less;i<k;i++){
                res.add(kth);
            }
        }

        return res;
    }
}
