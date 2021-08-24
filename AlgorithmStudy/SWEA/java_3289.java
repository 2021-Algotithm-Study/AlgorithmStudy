//SWEA 3289 서로소집합
import java.io.*;
import java.util.*;

public class java_3289 {
	static int N, M;	// MAX: 1,000,000	100,000
	static int root[];

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			
			/* input & initialize */
			sb.append("#" + t + " ");
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			root = new int[N + 1];
			for (int i = 1; i <= N; i++)
				root[i] = i;

			/* do */
			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				if (Integer.parseInt(st.nextToken()) == 0) // union
					union(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
				else 										// find
					sb.append(isCollegue(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
			}
			
			sb.append("\n");
		}	//end of testcase
		System.out.println(sb);
		br.close();
	}

	public static void union(int a, int b) {
//		if(root[a] > root[b])	root[a] = b;
//		else					root[b] = a;
		a = findRoot(a);
		b = findRoot(b);
		if (a > b)	root[a] = b;
		else		root[b] = a;
	}
 
	static int findRoot(int x) {
		//Path Compression : 496ms
/*		if(root[x] != x)	root[x] = findRoot(root[x]);	//Path Compression
		return root[x];*/
		//normal : 475ms
		if (root[x] == x)	return x;
		else				return findRoot(root[x]);
	}

	static int isCollegue(int a, int b) {
		if (findRoot(a) == findRoot(b))
			return 1;
		else
			return 0;
	}

}
