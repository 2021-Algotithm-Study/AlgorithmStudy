import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class java_1204 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new FileReader("test.txt"));
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for(int t = 1; t <= T; t++){
            br.readLine();
            sb.append("#").append(t);
            int[] score = new int[101];
            String s = br.readLine();
            StringTokenizer st = new StringTokenizer(s, " ");
            for(int i = 0; i < 1000; i++)
                score[Integer.parseInt(st.nextToken())]++;
            int max = score[0];
            int max_i = 0;
            for(int i = 1; i <= 100; i++){
                if((max < score[i]) || (max == score[i] && max_i < i)){
                    max = score[i];
                    max_i = i;
                }
            }
            sb.append(" ").append(max_i).append("\n");
            
        }
        System.out.print(sb);
    }
}
