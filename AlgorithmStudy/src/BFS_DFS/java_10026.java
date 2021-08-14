//10026 적록색약(Gold 5)
import java.io.*;
import java.util.*;

class Pair{
    int first;
    int second;
    Pair(int x, int y){
        first = x;
        second = y;
    }
}
public class java_10026 {
    static int N;
    static int dx[] = {0, -1, 0, 1};
    static int dy[] = {-1, 0, 1, 0};
    static char[][] board;
    static boolean[][] visit;
    static Deque<Pair> q;
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("test.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));        
        N = Integer.parseInt(br.readLine());
        board = new char[N][N];
        for(int i = 0; i < N; i++){
            String temp = br.readLine();
            for(int j = 0; j < N; j++){
                board[i][j] = temp.charAt(j);
            }
        }
        //bfs 두번 돌린다 색약정상
        int normal = 0;
        visit = new boolean[N][N]; 
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                if(!visit[i][j]){
                    normal++;
                    normal_bfs(i, j, board[i][j]);
                }
            }
        }

        int abs = 0;
        visit = new boolean[N][N]; 
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                if(!visit[i][j]){
                    abs++;
                    abs_bfs(i, j, board[i][j]);
                }
            }
        }
        System.out.print(normal+ " " + abs);

    }

    static void normal_bfs(int x, int y, char color){
        q = new ArrayDeque<>();
        q.offer(new Pair(x, y));
        visit[x][y] = true;
        while(!q.isEmpty()){
            x = q.peek().first;
            y = q.poll().second;
            for(int i = 0; i < 4; i++){
                int nx = x+dx[i];
                int ny = y+dy[i];
                if(nx>= 0 && nx < N && ny >= 0 && ny<N 
                    &&!visit[nx][ny] && board[nx][ny] == color){
                        q.offer(new Pair(nx, ny));
                        visit[nx][ny] = true;
                }
            }
        }
    }

    static void abs_bfs(int x, int y, char color){
        q = new ArrayDeque<>();
        q.offer(new Pair(x, y));
        visit[x][y] = true;
        while(!q.isEmpty()){
            x = q.peek().first;
            y = q.poll().second;
            for(int i = 0; i < 4; i++){
                int nx = x+dx[i];
                int ny = y+dy[i];
                if(nx>= 0 && nx < N && ny >= 0 && ny<N 
                    &&!visit[nx][ny]){
                        if(board[nx][ny] == color || ((color == 'R' || color == 'G') 
                            && (board[nx][ny] == 'R' || board[nx][ny] == 'G'))){
                                q.offer(new Pair(nx, ny));
                                visit[nx][ny] = true;  
                        }
                }
            }
        }
    }
}
