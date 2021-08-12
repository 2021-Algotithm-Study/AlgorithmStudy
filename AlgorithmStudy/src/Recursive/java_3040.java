//3040 归汲 傍林客 老蚌 抄里捞(Bronze 2)
import java.io.*;
import java.util.*;

public class java_3040 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] arr = new int[9];
        int sum = 0;
        for(int i = 0; i < 9; i++){
            arr[i] = Integer.parseInt(br.readLine());
            sum += arr[i];
        }
        sum -= 100;

        loop:for(int i = 0; i < 9; i++){
            for(int j = i; j < 9; j++){
                if((arr[i] + arr[j]) == sum){
                    arr[i] = 0;
                    arr[j] = 0;
                    break loop;
                }
            }
        }

        for(int i = 0; i < 9; i++){
            if(arr[i] != 0) System.out.println(arr[i]);
        }

    }    
}
