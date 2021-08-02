import java.util.Scanner;

public class java_17478 {
    
   public static void main(String[] args) {
       Scanner scan = new Scanner(System.in);
       int num = scan.nextInt();
       System.out.println("어느 한 컴퓨터공학과 학생이 유명한 교수님을 찾아가 물었다.");
       recursive(0, num);
   } 
   //0 4 8 12 16 
   public static void recursive(int n, int des){
       
       String s = "";
       for(int i = 1; i <= n*4; i++){
           s += "_";
       }
        System.out.println(s+ "\"재귀함수가 뭔가요?\"");
        if(n == des)  {
            System.out.println(s+ "\"재귀함수는 자기 자신을 호출하는 함수라네\"");
        }else{
            
            System.out.println(s+ "\"잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어.");
            System.out.println(s+ "마을 사람들은 모두 그 선인에게 수많은 질문을 했고, 모두 지혜롭게 대답해 주었지.");
            System.out.println(s + "그의 답은 대부분 옳았다고 하네. 그런데 어느 날, 그 선인에게 한 선비가 찾아와서 물었어.\"");
            recursive(n+1, des);
        }
        System.out.println(s+ "라고 답변하였지.");
        return;
    }
}
