import java.util.*;
import java.io.*;
 
public class java_1873{
    public static void main(String[] args) throws Exception{
       //BufferedReader  br = new BufferedReader(new FileReader("test.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
       StringBuilder sb = new StringBuilder();
       int T = Integer.parseInt(br.readLine());
       int H, W;
       for(int t = 1; t <= T; t++){
           /*initialize*/
           StringTokenizer st = new StringTokenizer(br.readLine(), " ");
           H = Integer.parseInt(st.nextToken());
           W = Integer.parseInt(st.nextToken());
           char [][]board = new char[H][W];
           for(int i = 0; i < H; i++)
               board[i] = br.readLine().toCharArray();
        
           int len = Integer.parseInt(br.readLine());    //안쓸듯
           String cmd = br.readLine();
           //find tank
           int tank_x = 0;
           int tank_y = 0;
           for(int i = 0; i < H; i++)
               for(int j =0; j < W; j++)
                   if (board[i][j] == '^' || board[i][j] == '>'|| 
                       board[i][j] == '<' || board[i][j] == 'v'){
                           tank_x = i;
                           tank_y = j;
                           break;
                       }
           char d = board[tank_x][tank_y];
 
           int dx[] = {-1, 0, 1, 0};//상우하좌
           int dy[] = {0, 1, 0, -1};
           /*do command*/
           for(int i = 0; i < len; i++){
               switch (cmd.charAt(i)) {
                   case 'U':
                       board[tank_x][tank_y] = '^';
                       d = '^';
                       if(tank_x-1 >= 0 && board[tank_x-1][tank_y] == '.'){
                           board[tank_x--][tank_y] = '.';
                           board[tank_x][tank_y] = d;
                       }
                       break;
                   case 'D':
                       board[tank_x][tank_y] = 'v';
                       d = 'v';
                       if(tank_x+1 < H && board[tank_x+1][tank_y] == '.'){
                           board[tank_x++][tank_y] = '.';
                           board[tank_x][tank_y] = d;
                       }
                       break;
                   case 'L':
                       board[tank_x][tank_y] = '<';
                       d = '<';
                       if(tank_y-1 >= 0 && board[tank_x][tank_y-1] == '.'){
                           board[tank_x][tank_y--] = '.';
                           board[tank_x][tank_y] = d;
                       }
                       break;
                   case 'R':
                       board[tank_x][tank_y] = '>';
                       d = '>';
                       if(tank_y+1 < W && board[tank_x][tank_y+1] == '.'){
                           board[tank_x][tank_y++] = '.';
                           board[tank_x][tank_y] = d;
                       }
                       break;
                   case 'S':   //shoot!! *만 깨고 #은 못 깸.
                       int dir;
                       if(d == '^')        dir = 0;
                       else if(d == '>')   dir = 1;
                       else if(d == 'v')   dir = 2;
                       else                dir = 3;
                       //해당 방향으로 전진하면서
                       int nx = tank_x;
                       int ny = tank_y;
                       while(true){
                           nx += dx[dir];
                           ny += dy[dir];
                           if(!(nx >= 0 && nx < H && ny >= 0 && ny < W) || board[nx][ny] == '#')   break;
                           if(board[nx][ny] == '*'){
                               board[nx][ny] = '.';
                               break;
                           }
                       }
                       break;
               }
           }
           /*print*/
           sb.append("#" + t + " ");
           for(int i = 0; i < H; i++){
               for(int j = 0; j < W; j++){
                   sb.append(board[i][j]);
               }
               sb.append("\n");
           }
 
       }
       System.out.println(sb);
    }
}