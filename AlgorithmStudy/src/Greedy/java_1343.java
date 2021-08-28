//1343 폴리오미노(Silver 5)
package Greedy;

import java.io.*;
import java.util.*;

public class java_1343 {
    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("test.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        char[] board = s.toCharArray();
        int valid = 0;
        // board 탐색이 끝난 경우도 처리하기 위해 for문을 board 범위 넘어가게 돌린다
        for (int i = 0; i <= board.length; i++) {
            if (i == board.length || board[i] == '.') {
                if (valid % 2 != 0) {
                    System.out.println(-1);
                    return;
                }
                // int start = i - valid;// 얘부터 valid개만큼 돈다
                while (valid > 0) {
                    if (valid >= 4) {
                        Arrays.fill(board, i - valid, i - valid + 4, 'A');
                        valid -= 4;
                    } else {
                        Arrays.fill(board, i - valid, i - valid + 2, 'B');
                        valid -= 2;
                    }
                }
            } else {
                valid++;
            }
        }
        System.out.println(new String(board));

    }
}
