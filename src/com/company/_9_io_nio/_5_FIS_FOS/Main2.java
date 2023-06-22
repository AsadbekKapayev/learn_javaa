package com.company._9_io_nio._5_FIS_FOS;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;

public class Main2 {

    public static void main(String[] args) {
        try (var reader = new FileInputStream("/home/akapayev/IdeaProjects/LearnJava/src/com/company/_9_io_nio/_5_FIS_FOS/about-we-are-for.png")) {

            int character;

            while ((character = reader.read()) != -1) {
                System.out.print((char)character);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
