
//1074 Z(Silver1)
package Divide_And_Conquer;
import java.io.*;
import java.util.*;
public class java_1074 {
    static int N, R, C;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        int x = (int)Math.pow(2, N-1);
        int y = (x);
        int ctr = 0;

        while(N-- > 0){
            int move = (int)Math.pow(2, N-1);
            int section = (int)(Math.pow(4, N));
            if(R < x && C < y){ //ù��°
                //x���� y����
                x -= move;
                y -= move;
            }
            else if(R < x && C >= y){   //�ι�°
                //x���� y���ϱ�
                x -= move;
                y += move;
                ctr += (section * 1);
            }
            else if(R >= x && C < y){   //����°
                //x���ϰ� y����
                x += move;
                y -= move;
                ctr += (section * 2);
            }
            else{                       //�׹�°
                //x���ϰ� y���ϱ�
                x += move;
                y += move;
                ctr += (section * 3);
            }

        }
        System.out.println(ctr);
        br.close();
        
    }
}
