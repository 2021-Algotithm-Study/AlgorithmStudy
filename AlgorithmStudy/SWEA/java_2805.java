//SWEA 2805 농작물 수확하기(D3) 

import java.io.*;
public class java_2805 {
    public static void main(String[] args) throws Exception{
        //BufferedReader br = new BufferedReader(new FileReader("test.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringBuilder sb = new StringBuilder();
        int [][]board = new int[49][49];
        int T = Integer.parseInt(br.readLine());
        for(int t = 1; t <= T; t++){
            int sum = 0;
            int N = Integer.parseInt(br.readLine());
            for(int i = 0; i < N; i++){
                String str = br.readLine();
                for(int j = 0; j < N; j++){
                    board[i][j] = str.charAt(j) - '0';
                    sum += board[i][j];
                }
            }
            /*do*/
            for(int i = 0; i < N/2; i++)
                for(int j = 0; j < N/2-i; j++)
                    sum -= board[i][j];
            for(int i = 0; i < N/2; i++)
                for(int j = N/2+1+i; j < N; j++)
                    sum -= board[i][j];
            for(int i = N/2+1; i<N; i++)
                for(int j = 0; j < i-N/2; j++)
                    sum-= board[i][j];
            for(int i = N/2+1; i < N; i++)
                for(int j = N-i+N/2; j < N; j++)
                    sum-= board[i][j];

            sb.append("#" + t + " " + sum + "\n");
        }   //EOT
        System.out.print(sb);
    }    
}
