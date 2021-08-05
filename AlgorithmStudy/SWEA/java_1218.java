//SWEA 1218 °ýÈ£ Â¦ ¸ÂÃß±â(D4)
import java.io.*;
import java.util.*;

public class java_1218{
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new FileReader("test.txt"));
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        for(int t = 1; t <= 10; t++){
            int len = Integer.parseInt(br.readLine());
            sb.append("#" + t + " " + validate(br.readLine(), len) + "\n");
        }
        System.out.print(sb);
    }

    public static int validate(String str, int len){
        Stack<Character> stack = new Stack<>();
            for(int i = 0; i < len; i++){
                char pivot = str.charAt(i);
                if(pivot == '(' || pivot == '[' || pivot == '{' || pivot == '<')
                    stack.add(str.charAt(i));
                else{
                    if(stack.isEmpty())
                        return 0;
                    else{
                        char temp = stack.pop();
                        if(str.charAt(i) == ')'){
                            if(temp != '(')                 return 0;
                        }else{
                            if(str.charAt(i) - temp != 2)   return 0;
                        }
                    }
                }
            }
            return 1;
    }
}