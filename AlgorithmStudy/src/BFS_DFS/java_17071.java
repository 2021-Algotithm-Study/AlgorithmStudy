//17071 ���ٲ���(Gold 1)
import java.io.*;
import java.util.*;
public class java_17071 {
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
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        if(N == K) {
            System.out.print(0);
            return;
        }
        //������ ������ ������ ��ġ�� ¦��/Ȧ���ʿ� �����Ѵٸ� OK
        //�̰� �迭 �Ἥ �����ϰ� ���� �� �� �� ������ ���� �ʳ�..?
        int[][] visit = new int[500001][2];   //¦�� Ȧ��
        for(int i = 0; i < 500001; i++){
            visit[i][0] = -1;
            visit[i][1] = -1;
        }
        
        Deque<Pair> q = new ArrayDeque<>();
	    q.offer(new Pair(N, 0));
        while (!q.isEmpty()){
            int pos = q.peek().first;
            int t = q.peek().second;
            q.poll();
            if (pos <= 500000 && pos >= 0 && visit[pos][t%2] == -1){
                visit[pos][t%2] = t;
                q.offer(new Pair(pos + 1, t + 1));
                q.offer(new Pair(pos - 1, t + 1));
                q.offer(new Pair(pos * 2, t + 1));
            }
	    }

        for (int i = 0; i < 500000; i++){
            K += i;
            if (K > 500000) break;
            if (visit[K][i%2] != -1 && visit[K][i%2] <= i){
                System.out.print(i);
                return; 
            }
	    }
        System.out.print(-1);
    }
}
