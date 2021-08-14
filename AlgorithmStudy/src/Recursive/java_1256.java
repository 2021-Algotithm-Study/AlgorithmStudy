//1256 사전(Gold 3)
import java.io.*;
import java.util.*;

public class java_1256{
    static int N;
    static int M;
    static int K;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        int arr[][] = new int[N+M+1][N+M+1];
        arr[0][0] = 1;
        for(int i = 1; i<=N+M; i++){
            arr[i][0] = 1;
            for(int j = 1; j <=M && j <= i; j++){
                if(i == j){
                    arr[i][j] =1;
                    continue;
                }
                //조합 dp
                arr[i][j] = arr[i-1][j] + arr[i-1][j-1];
                if(arr[i][j] >= 1000000000) arr[i][j] = 1000000000;
            }
        }
        K--;
        StringBuilder sb = new StringBuilder();
        if(arr[N+M][M] <= K)    System.out.print("-1");
        else{
            for(int i = N+M-1; i >= 0; i--){
                if(i >= M && arr[i][M] > K) sb.append("a");
                else{
                    sb.append("z");
                    K-=arr[i][M--];
                }
            }
            System.out.print(sb);
        }
    }
}