//SWEA 1247 [S/W 문제해결 응용] 3일차 - 최적 경로 (D5)
import java.io.*;
import java.util.*;
public class java_1247 {
    static Pair[] customer;
    static boolean[] visit;
    static Pair[] choice;
    static int N, min;
    static Pair start, end;
    static class Pair{
        int first;
        int second;
        Pair(int i, int j){
            first = i;
            second = j;
        }
    }
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("test.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for(int t = 1; t <= T; t++){
            N = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            start = new Pair(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            end = new Pair(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            customer = new Pair[N];
            for(int i = 0; i < N; i++){
                customer[i] = new Pair(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            }
            visit = new boolean[N];
            choice = new Pair[N];
            min = (N+2) * 200;
            //customer를 가까운 순서대로 방문해서 최소거리 내기
            Arrays.sort(customer, (o1, o2)->(Math.abs(start.first-o1.second) - Math.abs(start.first-o2.second)));
            // for(int i = 0; i < N; i++){
            //     System.out.println(customer[i].first + ", " + customer[i].second);
            // }
            for(int i = 0; i < N-1; i++){
                choice[0] = customer[i];
                visit[i] = true;
                permutation(1);
                visit[i] = false;
            }
            sb.append("#" + t + " " + min + "\n");
        }
        System.out.print(sb);
        br.close();
    }

    static void permutation(int ctr){
        //System.out.println("!!");
        if(ctr == N){
            go();
            //for(int i = 0; i < N; i++){
            // System.out.print(choice[i].first + ", " + choice[i].second + "\t");
            // }
            // System.out.println();
            return;
            //min 따져서 return
        }
        for(int i = 0; i < N; i++){
            if(!visit[i]){
                visit[i] = true;
                choice[ctr] = customer[i];
                permutation(ctr+1);
                visit[i] = false;
            }
        }

    }
    //choice 순서대로 방문
    static void go(){
        int x = start.first;
        int y = start.second;
        int dist = 0;
        for(int i = 0; i < N; i++){
            dist += Math.abs(x-choice[i].first) + Math.abs(y-choice[i].second);
            x = choice[i].first;
            y = choice[i].second;
        }
        dist += Math.abs(end.first-x) + Math.abs(end.second-y);
        // for(int i = 0; i < N; i++){
        //     System.out.print(choice[i].first + ", " + choice[i].second + "\t");
        // }
        // System.out.println(dist + " min:" + min);
        min = dist < min ? dist : min; 
    }
}
