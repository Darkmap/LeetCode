/**
 * Created by qixuanwang on 15/11/4.
 */
public class Leetcode204 {


    public static void main(String[] args) {

        System.out.println(countPrimes2(11));
    }

    /*
        该方法(http://en.wikipedia.org/wiki/Sieve_of_Eratosthenes), 效率高于n*log(n)
     */
    public static int countPrimes2(int n) {

        if(n<=2){
            return 0;
        }

        boolean[] notPrime = new boolean[n+1];
        notPrime[0] = true;
        notPrime[1] = true;
        for(int i = 2;i*i<n;i++){
            if(!notPrime[i]){
                int idx = i*i;
                while(idx<=n){
                    notPrime[idx]=true;
                    idx+=i;
                }
            }
        }

        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (!notPrime[i])
                ans ++;
        }
        return ans;
    }

    public static int countPrimes(int n) {
        if(n<=2)
            return 0;
        int count = 0;
        for(int i=2;i<n;i++){
            if(isPrime(i)) {
                count++;
                System.out.println(i);
            }
        }
        return count;
    }

    public static boolean isPrime(int n){
        int m = (int)Math.sqrt(n);
        for(int i=2;i<=m;i++){
            if(n%i==0)
                return false;
        }
        return true;
    }
}
