//น้มุ 9012 ฐýศฃ(Silver 4) 
import java.io.*;
import java.util.*;

public class java_9012 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while(T-- > 0)
            sb.append(validate(br.readLine()) + "\n");
        System.out.print(sb);
    }

    public static String validate(String temp){
        Stack<Character> st = new Stack<>();
        for(int i = 0; i < temp.length(); i++)
            if(temp.charAt(i) == '(')
                st.push('(');
            else
                if (st.empty() || st.pop() != '(')
                    return "NO";
        return st.empty() ? "YES" : "NO";
    }
    
}
