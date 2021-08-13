//15686 치킨 배달(Gold 5)
import java.io.*;
import java.util.*;
public class java_15686 {
    static int N, M;
    static int dist = Integer.MAX_VALUE;
    static Pair[] home;
    static Pair[] chicken;
    static int h;
    static int c;                           //치킨집 갯수
    static Pair[] pick;
    static boolean[] visit = new boolean[13];

    static class Pair{
        int first;
        int second;
        Pair(int i, int j){
            first = i;
            second = j;
        }
    }
    public static void main(String[] args) throws Exception {
        //BufferedReader br = new BufferedReader(new FileReader("test.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        home = new Pair[2*N+1];
        chicken = new Pair[13+1];
        pick = new Pair[M];
        c = 0; 
        h = 0;
        for(int i = 0;i <N; i++){
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0; j <N; j++){
                int temp = Integer.parseInt(st.nextToken());
                if(temp == 1)    home[h++] = new Pair(i, j);   //집이면 저장
                if(temp == 2)    chicken[c++] = new Pair(i, j);
            }
        }
        /*do */
        //M개 치킨집 남기는 경우의 수 체크하면서->dist계산
        choice(0, 0);
        System.out.println(dist);
        br.close();
    }

    static void choice(int start, int ctr){
        if(ctr == M){
            dist = Math.min(dist, calculate());
            return;
        }
        for(int i = start; i < c; i++){
            if(!visit[i]){
                visit[i] = true;
                pick[ctr] = chicken[i];
                choice(i, ctr+1);
                visit[i] = false;
            }
        }
    }

    static int calculate(){
        //고른 치킨집 pick이랑 home가지고 하기
        int sum = 0;
        for(int i = 0; i < h; i++){
            int min = Integer.MAX_VALUE;
            for(int j = 0; j < pick.length; j++){
                min = Math.min( min, 
                                Math.abs(pick[j].first - home[i].first) 
                                + Math.abs(pick[j].second - home[i].second));
            }
            sum+= min;
        }
        return sum;
    }
}
