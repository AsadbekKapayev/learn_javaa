package com.company._9_io_nio._1_FileWriter;

import java.io.FileWriter;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        var test = "I am test string!";

        FileWriter fw = null;

        try {
            fw = new FileWriter("/home/akapayev/IdeaProjects/LearnJava/src/com/company/_9_io_nio/_1_FileWriter/test.txt", true); // append

            for (int i = 0; i < test.length(); i++) {
                fw.write(test.charAt(i));
            }

//            fw.write(test);

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            fw.close();
        }
    }

}
