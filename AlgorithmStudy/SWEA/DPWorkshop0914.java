
public class PaintingApart {
    public static void main(String[] args) {
        ApartPainter ap = new ApartPainter();
        StickSticker ss = new StickSticker();
        System.out.println("Apart: " + ap.solution());
        System.out.println("Stick: " + ss.solution());

    }

    static class ApartPainter {
        public int solution() {
            int[] dp = new int[9];
            dp[1] = 2;
            dp[2] = 3;
            for (int i = 3; i <= 8; i++) {
                dp[i] = dp[i - 1] + dp[i - 2];
            }
            return dp[8];
        }
    }

    static class StickSticker {
        public int solution() {
            int[] dp = new int[7];
            dp[1] = 2; //
            dp[2] = 5; // *2 + 1
            dp[3] = 12; // *2 + 2
            for (int i = 3; i <= 6; i++) {
                dp[i] = 2 * dp[i - 1] + dp[i - 2];
            }
            return dp[6];
        }
    }

}
