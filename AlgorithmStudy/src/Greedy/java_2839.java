//2839 ¼³ÅÁ ¹è´Ş(Bronze1)
package Greedy;
import java.io.*;
import java.util.*;

public class java_2839 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int ctr = 0;
		while(n > 0) {
			if(n % 5 == 0) {
                n -= 5;
				ctr++;
			} 
			else if(n%3 == 0) {
				n -=3;
				ctr++;
			} 
			else if(n>5) {
				n -= 5;
				ctr++;
			}
			else {
				ctr = -1;
				break;
			}
		}
        System.out.println(ctr);
        br.close();
        return;
    }
    
}
