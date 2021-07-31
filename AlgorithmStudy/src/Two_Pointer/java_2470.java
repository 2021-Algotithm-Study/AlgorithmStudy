//2470 두 용액 (Gold 5)
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
        //러프하게 생각하면 이중for문 N*N-1 / 2번 돌려서 모든 케이스를 제곱한 값 중 min 찾기
        //1억->1초 100000*100001 = 무조건 시간초과남
        
        //sort해서 양쪽에서 접근하면 더 빠를 것 같은데
        Arrays.sort(liquid);
        int[] answer = new int[2];
        int start = 0;
        int end = N-1;
        int min =  2000000000;  //min값 아래처럼 잡으면 틀림
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
