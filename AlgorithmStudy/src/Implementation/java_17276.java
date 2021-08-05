//17276 배열 돌리기(Silver 1)
import java.io.*;
import java.util.*;

public class java_17276 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};
		int T = Integer.parseInt(br.readLine());
	    int[][] board = new int[500][500];
		
		for(int t = 0; t < T; t++) {
			st = new StringTokenizer(br.readLine(), " ");
			int N = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
            /*Initialize*/
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				for (int j = 0; j < N; j++) 
					board[i][j] = Integer.parseInt(st.nextToken());
			}

            /*rotate*/
			if(c%360 != 0 ) c = (c+360)/45;
            while(c-- > 0) {
                for(int j = 0; j < N/2; j++) {				
                    int x = j;
                    int y = j;		
                    int first = board[x][y];
                    
                    int d = 0;
                    while(d < 4) {
                        int nx = x + dx[d]*(N/2-j);
                        int ny = y + dy[d]*(N/2-j);
                        if(nx >= j && nx < N-j && ny >= j &&  ny < N-j) {
                            board[x][y] = board[nx][ny];
                            x = nx;
                            y = ny;
                        }else {
                            d++;
                        }
                    }   //End Of 
                    board[x][y+(N/2-j)] = first;
                }//End Of
            }
			
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) 
                    sb.append(board[i][j]).append(" ");
				sb.append("\n");
			}
		}
        System.out.print(sb);
	}
}
