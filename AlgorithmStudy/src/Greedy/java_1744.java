//1744 ¼ö ¹­±â(Gold 4) 
package Greedy;
import java.io.*;
import java.util.*; 

public class java_1744 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int num[] = new int[N];
        for(int i = 0; i < N; i++)  num[i] = Integer.parseInt(br.readLine());
        Arrays.sort(num);
        int head = 0;
        int tail = N-1;
        int calc = 0;

        while(head < tail){
            if(num[head] < 1 && num[head+1] < 1)    calc += num[head]*num[head+1];
            else    break;
            head+=2;
        }
        while(tail > 0){
            if(num[tail] > 1 && num[tail -1] > 1) calc += num[tail] * num[tail-1];
            else    break;
            tail -= 2;
        }
        while(tail >= head)     calc += num[tail--];
        System.out.println(calc);
        br.close();
    }
}
