//17135 캐슬 디펜스(Gold 4)
import java.io.*;
import java.util.*;
public class java_17135 {
    static int[][] board;
    static int N, M, D;
    static int max_kill = 0;
    static int enemy = 0;
    static int[] archor = new int[3];
    static boolean[] visit;
    
    static int[] dx = {0, -1, 0};
    static int[] dy = {-1, 0, 1}; 

    /*game*/
    static void game(){
        int cur_kill = 0;
        while(enemy > 0){                   //board판에 enemy가 없을 때까지
            cur_kill += archor_attack();    //궁수 공격하고
            enemy_rain();                   //적 한 칸 내려오고
        }
        max_kill = Math.max(max_kill, cur_kill);    //현재 게임 kill수가 기존 max보다 큰지 확인
    }

    static int archor_attack(){
        boolean[][] temp = new boolean[N][M];
        int kill = 0;
        archor: for(int pos = 0; pos < 3; pos++){   //궁수 세명 돌면서
            int a = archor[pos];
            //앗씨 bfs로 돌려야할듯
            Deque<Pair> queue = new ArrayDeque<>();
            boolean[][]check = new boolean[N][M];
            queue.offer(new Pair(N-1, a));  //궁수 바로 앞에서부터 시작
            check[N-1][a] = true;
            if(board[N-1][a] == 1){
                temp[N-1][a] = true;
                continue;
            }
            while(!queue.isEmpty()){
                int x = queue.peek().first;
                int y = queue.poll().second;
                for(int i = 0; i < 3; i++){
                    int nx = x + dx[i];
                    int ny = y + dy[i];
                    if(nx >= 0 && nx < N && ny >= 0 && ny < M && !check[nx][ny]
                        && (Math.abs(N-nx) + Math.abs(a-ny)) <= D){
                        //만약 탐색 가능한데 아직 탐색하지 않았고 
                        //해치울 수 있는 거리라면 
                        if(board[nx][ny] == 1){
                            //공격 표시하고 다음 아처로 넘어감
                            temp[nx][ny] = true;
                            continue archor;
                        }
                        else{
                            queue.offer(new Pair(nx, ny));
                            check[nx][ny] = true;
                        }
                    }
                }
            } 
        }
        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                if(temp[i][j]){
                    enemy--;            //적 제거하고
                    kill++;             //킬 따고
                    board[i][j] = 0;    //적 흔적 지워주고
                }
            }
        }
        return kill;
    }

    static void enemy_rain(){
        for(int i =N-1; i >= 0; i--){                   //마지막 row부터 검사해서 
            for(int j = 0; j < M; j++){                 
                if(board[i][j] == 1){                   //적이 남아 있으면
                    board[i][j] = 0;                    //현재 자리 0으로 바꿔주고
                    if(i+1 < N)    board[i+1][j] = 1;   //한칸 아래로 내려보내주거나
                    else            enemy--;            //아니면 성 침략해서 사라짐
                }
            }
        }
    }

    //archor combination
    static void comb(int start, int ctr){
        if(ctr == 3){
            int temp = enemy;                       //기존 enemy수와
            int[][] temp_board = clone(board);      //기존 board모양 저장
            game(); //game돌려서 max_kill업데이트
            enemy = temp;                           //temp의 내용을 다시 기존걸로 연결
            board = temp_board;
            return;
        }
        for(int i = start; i < M; i++){
            if(!visit[i]){
                visit[i] = true;
                archor[ctr] = i;
                comb(i, ctr+1);
                visit[i] = false;
            }
        }
    }

    /*util*/

    static class Pair{
        int first;
        int second;
        Pair(int x, int y){
            first = x;
            second = y;
        }
    }
    static int[][] clone(int[][]a){
        int[][] res = new int[N][M];
        for(int i =0; i < N; i++){
            for(int j = 0; j < M; j++){
                res[i][j] = board[i][j];
            }
        }
        return res;
    }
    
    public static void main(String[] args) throws Exception{
        /*input & initialize */
        BufferedReader br = new BufferedReader(new FileReader("test.txt"));
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());
        board = new int[N][M];
        visit = new boolean[M];
        for(int i =0; i < N; i++){
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0; j < M; j++){
                board[i][j] = Integer.parseInt(st.nextToken());
                if(board[i][j] == 1)    enemy++;
            }
        }
        comb(0, 0);
        System.out.println(max_kill);
        br.close();
    }

}
