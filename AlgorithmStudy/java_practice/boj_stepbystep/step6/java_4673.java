//4673 ¼¿ÇÁ ³Ñ¹ö (Silver 5)
import java.io.*;

public class java_4673 {
    public static void main(String[] args) throws IOException{
        boolean[] r = new boolean[10001];
        for(int i = 1; i <= 10000; i++){
            if(!r[i])
                System.out.println(i);
        int temp = i + selfnum(i);
            if (temp <= 10000)
                r[i + selfnum(i)] = true;
        }
    }

    public static int selfnum(int i){
        if (i < 10) return i;
        return i%10 + selfnum(i/10);
    }
}
