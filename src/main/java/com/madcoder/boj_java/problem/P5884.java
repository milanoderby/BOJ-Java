package com.madcoder.boj_java.problem;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class P5884 {

    public static void main(String[] args) throws IOException {
        solution(new BufferedReader(new InputStreamReader(System.in)), new BufferedWriter(new OutputStreamWriter(System.out)));
    }

    private static int MAX_POSITION = 1_000_000_001;
    private static boolean canMonitor;
    public static void solution(BufferedReader br, BufferedWriter bw) throws IOException {
        canMonitor = false;
        int N = Integer.parseInt(br.readLine());

        // x: 1을 택할 때, 선택되는 소의 index
        // y: 7을 택할 때, 선택되는 소의 index

        // 특정 포지션을 선택할 때, 선택되는 소의 index를 Map으로 나타낸 것
        Map<Integer, Set<Integer>> positionCowMap = new HashMap<>();
        for (int i = 0; i < N; i++) {
            StringTokenizer tokenizer = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(tokenizer.nextToken());
            int y = Integer.parseInt(tokenizer.nextToken());

            Set<Integer> selectedCowIndex = positionCowMap.getOrDefault(x, new HashSet<>());
            selectedCowIndex.add(i);
            positionCowMap.put(x, selectedCowIndex);

            Set<Integer> selectedCowIndex2 = positionCowMap.getOrDefault(y + MAX_POSITION, new HashSet<>());
            selectedCowIndex2.add(i);
            positionCowMap.put(y + MAX_POSITION, selectedCowIndex2);
        }

        List<Set<Integer>> cowSet = positionCowMap.values()
                .stream()
                .sorted(Comparator.comparing(Set::size, Comparator.reverseOrder()))
                .collect(Collectors.toList());

        canMonitor(0, new ArrayList<>(), new HashSet<>(), N, cowSet);

        if (canMonitor) {
            bw.write("1\n");
        } else {
            bw.write("0\n");
        }
        bw.flush();
    }
    private static void canMonitor(int positionIndex, List<Integer> selectedPositionList, Set<Integer> monitoredCows, int countOfTotalCow, List<Set<Integer>> cowSet) {
        if (monitoredCows.size() >= countOfTotalCow) {
            canMonitor = true;
            return;
        }

        if (selectedPositionList.size() >= 3) {
            return;
        }

        int countOfRestCow = countOfTotalCow - monitoredCows.size();
        for (int index = positionIndex; index < cowSet.size(); index++) {
            if (countOfRestCow > (3 - selectedPositionList.size()) * cowSet.get(index).size()) {
                return;
            }

            selectedPositionList.add(index);
            HashSet<Integer> tempMonitoredCows = new HashSet<>(monitoredCows);
            tempMonitoredCows.addAll(cowSet.get(index));
            canMonitor(positionIndex + 1, selectedPositionList, tempMonitoredCows, countOfTotalCow, cowSet);
            selectedPositionList.remove(selectedPositionList.size() - 1);

            if (canMonitor) {
                return;
            }
        }
    }
}
