//SWEA 5215 햄버거 다이어트(D4)
import java.io.*;
import java.util.*;
public class java_5215 {
    static int max;
    static int[][] arr = new int[20][2];
    static boolean[] visit = new boolean[20];
    static int L;
    static int N;
    public static void main(String[] args) throws Exception{
         BufferedReader br = new BufferedReader(new FileReader("test.txt"));
         //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         StringBuilder sb = new StringBuilder();
         int T = Integer.parseInt(br.readLine());
         for(int t = 1; t <= T; t++){
            sb.append("#" + t + " ");
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            N = Integer.parseInt(st.nextToken());
            L = Integer.parseInt(st.nextToken());
            max = 0;
            for(int i = 0; i < N; i++){
                st = new StringTokenizer(br.readLine(), " ");
                arr[i][0] = Integer.parseInt(st.nextToken());
                arr[i][1] = Integer.parseInt(st.nextToken());
            }
            /*do*/
            comb(0, 0, 0);
            sb.append(max + "\n");
         }
         System.out.print(sb);
    }

    //현재 가르키는 친구를 더하느냐 더하지 않느냐 
    public static void comb(int ctr, int score, int cal){
        if(cal > L) return;
        if(ctr == N){
            max = max < score ? score : max;
            return;
        }
        
        comb(ctr+1, score+arr[ctr][0], cal+arr[ctr][1]);
        comb(ctr+1, score, cal);
    }
}


