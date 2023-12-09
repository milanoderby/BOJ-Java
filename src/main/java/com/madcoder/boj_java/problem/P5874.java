package com.madcoder.boj_java.problem;

import java.io.*;

public class P5874 {

    public static void main(String[] args) throws IOException {
        solution(new BufferedReader(new InputStreamReader(System.in)), new BufferedWriter(new OutputStreamWriter(System.out)));
    }
    public static void solution(BufferedReader br, BufferedWriter bw) throws IOException {
        String line = br.readLine();
        int[] countOfFrontLeg = new int[line.length()];
        int tempCountOfFrontLeg = 0;
        for (int i = 0; i + 1 < line.length(); i++) {
            if (line.charAt(i) == '(' && line.charAt(i + 1) == '(') {
                tempCountOfFrontLeg++;
            }
            countOfFrontLeg[i] = tempCountOfFrontLeg;
        }

        int answer = 0;
        for (int i = 0; i + 1 < line.length(); i++) {
            if (line.charAt(i) == ')' && line.charAt(i + 1) == ')') {
                answer += countOfFrontLeg[i];
            }
        }
        bw.write(answer + "\n");
        bw.flush();
    }
}
