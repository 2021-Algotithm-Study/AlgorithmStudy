//10869 ��Ģ����(Bronze 5)
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class java_10869 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String str = br.readLine();
        StringTokenizer st = new StringTokenizer(str, " ");
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        bw.write(String.valueOf(a+b)+"\n");
        bw.write(String.valueOf(a-b)+"\n");
        bw.write(String.valueOf(a*b)+"\n");
        bw.write(String.valueOf(a/b)+"\n");
        bw.write(String.valueOf(a%b)+"\n");
        br.close();
        bw.flush();
        bw.close();
    }
}
