
//SWEA 4014 [모의 SW 역량테스트] 활주로 건설
import java.io.*;
import java.util.*;

public class Solution_4014 {
    static int N, L;
    static int[][] board;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            L = Integer.parseInt(st.nextToken());
            board = new int[N][N];
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++)
                    board[i][j] = Integer.parseInt(st.nextToken());
            }

            /* do */
            int ctr = 0;
            for (int i = 0; i < N; i++) {
                int j = 0;
                int l = 1;
                line: while (++j < N) {
                    if (board[i][j] == board[i][j - 1]) {
                        l++;
                    } else if (Math.abs(board[i][j] - board[i][j - 1]) > 1)
                        break;
                    else if (board[i][j] > board[i][j - 1]) {
                        if (l >= L) {
                            l = 1;
                            continue;
                        } else {
                            break;
                        }
                    } else { // 2 1일 경우
                        for (int k = 1; k < L; k++) { // L개만큼 전진하다가 벽에 부딪히거나 달라지는 순간이 오면 break;
                            if (j + k >= N || board[i][j + k] != board[i][j])
                                break line;
                        }
                        j += L - 1;
                        l = 0;
                    }
                }
                if (j == N)
                    ctr++;
                j = 0;
                l = 1;
                line_y: while (++j < N) {
                    if (board[j][i] == board[j - 1][i]) {
                        l++;
                    } else if (Math.abs(board[j][i] - board[j - 1][i]) > 1) {
                        break;
                    } else if (board[j][i] > board[j - 1][i]) {
                        if (l >= L) {
                            l = 1;
                            continue;
                        } else {
                            break;
                        }
                    } else { // 앞으로 치고 나가야 함
                        for (int k = 1; k < L; k++) {
                            if (j + k >= N || board[j + k][i] != board[j][i])
                                break line_y;
                        }
                        j += L - 1;
                        l = 0;
                    }
                }
                if (j == N)
                    ctr++;
            }
            sb.append("#").append(t).append(" ").append(ctr).append("\n");
        }
        System.out.print(sb);

        br.close();
    }
}
