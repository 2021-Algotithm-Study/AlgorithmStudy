//다이아몬드 별 찍기
public class diamond {
    public static void main(String[] args) {
        int N = 9;
        int half = N - N / 2;
        // upside
        for (int i = 1; i <= half; i++) {
            for (int j = 1; j <= half + i - 1; j++) {
                if (j <= N - half - i + 1)
                    System.out.print(" ");
                else
                    System.out.print("*");
            }
            System.out.println();
        }
        // downside
        for (int i = 1; i <= N - half; i++) {
            for (int j = 1; j <= N - i; j++) {
                if (j <= i)
                    System.out.print(" ");
                else
                    System.out.print("*");
            }
            System.out.println();
        }
    }
}
