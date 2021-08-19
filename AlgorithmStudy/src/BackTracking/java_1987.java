//1987 ¾ËÆÄºª(Gold 4)
package BackTracking;
import java.io.*;
import java.util.*;
public class java_1987 {
    static int R, C;
    static int[][] board;
    static int max;

    static int dx[] = {-1, 0, 1, 0};
    static int dy[] = {0, 1, 0, -1};
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("test.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        board = new int[R][C];
        for(int i = 0; i < R; i++){
            String temp = br.readLine();
            for(int j = 0; j < C; j++){
                board[i][j] = temp.charAt(j) - 'A';
            }
        }
        max = 1;
        /*do*/
        dfs(0, 0, new boolean[26], 1);
        System.out.print(max);
        br.close();
    }
    static void dfs(int x, int y, boolean[] visit, int ctr){
        visit[board[x][y]] = true;
        for(int i = 0; i < 4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(nx >= 0 && nx < R && ny >= 0 && ny < C){
                if(!visit[board[nx][ny]])   dfs(nx, ny, visit, ctr+1);
                else    max = ctr > max ? ctr : max;
            }
        }
        visit[board[x][y]] = false;
    }
}
