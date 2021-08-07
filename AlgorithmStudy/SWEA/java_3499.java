//SWEA 3499 ∆€∆Â∆Æ º≈«√(D3)
import java.io.*;
import java.util.*;

public class java_3499{
    public static void main(String[] args) throws Exception{
        //BufferedReader br = new BufferedReader(new FileReader("test.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for(int t = 1; t <= T; t++){
            sb.append("#" + t);
            int N = Integer.parseInt(br.readLine());
            String[] arr =new String[N];
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for(int i = 0; i < N; i++) 
                arr[i] = st.nextToken();
            int temp = N%2 == 0 ? N/2 : N/2+1;
            for(int i = 0; i < temp; i++){  //3-> 0 
                sb.append(" " + arr[i]);
                sb.append(" " + (i+temp < N? arr[i+ temp] : ""));
            }
            sb.append("\n");
            
        }
        System.out.print(sb);
        br.close();
    }
}