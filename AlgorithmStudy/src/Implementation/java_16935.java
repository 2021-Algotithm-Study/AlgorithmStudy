//16939 배열 돌리기 3(Silver 2)
import java.io.*;
import java.util.*;

public class java_16935 {
    static int[][] origin = new int[100][100];
    static int[][] copy = new int[100][100];
    static int N, M;
    public static void main(String[] args) throws Exception{
        /*initialize*/
        //BufferedReader br = new BufferedReader(new FileReader("test.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());
        for(int n = 0; n < N; n++){
            st = new StringTokenizer(br.readLine(), " ");
            for(int m = 0; m < M; m++)
                origin[n][m] = Integer.parseInt(st.nextToken());
        }
        /*do command*/
        st = new StringTokenizer(br.readLine(), " ");
        for(int r = 0; r < R; r++){
            int cmd = Integer.parseInt(st.nextToken());
            if(cmd == 1)        rotate1();
            else if(cmd == 2)   rotate2();
            else if(cmd == 3)   rotate3();
            else if(cmd == 4)   rotate4();
            else if(cmd == 5)   rotate5(N/2, M/2);
            else                rotate6(N/2, M/2);
            int temp[][] = origin;
            origin = copy;
            copy = temp;
        }
        /*print*/
        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                sb.append(origin[i][j] + " ");
            }
            sb.append("\n");
        }
        System.out.print(sb);
        br.close();
    }
    /*상하반전*/
    static void rotate1(){
        for(int i = 0; i < N; i++)
            for(int j = 0; j < M; j++)
                copy[i][j] = origin[N-1-i][j];
    }
    /*좌우반전*/
    static void rotate2(){
        for(int i = 0; i < N; i++)
            for(int j = 0; j < M; j++)
                copy[i][j] = origin[i][M-1-j];

    }

    static void rotate3(){
        for(int i = 0; i < M; i++)
            for(int j = 0; j < N; j++)
                copy[i][j] = origin[N-1-j][i];
        int temp = N;
        N = M;
        M = temp;
     
    }

    static void rotate4(){
        for(int i = 0; i < M; i++)
            for(int j = 0; j < N; j++)
                copy[i][j] = origin[j][M-1-i];
        int temp = N;
        N = M;
        M = temp;
    }
    static void rotate5(int n, int m){
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                copy[i][j] = origin[i+n][j];
                copy[i][j+m] = origin[i][j];
                copy[i+n][j+m] = origin[i][j+m];
                copy[i+n][j] = origin[i+n][j+m];
            }
        }

    }
    static void rotate6(int n, int m){
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                copy[i][j] = origin[i][j+m];
                copy[i][j+m] = origin[i+n][j+m];
                copy[i+n][j+m] = origin[i+n][j];
                copy[i+n][j] = origin[i][j];
            }
        }
    }
}
