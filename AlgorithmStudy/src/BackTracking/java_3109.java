//3109 »§Áý(Gold2)
package BackTracking;
import java.io.*;
import java.util.*;
public class java_3109 {
    static int R, C, answer;
    static boolean[][] board;
    static int[] dx = {-1, 0, 1};
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("test.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        board = new boolean[R][C];
        for(int i = 0; i < R; i++){
            String temp = br.readLine();
            for(int j = 0; j < C; j++){
                board[i][j] = (temp.charAt(j) == '.') ? true : false;
            }
        }
        answer = 0;
        for(int i = 0; i < R; i++)  answer += robTheGas(i, 0); 
        System.out.print(answer);
        br.close();
    }

    static int robTheGas(int x, int y){
        if(y == C-1)    return 1;
        for(int i = 0; i < 3; i++){
            int nx = x + dx[i];
            int ny = y + 1;
            if((nx >= 0 && nx < R && ny >= 0 && ny < C) && board[nx][ny]){
                board[nx][ny] = false;
                if(robTheGas(nx, ny) == 1)   return 1;
            }
        }
        return 0;
    }
}
