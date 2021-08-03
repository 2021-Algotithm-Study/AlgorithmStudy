// SWEA 1954 달팽이 숫자 (D2)
import java.io.*;

public class java_1954 {
    public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new FileReader("input.txt"));
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int dr[] = {0, 1, 0, -1};
		int dc[] = {1, 0, -1, 0};
		for(int t = 1; t <= T; t++) {
			int N = Integer.parseInt(br.readLine());
			int num = 1;
			int r = 0;
			int c = 0;
			int[][]board = new int[N][N];
			board[r][c] = num;
			while(num < N*N) {
				for(int d = 0; d < 4; d++) {
					int nr = r + dr[d];
					int nc = c + dc[d];
					while(nr >= 0 && nr < N && nc >= 0 && nc < N && board[nr][nc] == 0) {
						board[nr][nc] = ++num;
						r = nr;
						c = nc;
						nr = nr + dr[d];
						nc = nc + dc[d];
					}
					
				}
			}
			sb.append("#" + t + "\n");
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					sb.append(board[i][j]+ " ");
				}
				sb.append("\n");
			}
		}
		System.out.print(sb);
	}
}
