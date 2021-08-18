//1992 쿼드트리(Silver1)
package Divide_And_Conquer;
import java.io.*;
public class java_1992 {
    static boolean[][] board;
    public static void main(String[] args) throws Exception{
        /*input & initialize*/
        System.setIn(new FileInputStream("test.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        board = new boolean[N][N];
        for(int i = 0; i < N; i++){
            String s = br.readLine();
            for(int j = 0; j < N; j++)  board[i][j] = (s.charAt(j) == '1')? true : false;
        }
        System.out.print(zip(0, 0, N));
        br.close();
        return;
    }

    //시작x, 시작y, 현재 섹션 크기
    static String zip(int x, int y, int section){
        boolean flag = true;
        boolean temp = board[x][y];
        for(int i = x; i < x+section; i++){
            for(int j = y; j < y+section; j++)  {
                temp &= board[x][y];
                if(temp != board[i][j]){
                    flag = false;
                    break;
                }
            }
        }
        if(flag)  return "" + (board[x][y] ? 1 : 0); //거짓이면 모두 맞는 거 아 아닌데
        String res = "(";
        section /= 2;
        res += zip(x, y, section);
        res += zip(x, y + section, section);
        res += zip(x + section, y, section);
        res += zip(x + section, y + section, section);
        res += ")";
        return res;
    }
}
