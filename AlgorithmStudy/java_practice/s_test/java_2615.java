import java.util.Scanner;

//2615 오목 (Silver 3)
public class java_2615 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int board[][] = new int[23][23];

        /*Input*/
        for(int i = 0; i < 19; i++)
            for(int j = 0; j < 19; j++)
                board[i][j] = Integer.parseInt(scan.next());
        /*Check*/
        //오른쪽 위 대각선, 오른쪽, 오른쪽 아래 대각선, 아래
        int dx[] = {-1, 0, 1, 1};
        int dy[] = {1, 1, 1, 0};  

        for(int x = 0; x < 19; x++){
            for(int y = 0; y < 19; y++){
                int color = board[x][y];
                if(color == 0)    continue;   //빈칸은 그냥 지나간다
                for(int dir = 0; dir < 4; dir++){
                    int ctr = 1;
                    int nx = x;
                    int ny = y;
                    while (ctr <= 5){
                        nx += dx[dir];
                        ny += dy[dir];
                        if((nx >= 0 && ny >= 0 && nx < 19  && ny < 19) && board[nx][ny] == color){
                            ctr++;
                            System.out.println(x + "," + y + "->" + nx + "," + ny + " ctr: "+ ctr + " [" + board[nx][ny] + "]");
                        }else{
                            break;
                        }
                    }
                    if (ctr == 5){
                        //System.out.print("Check");
                        //반대쪽 검사
                        nx = x - dx[dir];
                        ny = y - dy[dir];
                        //뒤에 친구가 board 외거나 색이 다르면 찐답
                        if(!(nx >= 0 && ny >= 0 && nx < 19  && ny < 19) || board[nx][ny] != color){
                            System.out.println(board[x++][y++]);
                            System.out.println(x + " " + y);
                            return;
                        }
                    }
                }
                

            }
        }

        System.out.println("0");
    }
}
