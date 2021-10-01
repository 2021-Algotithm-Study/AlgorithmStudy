
//4013 [모의 SW 역량테스트] 특이한 자석
import java.io.*;
import java.util.*;

public class Solution_4013 {
    static boolean[][] wheel; // 0이 탑, 2이랑 6 검사하기

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("test.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            int K = Integer.parseInt(br.readLine());
            wheel = new boolean[4][8];
            for (int i = 0; i < 4; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < 8; j++) {
                    wheel[i][j] = Integer.parseInt(st.nextToken()) == 1 ? true : false;
                }
            }

            /* do */
            // k를 읽으면서 돌리면 됨
            // print();
            for (int k = 0; k < K; k++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken()) - 1;
                int b = Integer.parseInt(st.nextToken());
                // roll(cmd[k][0], cmd[k][1]);
                int[] check = new int[4];
                check[a] = b;
                for (int i = a + 1; i < 4; i++) {
                    // 앞으로 나아가면서 돌려주고
                    if (wheel[i - 1][2] != wheel[i][6])
                        check[i] = check[i - 1] * -1;
                    else
                        break;
                }
                for (int i = a - 1; i >= 0; i--) {
                    // 뒤로 돌아가면서 돌려주고
                    if (wheel[i + 1][6] != wheel[i][2])
                        check[i] = check[i + 1] * -1;
                    else
                        break;
                }
                for (int i = 0; i < 4; i++)
                    if (check[i] != 0)
                        roll(i, check[i]);
                // print();
            }
            int result = 0;
            for (int i = 0; i < 4; i++) {
                if (wheel[i][0])
                    result += Math.pow(2, i);
            }
            sb.append("#" + t + " " + result + "\n");
        }
        System.out.print(sb);
        br.close();
    }

    static void roll(int idx, int dir) {
        if (dir > 0) { // 정방향
            boolean temp = wheel[idx][7];
            for (int i = 6; i >= 0; i--) {
                wheel[idx][i + 1] = wheel[idx][i];
            }
            wheel[idx][0] = temp;
        } else { // 시계 역방향
            boolean temp = wheel[idx][0];
            for (int i = 1; i < 8; i++) {
                wheel[idx][i - 1] = wheel[idx][i];
            }
            wheel[idx][7] = temp;
        }
    }

    static void print() {
        for (int i = 0; i < 4; i++) {

            for (int j = 0; j < 8; j++) {
                if (wheel[i][j])
                    System.out.print("1 ");
                else
                    System.out.print("0 ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
