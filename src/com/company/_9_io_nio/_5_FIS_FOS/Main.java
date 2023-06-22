package com.company._9_io_nio._5_FIS_FOS;

import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        var test = "I am test string!";

        try (var fw = new FileOutputStream("/home/akapayev/IdeaProjects/LearnJava/src/com/company/_9_io_nio/_5_FIS_FOS/about-we-are-for.png")) {
            for (int i = 0; i < test.length(); i++) {
                fw.write(test.charAt(i));
            }

//            fw.write(test);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
