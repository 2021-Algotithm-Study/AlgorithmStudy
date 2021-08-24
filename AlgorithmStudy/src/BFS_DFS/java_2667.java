//2667 단지번호붙이기(Silver1)
import java.io.*;
import java.util.*;
public class java_2667 {
    static int N;
    static boolean[][] board;
    static int[] dx = {0, -1, 0, 1};
    static int[] dy = {-1, 0, 1, 0};
    public static void main(String[] args) throws Exception{
        //System.setIn(new FileInputStream("test.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        board = new boolean[N][N];
        for(int i = 0; i < N; i++){
            String temp = br.readLine();
            for(int j = 0; j < N; j++){
                board[i][j] = (temp.charAt(j) == '1') ? true : false;
            }
        }
        int total = 0;
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                if(board[i][j]){
                    total++;
                    list.add(dfs(i, j));
                }
            }
        }
        System.out.println(total);
        Collections.sort(list);
        for(int i : list)   System.out.println(i);      
        br.close();
    }   

    static int dfs(int x, int y){
        int result = 1;
        board[x][y] = false;
        for(int i = 0; i < 4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];
            if((nx >= 0 && nx < N && ny >= 0 && ny < N) && board[nx][ny])
                result += dfs(nx, ny);
        }
        return result;
    }
}
