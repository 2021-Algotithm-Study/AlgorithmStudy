//SWEA 1225 암호생성기(D3)
import java.io.*;
import java.util.*;
public class java_1225 {
    public static void main(String[] args) throws Exception{
        //BufferedReader br = new BufferedReader(new FileReader("test.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        for(int t = 1; t <= 10; t++){
            int test_case = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine(), " ");
            Queue<Integer> q = new ArrayDeque<Integer>();
            for(int i = 0; i < 8; i++)
                q.offer(Integer.parseInt(st.nextToken()));
            loop: while(true){
                for(int i = 1; i <= 5; i++){
                    int temp = q.poll() - i;
                    if(temp <= 0){
                        q.offer(0);
                        break loop;
                    }
                    q.offer(temp);
                }
            }
            sb.append("#" + t + " ");
            for(int i = 0; i < 8; i++) 
                sb.append(q.poll() + " ");
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
