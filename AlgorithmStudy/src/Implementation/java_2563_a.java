// 2563 »öÁ¾ÀÌ(Silver 5)
import java.util.*;
import java.io.*;

public class java_2563_a {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        boolean[][] board = new boolean[101][101];
        int N = Integer.parseInt(br.readLine());
        for(int n = 0; n < N; n++){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            for(int i = 0; i < 10; i++){
                for(int j = 0; j < 10; j++){
                    board[x+i][y+j] = true;
                }
            }
        }
        int ctr = 0;
        for(int i = 0; i < 100; i++){
            for(int j = 0; j < 100; j++){
                if(board[i][j]) ctr++;
            }
        }
        System.out.println(ctr);
        br.close();
    }
}
