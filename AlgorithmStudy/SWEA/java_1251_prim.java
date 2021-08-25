//SWEA 1251 [S/W 문제해결 응용] 4일차 - 하나로
import java.io.*;
import java.util.*;
public class java_1251_prim {
    static int N;
    static double E;
    static int[][] island;
    static int[] p;
    static ArrayList<Node>[] nodeList;

    static class Node implements Comparable<Node>{
        int num;
        long len;
        Node(int n, long l){
            num = n;
            len = l;
        }
        @Override
        public int compareTo(Node o) {
            return Long.compare(this.len, o.len);
        }
    }
    
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("test.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for(int t = 1; t <= T; t++){
            N = Integer.parseInt(br.readLine());
            island = new int[N][2];
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for(int i = 0; i < N; i++)  island[i][0] = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine(), " ");
            for(int i = 0; i < N; i++)  island[i][1] = Integer.parseInt(st.nextToken());
            E = Double.parseDouble(br.readLine());
            
            //간선 전부를 저장하는 게 아니라 정점에 따른 특정 정점까지의 거리를 기록한다
            nodeList = new ArrayList[N];    
            for(int i = 0; i < N; i++){
                nodeList[i] = new ArrayList<>();
                for(int j = 0; j < N; j++){ //kruskal에서는 i+1부터 돌렸었다
                    long x = Math.abs(island[i][0] - island[j][0]);
                    long y = Math.abs(island[i][1] - island[j][1]);
                    nodeList[i].add(new Node(j, x*x + y*y));
                }
            }
            //edgeList.sort((o1, o2)->Long.compare(o1.len, o2.len));    //kruskal에만 있었다
            boolean[] visit = new boolean[N];
            PriorityQueue<Node> pq = new PriorityQueue<>();
			pq.add(new Node(0, 0));
			long res = 0;
			int ctr = 0;
			while(!pq.isEmpty()) {
				Node cur = pq.poll();
				if(!visit[cur.num]){
                    visit[cur.num] = true;
                    res += cur.len;
                    if(++ctr == N)	break;
                    for (Node n : nodeList[cur.num])    if(!visit[n.num])	pq.add(n);
        
                }
		    }

            sb.append("#" + t + " " + Math.round(res*E) + "\n");
            //E * (L^2)이 가장 최소가 되도록 모든 섬을 연결하라
            //결국 거리가 최소가 되게 연결하면 됨 대각선 가능
        }
        System.out.print(sb);
        br.close();
    }

}
