//1987 ¾ËÆÄºª(Gold 4)
package BackTracking;
import java.io.*;
import java.util.*;
public class java_1987 {
    static int R, C;
    static char[][] board;
    static int max;

    static int dx[] = {-1, 0, 1, 0};
    static int dy[] = {0, 1, 0, -1};
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("test.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        board = new char[R][C];
        for(int i = 0; i < R; i++){
            String temp = br.readLine();
            for(int j = 0; j < C; j++){
                board[i][j] = temp.charAt(j);
            }
        }
        max = 1;
        /*do*/
        dfs(0, 0, ""+board[0][0]);
        System.out.print(max);

        br.close();
    }
    static void dfs(int x, int y, String s){
        for(int i = 0; i < 4; i++){
            int nx = x + dx[i];
            int  ny = y + dy[i];
            if(nx >= 0 && nx < R && ny >= 0 && ny < C){
                if(s.contains(""+board[nx][ny])){
                    max = s.length() > max ? s.length() : max;
                }else{
                    dfs(nx, ny, s+board[nx][ny]);
                }
            }
        }
    }
}
