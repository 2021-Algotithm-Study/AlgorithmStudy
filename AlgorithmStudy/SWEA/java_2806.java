import java.util.*;
import java.io.*;
public class java_2806 {
    static int N;
    static int answer;
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("test.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for(int t = 1; t <= T; t++){
            N = Integer.parseInt(br.readLine());
            answer = 0;
            for(int i = 1; i <= N; i++) {
                int[] col = new int[N+1];
                col[1] = i;
                setQueen(col, 1);
            }
            sb.append("#" + t + " " + answer + "\n");
        }
        System.out.print(sb);
    }
     public static void setQueen(int[] col, int row) {
        if(row == N) {
            answer++;
        }else {
            for(int i = 1; i <= N; i++) {
                col[row+1] = i;
                if(isValid(col, row+1)) setQueen(col, row+1);
            }
        }
    }

    public static boolean isValid(int[] col, int row) {
       for(int i=1; i < row; i++) {
           if(col[i] == col[row] || (Math.abs(i - row) == Math.abs(col[i] - col[row]))) return false;
        }
        return true;
    }
}
