import java.util.Scanner;

//2615 ���� (Silver 3)
public class java_2615 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int board[][] = new int[23][23];

        /*Input*/
        for(int i = 0; i < 19; i++)
            for(int j = 0; j < 19; j++)
                board[i][j] = Integer.parseInt(scan.next());
        /*Check*/
        //������ �� �밢��, ������, ������ �Ʒ� �밢��, �Ʒ�
        int dx[] = {-1, 0, 1, 1};
        int dy[] = {1, 1, 1, 0};  

        for(int x = 0; x < 19; x++){
            for(int y = 0; y < 19; y++){
                int color = board[x][y];
                if(color == 0)    continue;   //��ĭ�� �׳� ��������
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
                        //�ݴ��� �˻�
                        nx = x - dx[dir];
                        ny = y - dy[dir];
                        //�ڿ� ģ���� board �ܰų� ���� �ٸ��� ���
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
