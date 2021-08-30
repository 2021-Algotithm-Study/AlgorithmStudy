import java.io.*;
import java.util.*;

public class DartGame {
    public static void main(String[] args) {

        Solution sol = new Solution();

        System.out.println(sol.solution("1S2D*3T"));
    }
}

class Solution {
    public int solution(String dartResult) {
        int answer = 0;
        int[] score = new int[3];
        int idx = -1;
        // 점수 받아놨고
        int sum = 0;
        int current = 0;
        for (int i = 0; i < dartResult.length(); i++) {
            // 숫자일때 점수 저장
            if (dartResult.charAt(i) >= '0' && dartResult.charAt(i) <= '9') {

                if (dartResult.charAt(i) == '1' && dartResult.charAt(i + 1) == '0') {
                    score[++idx] = 10;
                    i++;
                } else {
                    score[++idx] = dartResult.charAt(i) - '0';

                }
                continue;

            }
            // 특별상 계산
            else if (dartResult.charAt(i) == '*') {
                if (idx != 0)
                    score[idx - 1] *= 2;
                score[idx] *= 2;
            } else if (dartResult.charAt(i) == '#') {
                score[idx] *= -1;
            }
            // S D T
            else {
                if (dartResult.charAt(i) == 'S') {
                    score[idx] = score[idx];
                } else if (dartResult.charAt(i) == 'D') {
                    score[idx] = score[idx] * score[idx];
                } else {
                    score[idx] = score[idx] * score[idx] * score[idx];
                }
            }
        }
        for (int i = 0; i < 3; i++) {
            answer += score[i];
        }
        // 계산해야지
        return answer;
    }
}