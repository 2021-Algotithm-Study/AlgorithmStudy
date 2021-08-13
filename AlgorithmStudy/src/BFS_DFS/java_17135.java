//17135 ĳ�� ���潺(Gold 4)
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
        while(enemy > 0){                   //board�ǿ� enemy�� ���� ������
            cur_kill += archor_attack();    //�ü� �����ϰ�
            enemy_rain();                   //�� �� ĭ ��������
        }
        max_kill = Math.max(max_kill, cur_kill);    //���� ���� kill���� ���� max���� ū�� Ȯ��
    }

    static int archor_attack(){
        boolean[][] temp = new boolean[N][M];
        int kill = 0;
        archor: for(int pos = 0; pos < 3; pos++){   //�ü� ���� ���鼭
            int a = archor[pos];
            //�Ѿ� bfs�� �������ҵ�
            Deque<Pair> queue = new ArrayDeque<>();
            boolean[][]check = new boolean[N][M];
            queue.offer(new Pair(N-1, a));  //�ü� �ٷ� �տ������� ����
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
                        //���� Ž�� �����ѵ� ���� Ž������ �ʾҰ� 
                        //��ġ�� �� �ִ� �Ÿ���� 
                        if(board[nx][ny] == 1){
                            //���� ǥ���ϰ� ���� ��ó�� �Ѿ
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
                    enemy--;            //�� �����ϰ�
                    kill++;             //ų ����
                    board[i][j] = 0;    //�� ���� �����ְ�
                }
            }
        }
        return kill;
    }

    static void enemy_rain(){
        for(int i =N-1; i >= 0; i--){                   //������ row���� �˻��ؼ� 
            for(int j = 0; j < M; j++){                 
                if(board[i][j] == 1){                   //���� ���� ������
                    board[i][j] = 0;                    //���� �ڸ� 0���� �ٲ��ְ�
                    if(i+1 < N)    board[i+1][j] = 1;   //��ĭ �Ʒ��� ���������ְų�
                    else            enemy--;            //�ƴϸ� �� ħ���ؼ� �����
                }
            }
        }
    }

    //archor combination
    static void comb(int start, int ctr){
        if(ctr == 3){
            int temp = enemy;                       //���� enemy����
            int[][] temp_board = clone(board);      //���� board��� ����
            game(); //game������ max_kill������Ʈ
            enemy = temp;                           //temp�� ������ �ٽ� �����ɷ� ����
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
