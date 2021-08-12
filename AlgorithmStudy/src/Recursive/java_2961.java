//2961 도영이가 만든 맛있는 음식(Silver 1)
import java.io.*;
import java.util.*;
public class java_2961 {
    static int N;
    static int[][]arr = new int[10][2];
    static int min = 1000000000;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        for(int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }
        knapsack(0, 1, 0);
        System.out.print(min);
    }

    static void knapsack(int pos, int mul, int sum){
        if(pos == N)  return;
        min = Math.min(min, Math.abs(mul*arr[pos][0] - (sum+arr[pos][1])));
        knapsack(pos+1, mul, sum);
        knapsack(pos+1, mul*arr[pos][0], sum+arr[pos][1]);
    }
}
