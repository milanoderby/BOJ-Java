package com.madcoder.boj_java.problem.p5883;


import com.madcoder.boj_java.problem.P5883;
import com.madcoder.boj_java.util.FileUtil;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.*;

public class P5883Test {
    private String inputFilePath;
    private String outputFilePath;
    private String tempFilePath;

    @AfterEach
    public void validateAnswer() throws IOException {
        P5883.solution(new BufferedReader(new FileReader(inputFilePath)), new BufferedWriter(new FileWriter(tempFilePath)));

        String content1 = FileUtil.readFile(tempFilePath);
        String content2 = FileUtil.readFile(outputFilePath);

        Assertions.assertEquals(content1, content2);
    }

    @Test
    public void test1() {
        inputFilePath = "src/test/java/com/madcoder/boj_java/problem/p5883/input1.txt";
        outputFilePath = "src/test/java/com/madcoder/boj_java/problem/p5883/output1.txt";
        tempFilePath = "src/test/java/com/madcoder/boj_java/problem/p5883/temp.txt";
    }
}
