//2869 ������(Bronze 1) 

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
        //day(a-b) + a > v || day(a-b)�� �Ǵ� day�� �ּҰ��� ���ض�
        //day > (v - a) / (a - b) + 1
        //�׷��� �� day(a-b) + a > v ���⼭ �º��� a �ȴ��ص� �� ���� ����
        //�������ϱ� �׳� �� �� �̲������� ġ��
        //(day -1)(a-b) +b +1 >=  v
        System.out.printf("%d", (v-1-b) / (a-b) + 1); 
    }
}
