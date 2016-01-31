import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by qixuanwang on 16/1/29.
 */
public class Hackerrank3 {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner in = new Scanner(System.in);
        String[] line1 = in.nextLine().split(" ");
        int m = Integer.valueOf(line1[0]);
        int n = Integer.valueOf(line1[1]);

        boolean[][] map_origin = new boolean[m][n];
        for(int i=0;i<m;i++){
            String line = in.nextLine();
            for(int j=0;j<n;j++){
                char c = line.charAt(j);
                map_origin[i][j] = (c=='G'? true:false);
            }
        }

        int ans = 0;

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){

                boolean[][] map = new boolean[map_origin.length][];
                for (int k = 0; k < map_origin.length; k++) {
                    map[k] = Arrays.copyOf(map_origin[k], map_origin[k].length);
                }

                int a1 = 1;
                if(map[i][j]){
                    map[i][j] = false;
                    int dis = 1;
                    while(Valid(i-dis,j,map,m,n) && Valid(i+dis,j,map,m,n) && Valid(i,j-dis,map,m,n) && Valid(i,j+dis,map,m,n)){
                        a1+=4;
                        map[i-dis][j] = false;
                        map[i+dis][j] = false;
                        map[i][j-dis] = false;
                        map[i][j+dis] = false;
                        dis++;
                    }

                    for(int x=0;x<m;x++){
                        for(int y=0;y<n;y++){
                            int a2 = 1;
                            boolean[][] map2 = new boolean[map.length][];
                            for (int k = 0; k < map.length; k++) {
                                map2[k] = Arrays.copyOf(map[k], map[k].length);
                            }
                            if(map2[x][y]) {
                                map2[x][y] = false;
                                dis = 1;
                                while (Valid(x - dis, y, map2, m, n) && Valid(x + dis, y, map2, m, n) && Valid(x, y - dis, map2, m, n) && Valid(x, y + dis, map2, m, n)) {
                                    a2 += 4;
                                    map2[x - dis][y] = false;
                                    map2[x + dis][y] = false;
                                    map2[x][y - dis] = false;
                                    map2[x][y + dis] = false;
                                    dis++;
                                }
                                ans = Math.max(ans,a1*a2);
                            }
                        }
                    }
                }

            }
        }

        System.out.print(ans);
    }

    public static boolean Valid(int x, int y, boolean[][] map, int m, int n){
        if(x>=0 && x<m && y>=0 && y<n)
            return map[x][y];
        else
            return false;
    }
}
