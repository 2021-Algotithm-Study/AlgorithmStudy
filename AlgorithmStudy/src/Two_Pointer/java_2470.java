//2470 �� ��� (Gold 5)
import java.io.*;
import java.util.*;

public class java_2470 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String input = br.readLine();
        StringTokenizer st = new StringTokenizer(input, " ");
        int[] liquid = new int[N];
        for(int i = 0; i < N; i++)
            liquid[i] = Integer.parseInt(st.nextToken());
        
        if (N == 2){
            System.out.print(liquid[0] + " " + liquid[1]);
            return;
        }
        //�����ϰ� �����ϸ� ����for�� N*N-1 / 2�� ������ ��� ���̽��� ������ �� �� min ã��
        //1��->1�� 100000*100001 = ������ �ð��ʰ���
        
        //sort�ؼ� ���ʿ��� �����ϸ� �� ���� �� ������
        Arrays.sort(liquid);
        int[] answer = new int[2];
        int start = 0;
        int end = N-1;
        int min =  2000000000;  //min�� �Ʒ�ó�� ������ Ʋ��
        // int min = Math.abs(liquid[0] + liquid[N-1]);
        // answer[0] = liquid[start];
        // answer[1] = liquid[end];
        while(start < end){
            int sum = liquid[start] + liquid[end];
            if(min > Math.abs(sum)){
                min = Math.abs(sum);
                answer[0] = liquid[start];
                answer[1] = liquid[end];
                if(sum == 0)    break;
            }
            if(sum < 0)
                start++;
            else
                end--;
        }
        System.out.println(answer[0] + " " + answer[1]);
        
    }

}
