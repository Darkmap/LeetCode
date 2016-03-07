import java.util.Arrays;

/**
 * Created by qixuanwang on 16/3/7.
 */
public class LoadBalancer {

    LBAlgorithm lba;

    public LoadBalancer(int[] weights) {
        int gcd = gcd(weights);
        for(int i=0;i<weights.length;i++){
            weights[i]/=gcd;
        }
        lba = new WRRLBAlgorithm(weights);
    }

    public int next(){
        return lba.nextServer();
    }

    public static int gcd(int[] weights){

        int m = weights[0];
        for(int i=1;i<weights.length;i++){
            int n = weights[i];
            while(n!=0){
                m = n;
                n = m%n;
            }
        }
        return m;
    }

    public static void main(String[] args) {

        int[] weights = {70,30,10};

        LoadBalancer lb = new LoadBalancer(weights);

        for(int i=0;i<30;i++){
            System.out.print(lb.next()+", ");
        }
    }
}

interface LBAlgorithm{
    public int nextServer();
}

class WRRLBAlgorithm implements LBAlgorithm{

    int[] weights;
    int curIdx;
    int maxWeight;
    int curWeight;

    public WRRLBAlgorithm(int[] weights) {
        this.weights = Arrays.copyOf(weights, weights.length);
        for(int weight: weights)
            this.maxWeight = Math.max(maxWeight,weight);
        this.curWeight = 1;
        this.curIdx = 0;
    }

    @Override
    public int nextServer(){
        while(true){
            if(weights[curIdx]>=curWeight){
                int res = curIdx;
                if(curIdx==0) {
                    curWeight--;
                    if (curWeight <= 0)
                        curWeight = maxWeight;
                }
                curIdx = (curIdx+1) % weights.length;
                return res;
            } else{
                curIdx = (curIdx+1) % weights.length;
            }
        }
    }
}


