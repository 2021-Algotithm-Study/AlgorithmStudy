//SWEA [S/W 문제해결 기본] 6일차 - 계산기2 (D4)
import java.util.*;
import java.io.*;
 
public class java_1223 {

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("test.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        for (int t = 1; t <= 10; t++) {
            br.readLine();
            String origin = br.readLine();
            int result = calc(mid2post(origin));
            sb.append("#" + t + " " + result + "\n");
        }
        System.out.print(sb);
        br.close();
    }
 
    public static String mid2post(String origin) {
        Stack<Character> s = new Stack<>();
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < origin.length(); i++) {
            char c = origin.charAt(i);
            if (c == '*' || c == '+') {
                if (!s.isEmpty() && s.peek() <= c)  while (!s.isEmpty() && s.peek() <= c)   result.append(s.pop());
                s.push(c);
            }
            else{
                result.append(c);
            }
        }
        while (!s.isEmpty())    result.append(s.pop());
        return result.toString();
    }
 
    public static int calc(String postfixExpress) {
        Stack<Integer> s = new Stack<>();
        for (int i = 0; i < postfixExpress.length(); i++) {
            char c = postfixExpress.charAt(i);
            if (c == '*')       s.push((s.pop() * s.pop()));
            else if(c == '+')   s.push((s.pop() + s.pop()));
            else                s.push(c - '0');
        }
        return s.pop();
    }
}