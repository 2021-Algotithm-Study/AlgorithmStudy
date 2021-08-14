 //2606 바이러스(Silver 3)
import java.io.*;
import java.util.*;

public class java_2606{
    public static void main(String[] args) throws Exception{
        /*input & initialize*/
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int P = Integer.parseInt(br.readLine());
        int[][]network = new int[N+1][N+1];
        boolean[] visit = new boolean[N+1];
        for(int i = 0; i < P; i++){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            network[x][y] = 1;
            network[y][x] = 1;
        }
        /*do*/
        //Is visit unnecessary?
        int ctr = 0;
        Deque<Integer> q = new ArrayDeque<>();
        q.offer(1);
        visit[1] = true;
        while(!q.isEmpty()){
            int x = q.poll();
            for(int i = 1; i <= N; i++){
                if(network[x][i] == 1 && !visit[i]){
                    visit[i] = true;
                    q.offer(i);
                    ctr++;
                }
            }
        }
        System.out.print(ctr);
        
    }
}