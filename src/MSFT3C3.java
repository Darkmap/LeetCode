import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Scanner;

/**
 * Created by qixuanwang on 15/9/23.
 */
public class MSFT3C3 {

    public static void main(String[] args) throws FileNotFoundException {

        Scanner in = new Scanner(new File("input.txt"));

//        PrintWriter out = new PrintWriter(new File("output.txt"));

        while(in.hasNext()){
            helper(in.nextLine());
        }

    }

    public static void helper(String line){

        int number = Integer.valueOf(line);

        if(number==1){
            System.out.println("happy 0");
        }
        else{
            int tmpNum = number;


            int count = 0;
            boolean flag = false;
            HashSet<Integer> set = new HashSet<>();
            while(true){
                int newNum = 0;
                while(tmpNum!=0){
                    newNum += (tmpNum%10)*(tmpNum%10);
                    tmpNum/=10;
                }
                count++;

                if(newNum==1){
                    flag=true;
                    break;
                }
                else if(set.contains(newNum)){
                    break;
                }
                set.add(newNum);
                tmpNum = newNum;
            }
            if(flag)
                System.out.println("happy " + count);
            else
                System.out.println("unhappy "+count);

        }
    }

}
