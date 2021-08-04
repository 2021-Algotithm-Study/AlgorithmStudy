//SWEA 2001 ÆÄ¸®ÅðÄ¡(D2)
import java.io.*;
import java.util.*;

public class java_2001{
    public static void main(String[] args) throws Exception{
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new FileReader("test.txt"));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        int[][] board = new int[15][15];
        for(int t = 1; t <= T; t++){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            //System.out.printf("!!!%d %d\n", N, M);
            /*initialize*/
            for(int i = 0; i < N; i++){
                st = new StringTokenizer(br.readLine(), " ");
                for(int j = 0; j < N; j++){
                    board[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            int max = -1;
            /*do*/
            for(int i = 0; i <= N-M; i++){
                for(int j = 0; j <= N-M; j++){
                    /*check square*/
                    int cur = 0;
                    for(int x = i; x < i+M; x++){
                        for(int y = j; y< j+M; y++){
                            cur += board[x][y];
                        }
                    }
                    if(max < cur)   max = cur;
                }
            }
            sb.append("#" + t + " " + max + "\n");
        }
        System.out.print(sb);
    }
}