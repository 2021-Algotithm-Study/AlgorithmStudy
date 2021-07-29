import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class java_10172 {
    public static void main(String[] args) throws IOException{
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String dog = "|\\_/|\n|q p|   /}\n( 0 )\"\"\"\\\n|\"^\"`    |\n||_/=\\\\__|";
        bw.write(dog);
        bw.flush();
        bw.close();
    }
}
