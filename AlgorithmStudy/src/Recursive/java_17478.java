import java.util.Scanner;

public class java_17478 {
    
   public static void main(String[] args) {
       Scanner scan = new Scanner(System.in);
       int num = scan.nextInt();
       System.out.println("��� �� ��ǻ�Ͱ��а� �л��� ������ �������� ã�ư� ������.");
       recursive(0, num);
   } 
   //0 4 8 12 16 
   public static void recursive(int n, int des){
       
       String s = "";
       for(int i = 1; i <= n*4; i++){
           s += "_";
       }
        System.out.println(s+ "\"����Լ��� ������?\"");
        if(n == des)  {
            System.out.println(s+ "\"����Լ��� �ڱ� �ڽ��� ȣ���ϴ� �Լ����\"");
        }else{
            
            System.out.println(s+ "\"�� ����. �������� �� �� ����⿡ �̼��� ��� ������ ����� ������ �־���.");
            System.out.println(s+ "���� ������� ��� �� ���ο��� ������ ������ �߰�, ��� �����Ӱ� ����� �־���.");
            System.out.println(s + "���� ���� ��κ� �ǾҴٰ� �ϳ�. �׷��� ��� ��, �� ���ο��� �� ���� ã�ƿͼ� ������.\"");
            recursive(n+1, des);
        }
        System.out.println(s+ "��� �亯�Ͽ���.");
        return;
    }
}
