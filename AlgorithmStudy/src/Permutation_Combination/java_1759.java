//1759 암호 만들기(Gold 5)
package Permutation_Combination;
import java.io.*;
import java.util.*;
public class java_1759 {
    static int L;
    static int C;
    static char[] charset;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws Exception{
        /*input & initialize*/
        System.setIn(new FileInputStream("test.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        charset = new char[C];
        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < C; i++)  charset[i] = st.nextToken().charAt(0);

        /*do*/
        Arrays.sort(charset);
        
        //for(char c:charset) sb.append(c + " ");
        
        knapsack(0, 0, new char[L]);
        System.out.print(sb);

        br.close();
    }

    static void knapsack(int i, int ctr, char []a){
        if(ctr == L)   {
            //최소 한개의 모음과 두개의 자음
            int vowel = 0;
            int cons = 0;
            for(char c: a){
                if(c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') vowel++;
                else    cons++;    
            }
            if(vowel >= 1 && cons >= 2){
                for(char c: a)  sb.append(c);
                sb.append("\n");
            }
            return;
        }
        if(i == C)  return;
        a[ctr] = charset[i];
        knapsack(i+1, ctr+1, a);
        knapsack(i+1, ctr, a);

    }
}
