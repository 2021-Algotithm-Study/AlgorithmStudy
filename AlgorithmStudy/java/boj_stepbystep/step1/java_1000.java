//1000 A+B(Bronze 5)
//type casting 들어가더라도 둘 다 buffered 쓰는 게 훨씬 빠르다.  
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class java_1000 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String str = br.readLine();
        StringTokenizer st = new StringTokenizer(str, " ");
        int a = Integer.parseInt(st.nextToken()) + Integer.parseInt(st.nextToken());
        bw.write(String.valueOf(a));
        br.close();
        bw.flush();
        bw.close();
    }
}
