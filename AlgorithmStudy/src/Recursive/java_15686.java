//15686 ġŲ ���(Gold 5)
import java.io.*;
import java.util.*;
public class java_15686 {
    static int N, M;
    static int dist = Integer.MAX_VALUE;
    static Pair[] home;
    static Pair[] chicken;
    static int h;
    static int c;                           //ġŲ�� ����
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
                if(temp == 1)    home[h++] = new Pair(i, j);   //���̸� ����
                if(temp == 2)    chicken[c++] = new Pair(i, j);
            }
        }
        /*do */
        //M�� ġŲ�� ����� ����� �� üũ�ϸ鼭->dist���
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
        //�� ġŲ�� pick�̶� home������ �ϱ�
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
