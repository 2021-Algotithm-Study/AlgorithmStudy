//1008 A/B(Bronze 4)
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class java_1008 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String str = br.readLine();
        StringTokenizer st = new StringTokenizer(str, " ");
        double a = Double.parseDouble(st.nextToken()) / Double.parseDouble(st.nextToken());
        bw.write(String.valueOf(a));
        br.close();
        bw.flush();
        bw.close();
    }
}
