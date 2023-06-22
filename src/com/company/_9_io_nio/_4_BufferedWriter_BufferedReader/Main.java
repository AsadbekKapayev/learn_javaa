package com.company._9_io_nio._4_BufferedWriter_BufferedReader;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        var test = "I am test string!";

        try (var fw = new BufferedWriter(new FileWriter("/home/akapayev/IdeaProjects/LearnJava/src/com/company/_9_io_nio/_4_BufferedWriter_BufferedReader/test.txt"))) {
            for (int i = 0; i < test.length(); i++) {
                fw.write(test.charAt(i));
            }

//            fw.write(test);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
