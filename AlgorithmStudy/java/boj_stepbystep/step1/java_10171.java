//10171 °í¾çÀÌ(Bronze5)
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class java_10171 {
    public static void main(String[] args) throws IOException{
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String s = "\\    /\\\n )  ( \')\n(  /  )\n \\(__)|";
        bw.write(s);
        bw.flush();
        bw.close();
    }
}
