//정올 1828 냉장고
import java.io.*;
import java.util.*;
public class java_1828 {
    static int N;
    static Chemical arr[];

    static class Chemical implements Comparable<Chemical>{
        int low;
        int high;
        Chemical(int i, int j){
            low = i;
            high = j;
        }
        @Override
        public int compareTo(Chemical o) {
            return Integer.compare(this.high, o.high);
        }
    }
    public static void main(String[] args) throws Exception {
        //System.setIn(new FileInputStream("test.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new Chemical[N];
        for(int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            arr[i] = new Chemical(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }
        Arrays.sort(arr);   //high기준으로 오름차순이라 괜찮음
        int refrigerator = 1;
        int t = arr[0].high;    //얘 넘어가면 안됨 늘림
        for(int i = 0; i < arr.length; i++){
            if(arr[i].low > t){ //어차피 arr[i] high는 t보다 클 텐데 low까지 커 버리면 걍 범위가 다른 거니까 냉장고 구매
                t = arr[i].high;
                refrigerator++;
            }
        }

        System.out.println(refrigerator);
        
        br.close();
    }
}
