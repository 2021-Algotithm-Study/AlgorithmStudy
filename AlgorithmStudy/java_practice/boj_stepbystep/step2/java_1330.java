//1330 두 수 비교하기 (bronze 4)
import java.io.*;
import java.util.Scanner;

public class java_1330 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Scanner scan = new Scanner(System.in);
        int a = scan.nextInt();
        int b = scan.nextInt();
        System.out.printf("%s", a < b ? "<" : 
                                (a > b ? ">" : "=="));
    }
}
