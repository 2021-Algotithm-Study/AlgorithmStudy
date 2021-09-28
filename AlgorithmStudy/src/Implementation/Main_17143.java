
import java.io.*;
import java.util.*;

public class Main_17143 {

    static class Shark implements Comparable<Shark> {
        int r;
        int c;
        int s; // 속력
        int d; // 방향
        int z; // 크기

        public Shark(int r, int c, int s, int d, int z) {
            this.r = r;
            this.c = c;
            this.s = s;
            this.d = d;
            this.z = z;
        }

        @Override
        public int compareTo(Shark o) {
            if (this.c == o.c) {
                if (this.r == o.r)
                    return -Integer.compare(this.z, o.z);
                else
                    return Integer.compare(this.r, o.r);
            }
            return Integer.compare(this.c, o.c);
        }

    }

    static int R, C, M;
    static int[][] board;
    static int[][] size;
    static int[][] dir;

    static int[] dy = { 0, -1, 1, 0, 0 }; // 상,하,우,좌
    static int[] dx = { 0, 0, 0, 1, -1 };
    static ArrayList<Shark> list;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        list = new ArrayList<>();
        // 물고기의 r,c는 각각 -1해서 넣어줘야함

        for (int i = 0; i < M; i++) {

            st = new StringTokenizer(br.readLine(), " ");

            int r = Integer.parseInt(st.nextToken()) - 1;
            int c = Integer.parseInt(st.nextToken()) - 1;
            int s = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int z = Integer.parseInt(st.nextToken());
            list.add(new Shark(r, c, s, d, z));
        }

        int time = 0;
        int sum = 0; // 잡은 물고기의 합

        while (time < C) {

            Collections.sort(list, (o1, o2) -> Integer.compare(o1.r, o2.r));

            /* 1. 낚시 */
            // 어차피 삭제하고 바로 break
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i).c == time) {
                    sum += list.get(i).z;
                    list.remove(i);
                    break;
                }
            }

            /* 1. 상어 이동 */
            for (int i = 0; i < list.size(); i++) {

                Shark s = list.get(i);
                int r = s.r;
                int c = s.c;
                int dir = s.d;
                int cnt = s.s;

                while (cnt > 0) {

                    r += dy[dir];
                    c += dx[dir];
                    if (r < 0 || c < 0 || r >= R || c >= C) { // 부딪히면

                        // 다시 값 돌려주고
                        r -= dy[dir];
                        c -= dx[dir];
                        if (dir == 1) {
                            dir = 2;
                        } else if (dir == 2) {
                            dir = 1;
                        } else if (dir == 3) {
                            dir = 4;
                        } else if (dir == 4) {
                            dir = 3;
                        }

                        continue; // 함 박았으니까 cnt 그대로 한 번 다시 돌림(뒤로)
                    }
                    cnt--;
                }
                list.get(i).r = r;
                list.get(i).c = c;
                list.get(i).d = dir;

            }

            // Collections.sort(list, (o1, o2) -> Integer.compare(o1.r, o2.r));

            // r,c 같은 상어 삭제하는 코드 짜야 함
            // Collections.sort(list, (o1, o2) -> -Integer.compare(o1.z, o2.z));
            // Collections.sort(list, (o1, o2) -> Integer.compare(o1.c, o2.c));
            // Collections.sort(list, (o1, o2) -> Integer.compare(o1.r, o2.r));

            // 시간 초과 나서 Comparator를 내부에 작성해서 한번만 sort하게 했는데 96%까지 기껏 가놓고 indexBoudary 뜸
            // 와 미친 list size 쌩으로 넣어주던 거 예외처리해서 통과함
            // 근데 board쓰는 게 300ms 빠름
            if (list.size() > 0) {
                Collections.sort(list);
                ArrayList<Shark> temp = new ArrayList<>();
                temp.add(list.get(0));
                int idx = 0;
                if (list.size() > 1) {

                    for (int i = 1; i < list.size(); i++) {
                        if (i < 0 || i > list.size() - 1)
                            break;
                        if (list.get(i).r == temp.get(idx).r && list.get(i).c == temp.get(idx).c) {
                            list.get(i).z *= -1;
                        } else {
                            temp.add(list.get(i));
                            idx++;
                        }
                    }
                }
                list = temp;
            }
            // Success: board
            // board = new int[R][C];
            // size = new int[R][C];
            // dir = new int[R][C];

            // for (int i = 0; i < list.size(); i++) {
            // int r = list.get(i).r;
            // int c = list.get(i).c;

            // if (board[r][c] == 0) {
            // board[r][c] = list.get(i).z;
            // size[r][c] = list.get(i).s;
            // dir[r][c] = list.get(i).d;
            // } else {
            // if (board[r][c] < list.get(i).z) {
            // board[r][c] = list.get(i).z;
            // size[r][c] = list.get(i).s;
            // dir[r][c] = list.get(i).d;
            // }
            // }
            // }

            // list.clear();

            // for (int i = 0; i < R; i++) {
            // for (int j = 0; j < C; j++) {
            // if (board[i][j] != 0) {
            // list.add(new Shark(i, j, size[i][j], dir[i][j], board[i][j]));
            // }
            // }
            // }
            time++;
        }

        System.out.println(sum);

    }

}