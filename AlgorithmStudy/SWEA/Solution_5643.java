
//SWEA 5643 Professional 키 순서(D4)
import java.io.*;
import java.util.*;

public class Solution_5643 {
    static int N, M; // 정점 수, 간선 수
    static ArrayList<Integer>[] bigger;
    static ArrayList<Integer>[] smaller;

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("test.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            N = Integer.parseInt(br.readLine());
            M = Integer.parseInt(br.readLine());
            bigger = new ArrayList[N + 1];
            smaller = new ArrayList[N + 1];
            for (int i = 0; i <= N; i++) {
                bigger[i] = new ArrayList<>();
                smaller[i] = new ArrayList<>();
            }
            for (int i = 0; i < M; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                bigger[a].add(b); // a가 b보다 작음
                smaller[b].add(a);
            }

            int result = 0;
            /* do */
            for (int i = 1; i <= N; i++) {
                int ctr = 0;
                boolean[] visit = new boolean[N + 1];
                Deque<Integer> q = new ArrayDeque<>();
                q.offer(i);
                visit[i] = true;
                while (!q.isEmpty()) {
                    int cur = q.poll();
                    for (int k = 0; k < bigger[cur].size(); k++) {
                        if (!visit[bigger[cur].get(k)]) {
                            visit[bigger[cur].get(k)] = true;
                            q.offer(bigger[cur].get(k));
                            // System.out.println(i + "is smaller than " + bigger[cur].get(k));
                            ctr++;
                        }
                    }
                }
                visit = new boolean[N + 1];
                q.offer(i);
                while (!q.isEmpty()) {
                    int cur = q.poll();
                    for (int k = 0; k < smaller[cur].size(); k++) {
                        if (!visit[smaller[cur].get(k)]) {
                            visit[smaller[cur].get(k)] = true;
                            q.offer(smaller[cur].get(k));
                            // System.out.println(i + " is bigger than " + smaller[cur].get(k));
                            ctr++;
                        }
                    }
                }
                if (ctr == N - 1) {
                    result++;
                }

            }
            /* print */
            sb.append("#" + t + " " + result + "\n");
        }
        System.out.print(sb);
        br.close();
    }
}
