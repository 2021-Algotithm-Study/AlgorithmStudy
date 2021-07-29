//2869 달팽이(Bronze 1) 

import java.io.*;
import java.util.*;

public class java_2869 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //String s = br.readLine();
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int v = Integer.parseInt(st.nextToken());
        //int day = (v/(a-b)) + 1 or 
        //day(a-b) + a > v || day(a-b)가 되는 day의 최소값을 구해라
        //day > (v - a) / (a - b) + 1
        //그런데 꼭 day(a-b) + a > v 여기서 좌변에 a 안더해도 될 수도 있음
        //기찮으니까 그냥 함 덜 미끄러졌다 치고
        //(day -1)(a-b) +b +1 >=  v
        System.out.printf("%d", (v-1-b) / (a-b) + 1); 
    }
}
