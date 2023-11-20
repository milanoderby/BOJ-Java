package com.madcoder.boj_java.util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FileUtil {
    public static String readFile(String filePath) throws IOException {

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            StringBuilder content = new StringBuilder();
            String line;

            while ((line = reader.readLine()) != null) {
                content.append(line);
                content.append("\n");
            }

            return content.toString().trim();
        }
    }
}
