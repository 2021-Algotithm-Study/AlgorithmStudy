import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class sol {
   public static int [][] map = new int[21][21];
   
   public static boolean isFive(int x, int y) {
      if(map[x][y] == 0) return false;
      int cnt;
      
      
      // ������ ���� 5������ ����� �� �ִ���
      // 5���� ä���� ĭ�� �����鼭 �� ������ ���� �ִ� ���� ���� ���� �ƴϾ�� �Ѵ�.(�����̾�� �ϹǷ�)
      if(x-4 > 0 && y+4 < 20 && map[x+1][y-1] != map[x][y]) {
         cnt = 1;
         int nextX = x-1, nextY = y+1;
         for(int i=0; i<4; i++) {
            if(map[nextX--][nextY++] == map[x][y]) cnt++;
         }
         
         if(cnt == 5) {
            if(nextX <= 0 || nextY >= 20 || map[nextX][nextY] != map[x][y]) return true;
         }
      }
      
      // ���������� 5������ ����� �� �ִ���
      // 5���� ä���� ĭ�� �����鼭 �� ������ ���� �ִ� ���� ���� ���� �ƴϾ�� �Ѵ�.(�����̾�� �ϹǷ�)
      if(y + 4 < 20 && map[x][y-1] != map[x][y]) {
         cnt = 1;
         int nextY = y+1;
         for(int i=0; i<4; i++) {
            if(map[x][nextY++] == map[x][y]) cnt++;
         }
         if(cnt == 5) {
            if(nextY >= 20 || map[x][nextY] != map[x][y]) return true;
         }
      }
      
      // ������ �Ʒ��� 5������ ����� �� �ִ���
      // 5���� ä���� ĭ�� �����鼭 �� ������ ���� �ִ� ���� ���� ���� �ƴϾ�� �Ѵ�.(�����̾�� �ϹǷ�)
      if(x + 4 < 20 && y+4 < 20 && map[x-1][y-1] != map[x][y]) {
         cnt = 1;
         int nextX = x+1, nextY = y+1;
         for(int i=0; i<4; i++) {
            if(map[nextX++][nextY++] == map[x][y]) cnt++;
         }
         
         if(cnt == 5) {
            if(nextX >= 20 || nextY >= 20 || map[nextX][nextY] != map[x][y]) return true;
         } 
      }
      
      // �Ʒ��� 5������ ����� �� �ִ���
      // 5���� ä���� ĭ�� �����鼭 �� ������ ���� �ִ� ���� ���� ���� �ƴϾ�� �Ѵ�.(�����̾�� �ϹǷ�)
      if(x + 4 < 20 && map[x-1][y] != map[x][y]) {
         cnt = 1;
         int nextX = x+1;
         for(int i=0; i<4; i++) {
            if(map[nextX++][y] == map[x][y]) cnt++;
         }
         
         if(cnt == 5) {
            if(nextX >= 20 || map[nextX][y] != map[x][y]) return true;
         }
      }
      
      return false;
   }
   
   public static void main(String[] args){
      Scanner sc = new Scanner(System.in);
      
      // �Է�
      for(int i=1; i<=19; i++) {
         for(int j=1; j<=19; j++ ) {
            map[i][j] = sc.nextInt();
         }
      }
      
      for(int i=1; i<=19; i++) {
         for(int j=1; j<=19; j++) {
            // (i, j) �������� ������ �����Ǹ� ��� �� ����
            if(isFive(i, j)) {
               System.out.println(map[i][j]);
               System.out.println(i + " " + j);
               return;
            }
         }
      }

      // �ºΰ� ���� ���� ����
      System.out.println(0);
   }
}