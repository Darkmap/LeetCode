import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Created by qixuanwang on 15/9/23.
 */
public class MSFT3C2 {

    public static void main(String[] args) throws FileNotFoundException{

        Scanner in = new Scanner(new File("input.txt"));
        int testCases = Integer.valueOf(in.nextLine());

        PrintWriter out = new PrintWriter(new File("output.txt"));

        for(int i=0;i<testCases;i++){
            if(helper(in.nextLine()))
                out.println("Possible");
            else
                out.println("Impossible");
        }

        out.close();
    }

    public static boolean helper(String line){


        int a = Integer.valueOf(line.charAt(0)-'0');
        int b = Integer.valueOf(line.charAt(1)-'0');
        int c = Integer.valueOf(line.charAt(2)-'0');
        int d = Integer.valueOf(line.charAt(3)-'0');

        if(a<b+c+d && b<a+c+d && c<a+b+d && d< a+b+c){
            return true;
        }
        else return false;
    }
}
