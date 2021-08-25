//2018KAKAO1차 비밀지도 

public class SecretMap {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = {};
        for(int i = 0; i < n; i++){
            arr1[i] = arr1[i] | arr2[i];
        }
        answer = new String[n];
        for(int i = 0; i < n; i++ ){
            StringBuilder sb = new StringBuilder();
            String s = String.format("%16s", Integer.toBinaryString(arr1[i])).replace(" ", "0");
            for(int a = 16-n; a < 16; a++){
                if(s.charAt(a) == '0')    sb.append(" ");
                else                    sb.append("#");
            }
            answer[i] =sb.toString();
        }
        return answer;
    }
}
