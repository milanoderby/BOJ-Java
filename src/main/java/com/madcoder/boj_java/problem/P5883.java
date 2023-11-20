package com.madcoder.boj_java.problem;

import java.io.*;
import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class P5883 {

    public static void main(String[] args) throws IOException {
        solution(new BufferedReader(new InputStreamReader(System.in)), new BufferedWriter(new OutputStreamWriter(System.out)));
    }

    public static void solution(BufferedReader br, BufferedWriter bw) throws IOException {
        int N = Integer.parseInt(br.readLine());
        int[] B = new int[N];
        for (int i = 0; i < N; i++) {
            B[i] = Integer.parseInt(br.readLine());
        }

        Set<Integer> capacitySet = Arrays.stream(B).boxed().collect(Collectors.toSet());
        int answer = 1;
        for (Integer bannedCapacity : capacitySet) {
            int length = 0;
            int previousCapacity = -1;
            for (int i = 0; i < B.length; i++) {
                int currentCapacity = B[i];
                if (currentCapacity == bannedCapacity) {
                    continue;
                }

                if (previousCapacity == currentCapacity) {
                    length++;
                } else {
                    length = 1;
                    previousCapacity = currentCapacity;
                }
                answer = Math.max(answer, length);
            }
        }
        bw.write(answer + "\n");
        bw.flush();
    }
}
