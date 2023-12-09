package com.madcoder.boj_java.problem;

import java.io.*;

public class P5872 {

    public static void main(String[] args) throws IOException {
        solution(new BufferedReader(new InputStreamReader(System.in)), new BufferedWriter(new OutputStreamWriter(System.out)));
    }

    public static void solution(BufferedReader br, BufferedWriter bw) throws IOException {
        String line = br.readLine();

        int toggleCount = 0;
        int countOfOpenParenthesis = 0;
        for (int i = 0; i < line.length(); i++) {
            int restCountOfString = line.length() - i;
            if (countOfOpenParenthesis >= restCountOfString) {
                if (line.charAt(i) == '(') {
                    toggleCount++;
                    countOfOpenParenthesis--;
                }
                continue;
            }

            if (line.charAt(i) == '(') {
                countOfOpenParenthesis++;
            } else if (line.charAt(i) == ')') {
                if (countOfOpenParenthesis <= 0) {
                    toggleCount++;
                    countOfOpenParenthesis++;
                } else {
                    countOfOpenParenthesis--;
                }
            }
        }

        bw.write(toggleCount + "\n");
        bw.flush();
    }
}
