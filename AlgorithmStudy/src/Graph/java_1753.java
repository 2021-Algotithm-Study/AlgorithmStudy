package Graph;
import java.util.*;
import java.io.*;
public class java_1753 {
    static int V, E, K;
    static int[] dist;
    static boolean[] visit;
    static ArrayList<Node>[] list;

    static class Node implements Comparable<Node>{
        int index;
        int weight;
        public Node(int i, int w){
            index = i;
            weight = w;
        }
        @Override
        public int compareTo(Node o) {
            return this.weight - o.weight;
        }
        
    }
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("test.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        StringBuilder sb = new StringBuilder();
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(br.readLine());
        dist = new int[V+1];        //K가 각 정점까지 도달하는 최소비용
        visit = new boolean[V+1];
        list = new ArrayList[V+1];
        for(int i = 1; i <= V; i++) list[i] = new ArrayList<>();
        Arrays.fill(dist, Integer.MAX_VALUE);   //최댓값으로 초기화
        dist[K] = 0;
        for(int i = 0; i < E; i++){
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            list[a].add(new Node(b, w));
        }
        
        da();

        for(int i = 1; i <= V; i++){
            if(dist[i] == Integer.MAX_VALUE)    sb.append("INF\n");
            else                                sb.append(dist[i] + "\n");
        }
        System.out.println(sb);
        br.close();
    }

    static void da(){
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(K, 0));
        while(!pq.isEmpty()){
            Node temp = pq.poll();
            if(!visit[temp.index]){
                visit[temp.index] = true;
                for(Node n : list[temp.index]){
                    if(dist[n.index] > dist[temp.index]+n.weight){
                        dist[n.index] = dist[temp.index] + n.weight;
                        pq.add(new Node(n.index, dist[n.index]));
                    }
                }
            }
        }
    }
}
