//2588 °ö¼À(Bronze 4)
import java.io.*;

public class java_2588{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String a = br.readLine();
        String b = br.readLine();
        int sum = 0;
        for(int i = 0; i < 3; i++){
            int temp = Integer.parseInt(a) * (b.charAt(2-i) - '0');
            System.out.println(temp);
            for(int j = 0; j < i; j++)
                temp *= 10;
            sum += temp;
        }
        System.out.println(sum);
    }
}