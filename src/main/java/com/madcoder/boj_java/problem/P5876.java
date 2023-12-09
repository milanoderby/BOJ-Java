package com.madcoder.boj_java.problem;

import java.io.*;

public class P5876 {

    public static void main(String[] args) throws IOException {
        solution(new BufferedReader(new InputStreamReader(System.in)), new BufferedWriter(new OutputStreamWriter(System.out)));
    }

    private static int answer;
    private static int N;
    private static int[] dy = {-1, 1, 0, 0};
    private static int[] dx = {0, 0, -1, 1};
    public static void solution(BufferedReader br, BufferedWriter bw) throws IOException {
        N = Integer.parseInt(br.readLine());

        char[][] board = new char[N][N];
        boolean[][] isVisited = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < N; j++) {
                board[i][j] = line.charAt(j);
            }
        }

        answer = 0;
        if (board[0][0] == '(') {
            isVisited[0][0] = true;
            dfs(0, 0, board, isVisited, true, 1, 1);
        }

        bw.write(answer + "\n");
        bw.flush();
    }

    private static void dfs(int y, int x, char[][] board, boolean[][] isVisited, boolean isOpen, int countOfOpenParenthesis, int countOfParentheses) {
        if (!isOpen && countOfParentheses == 2 * countOfOpenParenthesis) {
            answer = Math.max(answer, countOfParentheses);
            return;
        }

        for (int dir = 0; dir < 4; dir++) {
            int nextY = y + dy[dir];
            int nextX = x + dx[dir];

            if (!(0 <= nextY && nextY < N && 0 <= nextX && nextX < N)) {
                continue;
            }

            if (isVisited[nextY][nextX]) {
                continue;
            }

            if (board[nextY][nextX] == '(') {
                if (!isOpen) {
                    continue;
                }
                isVisited[nextY][nextX] = true;
                dfs(nextY, nextX, board, isVisited, true, countOfOpenParenthesis + 1, countOfParentheses + 1);
                isVisited[nextY][nextX] = false;
            } else {
                isVisited[nextY][nextX] = true;
                dfs(nextY, nextX, board, isVisited, false, countOfOpenParenthesis, countOfParentheses + 1);
                isVisited[nextY][nextX] = false;
            }
        }
    }
}
