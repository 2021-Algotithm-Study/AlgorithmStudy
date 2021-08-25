//SWEA 1251 [S/W 문제해결 응용] 4일차 - 하나로
import java.io.*;
import java.util.*;
public class java_1251_kruskal {
    static int N;
    static double E;
    static int[][] island;
    static int[] p;
    static ArrayList<Edge> edgeList;

    static class Edge{
        int from;
        int to;
        long len;
        Edge(int f, int t, long l){
            from = f;
            to = t;
            len = l;
        }
    }
    
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("test.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int t = 1; t <= T; t++){
            N = Integer.parseInt(br.readLine());
            island = new int[N][2];
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for(int i = 0; i < N; i++)  island[i][0] = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine(), " ");
            for(int i = 0; i < N; i++)  island[i][1] = Integer.parseInt(st.nextToken());
            E = Double.parseDouble(br.readLine());
            
            edgeList = new ArrayList<>();
            for(int i = 0; i < N; i++){
                for(int j = i+1; j < N; j++){
                    long x = Math.abs(island[i][0] - island[j][0]);
                    long y = Math.abs(island[i][1] - island[j][1]);
                    edgeList.add(new Edge(i, j, x*x + y*y));
                }
            }
            edgeList.sort((o1, o2)->Long.compare(o1.len, o2.len));
            
            p = new int[N];
            for(int i = 0; i < N; i++)  p[i] = i;

            int cnt = 0;
            long res = 0;
            for(Edge e : edgeList){
                if(union(e.from, e.to)){
                    res += e.len;
                    if(++cnt == N-1)    break;
                }
            }
            System.out.println("#" + t + " " + Math.round(res*E));
            //E * (L^2)이 가장 최소가 되도록 모든 섬을 연결하라
            //결국 거리가 최소가 되게 연결하면 됨 대각선 가능
        }
        br.close();
    }

    static boolean union(int a,  int b){
        if((a = find(a)) == (b = find(b)))  return false;
        p[b] = a;
        return true;
    }

    static int find(int x){
        if(p[x] == x)    return x;
        else            return p[x] = find(p[x]);
    }
}
