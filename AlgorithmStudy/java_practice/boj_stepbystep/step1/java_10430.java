import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;


public class java_10430{

    public static void main(String[] args) throws IOException{        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String str = br.readLine();
        StringTokenizer st = new StringTokenizer(str, " ");
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        bw.write(Integer.toString((A+B)%C) + "\n");
        bw.write(Integer.toString(((A%C) + (B%C))%C) + "\n");
        bw.write(Integer.toString((A*B)%C) + "\n");
        bw.write(Integer.toString( ((A%C) * (B%C))%C));
        br.close();
        bw.flush();
        bw.close();
    }
}
