//SWEA 1238 [S/W 문제해결 기본] 10일차 - Contact(D4)
import java.io.*;
import java.util.*;
public class java_1238{
    static int[][] contact;
    static int[] visit;
    static HashMap<Integer, ArrayList<Integer>> list;
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("test.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        for(int t = 1; t <= 10; t++){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int L = Integer.parseInt(st.nextToken());
            int X  =Integer.parseInt(st.nextToken());
            contact = new int[101][101];
            visit = new int[101];
            st = new StringTokenizer(br.readLine(), " ");
            for(int i = 0; i < L/2; i++)
                contact[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())] = 1;
            Deque<Integer> q = new ArrayDeque<>();
            q.offer(X);
            visit[X] = 1;
            while(!q.isEmpty()){
                int x = q.poll();
                for(int i = 1; i <= 100; i++){
                    if(contact[x][i] == 1 && visit[i] == 0){
                        q.offer(i);
                        visit[i] = visit[x] + 1;
                    }
                }
            }
            int max = X;
            for(int i = 1; i <= 100; i++){
                if(visit[i] > visit[max]){
                    max = i;
                }
                else if(visit[i] == visit[max]){
                    if(i > max) max = i;
                }
            }
            sb.append("#" + t + " " + max + "\n");
        }
        System.out.print(sb);
        br.close();
    }
}