import java.io.*;
import java.util.*;

public class java_1208{
    public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new FileReader("input.txt"));
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int box[] = new int[100];
		String temp;
		loop: for(int t = 1; t <= 10; t++) {
			int dump = Integer.parseInt(br.readLine());	
			temp = br.readLine();
			StringTokenizer st = new StringTokenizer(temp, " ");
			for(int i = 0; i < 100; i++) 
				box[i] = Integer.parseInt(st.nextToken());
			for(int i = 1; i <= dump; i++) {
				Arrays.sort(box);
				if(box[0] == box[99])	break loop;
				++box[0];
				--box[99];
			}
			Arrays.sort(box);
			sb.append("#" + t + " " + (box[99] - box[0])).append("\n");
		}
		System.out.println(sb);
	}
}