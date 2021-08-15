//11000 강의실 배정(Gold 5)
import java.io.*;
import java.util.*;

public class java_11000 {

    static class Pair{
        int first;
        int second;
        Pair(int i, int j){
            first = i;
            second = j;
        }
    };
    public static void main(String[] args) throws Exception{
        System.setIn(new FileInputStream("test.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        List<Pair> course = new ArrayList<>();
        for(int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            course.add(new Pair(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }
        Collections.sort(course, (a, b)-> a.first-b.first);
        PriorityQueue<Integer> rooms = new PriorityQueue<>();
        rooms.offer(course.get(0).second);
        for(int n = 1; n<N; n++){
            if(rooms.peek() <= course.get(n).first)
                rooms.poll();
            rooms.offer(course.get(n).second);
        }
        System.out.println(rooms.size());
        br.close();
    }
}
